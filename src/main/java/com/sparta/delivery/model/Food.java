package com.sparta.delivery.model;

import com.sparta.delivery.dto.FoodRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor // 기본생성자
public class Food {
    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private Long restaurantId; // 음식점 DB 테이블 ID

    @Column(nullable = false)
    private String name; // 음식명

    @Column(nullable = false)
    private int price; // 가격

    @ManyToOne(targetEntity = Restaurant.class) // ? 이게 뭘까
    @JoinColumn(nullable = false)
    private Restaurant restaurant;

    public Food(Restaurant restaurant, FoodRequestDto foodRequestDto){
        this.restaurant = restaurant;
        this.name = foodRequestDto.getName();
        this.price = foodRequestDto.getPrice();
    }
}
