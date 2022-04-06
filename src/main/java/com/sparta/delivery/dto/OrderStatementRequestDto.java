package com.sparta.delivery.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderStatementRequestDto {
    private Long restaurantId;
    private List<OrderRequestDto> foods;
}
