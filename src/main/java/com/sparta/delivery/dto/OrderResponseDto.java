package com.sparta.delivery.dto;

import com.sparta.delivery.model.OrderEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@NoArgsConstructor // 에러로인해 추가한 부분
public class OrderResponseDto {
    private String name;
    private int quantity;
    private int price;

    public OrderResponseDto(OrderEntity orderEntity) {
        this.name = orderEntity.getName();
        this.quantity = orderEntity.getQuantity();
        this.price = orderEntity.getPrice();
    }
}
