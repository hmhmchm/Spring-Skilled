package com.sparta.delivery.dto;

import lombok.Getter;

@Getter
public class OrderRequestDto {
    private Long id; // id를 dto에 넣는 이유는?
    private int quantity;
}
