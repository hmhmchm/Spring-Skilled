package com.sparta.delivery.service;

import com.sparta.delivery.dto.RestaurantRequestDto;
import com.sparta.delivery.dto.RestaurantResponseDto;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언.
    public RestaurantResponseDto createRestaurant(RestaurantRequestDto requestDto){
        int minOrderPrice = requestDto.getMinOrderPrice(); // 최소주문가격
        int deliveryFee = requestDto.getDeliveryFee(); // 기본 배달비

        // 최소주문 금액은 1,000 - 100,000
        if (minOrderPrice < 1000 || minOrderPrice > 100000){
            throw new IllegalArgumentException("최소 주문금액은 1,000원이상 100,000원 사이로 입력하세요.");
        }
        // 최소주문 금액은 100원 단위로 입력 가능
        if (minOrderPrice % 100 != 0){
            throw new IllegalArgumentException("최소 주문금액은 100원 단위로만 가능합니다.");
        }
        // 배달비는 0 - 10,000
        if (deliveryFee < 0 || deliveryFee > 10000){
            throw new IllegalArgumentException("배달비는 0원이상 10000원 사이로 입력하세요.");
        }
        // 배달비는 500원 단위로 입력.
        if (deliveryFee % 500 != 0){
            throw new IllegalArgumentException("배달비는 500원 단위로만 가능합니다,");
        }

        Restaurant restaurant = new Restaurant(requestDto);
        restaurantRepository.save(restaurant); // 등록

        return new RestaurantResponseDto(restaurant);
    }

    // 음식점 조회하기
    @Transactional
    public List<RestaurantResponseDto> getRestaurant() {
        List<Restaurant> restaurants = restaurantRepository.findAll(); // 다 가져와서 List에 넣고
        List<RestaurantResponseDto> responseDtoList = new ArrayList<>(); // arrayList 만들고

        for (Restaurant data:restaurants
             ) {
            RestaurantResponseDto responseDto = new RestaurantResponseDto(data); // 생성자에다가 넣고 리스트에 add 까지
            responseDtoList.add(responseDto);
        }

        return responseDtoList;
    }
}
