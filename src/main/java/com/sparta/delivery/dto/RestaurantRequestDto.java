package com.sparta.delivery.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
public class RestaurantRequestDto {
    private String name;
    private int minOrderPrice;
    private int deliveryFee;

    // @Builder 쓰려면 이 생성자가 있어야 하네
    public RestaurantRequestDto(String name, int minOrderPrice, int deliveryFee) {
        this.name = name;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
    }
}
