package com.sparta.delivery.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
public class FoodRequestDto {
    private Long restaurantId;
    private String name;
    private int price;

    //@Builder 쓰려면 생성자가 있어야한다.
    public FoodRequestDto(Long restaurantId, String name, int price) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.price = price;
    }
}
