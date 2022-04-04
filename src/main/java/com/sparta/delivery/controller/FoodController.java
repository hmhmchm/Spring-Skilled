package com.sparta.delivery.controller;

import com.sparta.delivery.dto.FoodRequestDto;
import com.sparta.delivery.dto.FoodResponseDto;
import com.sparta.delivery.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodController {
//    private final FoodRepository foodRepository;
    private final FoodService foodService;

    // 메뉴판 조회
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<FoodResponseDto> getFood(@PathVariable Long restaurantId){
        return foodService.getFoods(restaurantId);
    }

    // 메뉴 등록
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void createMenu(@PathVariable Long restaurantId, @RequestBody List<FoodRequestDto> requestDtoList){
        foodService.createFood(restaurantId, requestDtoList);
    }
}
