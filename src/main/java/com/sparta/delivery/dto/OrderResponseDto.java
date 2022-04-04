package com.sparta.delivery.dto;

import lombok.Getter;

@Getter
public class OrderResponseDto {
    private Long id;
    private String restaurantName;
    private String name; // 음식명
    private int quantity; // 양
    private int price; // 주문 음식 가격
    private int deliveryFee; // 배달비
    private int totalPrice; // 최종 결제 금액


}
