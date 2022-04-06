package com.sparta.delivery.dto;

import com.sparta.delivery.model.Food;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FoodResponseDto {
    private Long id;
    private String name;
    private int price;

    public FoodResponseDto (Food food){
        this.id = food.getId();
        this.name = food.getName();
        this.price = food.getPrice();
    }
}
