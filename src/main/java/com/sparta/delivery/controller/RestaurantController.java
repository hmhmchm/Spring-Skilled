package com.sparta.delivery.controller;

import com.sparta.delivery.dto.RestaurantRequestDto;
import com.sparta.delivery.dto.RestaurantResponseDto;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.repository.RestaurantRepository;
import com.sparta.delivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantService restaurantService;

    // 음식점 조회
    @GetMapping("/restaurants")
    public List<RestaurantResponseDto> getRestaurant(){
        return restaurantService.getRestaurant();
    }
    //음식점 등록
    @PostMapping("/restaurant/register")
    public Restaurant createRestaurant(@RequestBody RestaurantRequestDto requestDto){
        Restaurant restaurant = restaurantService.createRestaurant(requestDto);
        return restaurant;
    }
}
