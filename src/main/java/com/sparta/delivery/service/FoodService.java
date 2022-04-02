package com.sparta.delivery.service;

import com.sparta.delivery.dto.FoodRequestDto;
import com.sparta.delivery.dto.FoodResponseDto;
import com.sparta.delivery.model.Food;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.repository.FoodRepository;
import com.sparta.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodService {
    private final FoodRepository foodRepository; // 음식
    private final RestaurantRepository restaurantRepository; // 음식점

    @Transactional
    public void createFood(Long restaurantId, List<FoodRequestDto> foodRequestDtoList){

        //음식점 존재하는지 확인
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 음식점 ID 입니다.")
        );

        for (FoodRequestDto requestDto:foodRequestDtoList
             ) {
            // 100원에서 1,000,000원만 입력가능
            if(requestDto.getPrice() < 100 || requestDto.getPrice() > 1000000){
                throw new IllegalArgumentException("가격은 100원에서 1,000,000원 사이만 입력이 가능합니다.");
            }
            // 100원단위만 입력가능
            if (requestDto.getPrice() % 100 !=0) throw new IllegalArgumentException("100원 단위로만 입력이 가능합니다.");
            // 같은 음식점 내에서는 음식 이름이 중복될 수 없다.
            if (foodRepository.existsByNameAndRestaurantId(requestDto.getName(),restaurantId)){
                throw new IllegalArgumentException("중복된 음식이름이 존재합니다.");
            }

            Food food = new Food(restaurant,requestDto); // 생성자 이거 씀.
            foodRepository.save(food);
        }
    }
    //메뉴판 조회하기
    @Transactional
    public List<FoodResponseDto> getFoods(Long restaurantId){
        List<Food> foods = foodRepository.findAllByRestaurantId(restaurantId);
        List<FoodResponseDto> responseDtoList = new ArrayList<>();

        for (Food data:foods
             ) {
            FoodResponseDto foodResponseDto = new FoodResponseDto(data);
            responseDtoList.add(foodResponseDto);
        }
        return responseDtoList;
    }
}
