package com.sparta.delivery.model;

import com.sparta.delivery.dto.RestaurantRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor // 기본생성자
@AllArgsConstructor
@Builder
@Entity // DB 테이블 역할을 한다.
public class Restaurant {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue
    @Id
    @Column(name = "RESTAURANT_ID")
    private Long id;

    // 반드시 값을 가지도록 합니다.
    @Column
    private String name; // 음식점 이름

    @Column
    private int minOrderPrice; // 최소주문가격

    @Column
    private int deliveryFee; // 기본 배달

    public Restaurant(RestaurantRequestDto requestDto){
        this.name = requestDto.getName();
        this.minOrderPrice = requestDto.getMinOrderPrice();
        this.deliveryFee = requestDto.getDeliveryFee();
    }
}
