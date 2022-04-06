package com.sparta.delivery.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FoodRequestDto {
    //private Long restaurantId;
    private String name;
    private int price;

    //@Builder 쓰려면 생성자가 있어야한다.
    public FoodRequestDto(String name, int price) {
        this.name = name;
        this.price = price;
    }

}
