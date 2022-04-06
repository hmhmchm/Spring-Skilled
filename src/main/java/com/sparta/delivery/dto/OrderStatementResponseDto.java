package com.sparta.delivery.dto;

import com.sparta.delivery.model.OrderStatementEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter // 에러로 인해 추가한 부분
@NoArgsConstructor // 에러로 추가
public class OrderStatementResponseDto {
    private String restaurantName;
    private List<OrderResponseDto> foods;
    private int deliveryFee;
    private int totalPrice;

    public OrderStatementResponseDto(OrderStatementEntity orderStatementEntity, List<OrderResponseDto> orderResponseDtoList) {
        this.restaurantName = orderStatementEntity.getRestaurantName();
        this.foods = orderResponseDtoList;
        this.deliveryFee = orderStatementEntity.getDeliveryFee();
        this.totalPrice = orderStatementEntity.getTotalPrice();
    }
}
