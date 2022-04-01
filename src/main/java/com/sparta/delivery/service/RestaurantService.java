package com.sparta.delivery.service;

import com.sparta.delivery.dto.RestaurantRequestDto;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Restaurant createRestaurant(RestaurantRequestDto requestDto){
        int minOrderPrice = requestDto.getMinOrderPrice(); // 최소주문가격
        int deliveryFee = requestDto.getDeliveryFee(); // 기본 배달비

        
    }
}
