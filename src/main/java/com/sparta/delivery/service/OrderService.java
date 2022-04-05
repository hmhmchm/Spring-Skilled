package com.sparta.delivery.service;

import com.sparta.delivery.dto.*;
import com.sparta.delivery.model.Order;
import com.sparta.delivery.model.OrderStatement;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.repository.FoodRepository;
import com.sparta.delivery.repository.OrderRepository;
import com.sparta.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final FoodRepository foodRepository;
    private final FoodService foodService;
    private final RestaurantRepository restaurantRepository;

    // 주문 요청
    @Transactional
    public OrderStatementResponseDto orderFood(OrderStatementRequestDto requestDto){
        // 식당찾고
        Restaurant restaurant = restaurantRepository.findById(requestDto.getRestaurantId()).orElseThrow(
                () -> new IllegalArgumentException("음식점이 없습니다.")
        );

        List<Order> orderList = new ArrayList<>();
        List<OrderResponseDto> orderResponseDtoList = new ArrayList<>();

        List<OrderRequestDto> orderRequestDtoList = requestDto.getOrderRequestDtoList();
        for (OrderRequestDto orderRequestDto : orderRequestDtoList
             ) {
            //허용값 1 ~ 100개
            if(orderRequestDto.getQuantity() < 1 || orderRequestDto.getQuantity() > 100){
                throw new IllegalArgumentException("주문 수량이 맞지 않습니다.");
            }
            //id를 가져와서 주문 음식 관련?
            List<FoodResponseDto> foodResponseDtoList = foodService.getFoods(requestDto.getRestaurantId());
            // for each 로 내가 주문한 음식점중에서 주문 음식을 하나씩 가져ㅑ와
            for (FoodResponseDto foodResponseDto: foodResponseDtoList){
                // 음식점 음식과 주문한 음식 id가 같지 않으면 건너뛰기
                if(!foodResponseDto.getId().equals(orderRequestDto.getId())){
                    continue;
                }
                String foodName = foodResponseDto.getName(); // 음식 이름을 받아와서 넣고
                int quantity = orderRequestDto.getQuantity(); // 주문 requestDto 에서 입력한 양을 가져와서 넣고
                int price = foodResponseDto.getPrice() * quantity; // 음식 개수와 가격을 곱하여 price를 결정

                Order order = new Order(foodName,quantity,price); // 주문 엔터티 생성자에 만들어준 이름,양,금액 생성

                orderList.add(order);
                orderResponseDtoList.add(new OrderResponseDto(order));

            }
        }
        // 주문 음식 총 가격
        int totalPrice = 0;
        for (OrderResponseDto data: orderResponseDtoList
             ) {
            totalPrice += data.getPrice();
        }
        totalPrice += restaurant.getDeliveryFee(); // 배달비까지 합친 전체 주문금액.

        // 주문 음식 가격들의 총 합이 주문 음식점의 최소 주문 가격을 넘지 않을 시 에러 발생시킴.
        if(totalPrice < restaurant.getMinOrderPrice()){
            throw new IllegalArgumentException("최소주문 금액을 넘지 않습니다.");
        }
        // 주문 명세표 생성 (음식점명, 배달비, 총 주문금액, 주문목록)
        OrderStatement orderStatement = new OrderStatement(restaurant.getName(),restaurant.getDeliveryFee(),totalPrice,orderList);
        orderRepository.save(orderStatement);

        return new OrderStatementResponseDto(orderStatement,orderResponseDtoList);
    }

    // 주문 조회
    @Transactional
    public List<OrderStatementResponseDto> orderStatementResponseDtoList(){
        List<OrderStatement> orderStatementList = orderRepository.findAll();
        List<OrderStatementResponseDto> orderStatementResponseDtoList = new ArrayList<>();

        for (OrderStatement orderStatement : orderStatementList
             ) {
            List<OrderResponseDto> orderResponseDtoList = new ArrayList<>();
            for (Order order: orderStatement.getOrder()
                 ) {
                OrderResponseDto orderResponseDto = new OrderResponseDto(order);
                orderResponseDtoList.add(orderResponseDto);
            }
            OrderStatementResponseDto orderStatementResponseDto = new OrderStatementResponseDto(orderStatement,orderResponseDtoList);
            orderStatementResponseDtoList.add(orderStatementResponseDto);
        }
        return orderStatementResponseDtoList;
    }

}
