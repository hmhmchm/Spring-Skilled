package com.sparta.delivery.repository;

import com.sparta.delivery.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findAllByRestaurantId(Long restaurantId);

    boolean existsByNameAndRestaurantId(String name, Long restaurantId);
}
