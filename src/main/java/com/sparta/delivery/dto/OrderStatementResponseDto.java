package com.sparta.delivery.dto;

import com.sparta.delivery.model.Order;
import com.sparta.delivery.model.OrderStatement;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderStatementResponseDto {
    private String restaurantName;
    private List<OrderResponseDto> orderResponseDtoList;
    private int deliveryFee;
    private int totalPrice;

    public OrderStatementResponseDto(OrderStatement orderStatement, List<OrderResponseDto> orderResponseDtoList) {
        this.restaurantName = orderStatement.getRestaurantName();
        this.orderResponseDtoList = orderResponseDtoList;
        this.deliveryFee = orderStatement.getDeliveryFee();
        this.totalPrice = orderStatement.getTotalPrice();
    }
}
