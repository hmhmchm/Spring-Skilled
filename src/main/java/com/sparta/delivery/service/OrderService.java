package com.sparta.delivery.service;

import com.sparta.delivery.repository.FoodRepository;
import com.sparta.delivery.repository.OrderRepository;
import com.sparta.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public void orderFood(Long restaurantId, Long foodId){

    }

}
