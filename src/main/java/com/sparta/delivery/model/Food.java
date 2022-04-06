package com.sparta.delivery.model;

import com.sparta.delivery.dto.FoodRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor // 기본생성자
public class Food {
    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name; // 음식명

    @Column(nullable = false)
    private int price; // 가격

    @ManyToOne(targetEntity = Restaurant.class)
    @JoinColumn(name = "RESTAURANT_ID", nullable = false)
    private Restaurant restaurant;

    public Food(Restaurant restaurant, FoodRequestDto foodRequestDto){
        this.restaurant = restaurant;
        this.name = foodRequestDto.getName();
        this.price = foodRequestDto.getPrice();
    }
}
