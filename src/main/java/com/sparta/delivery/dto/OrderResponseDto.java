package com.sparta.delivery.dto;

import com.sparta.delivery.model.Order;
import lombok.Getter;


@Getter
public class OrderResponseDto {
    private String name;
    private int quantity;
    private int price;

    public OrderResponseDto(Order order) {
        this.name = order.getName();
        this.quantity = order.getQuantity();
        this.price = order.getPrice();
    }
}
