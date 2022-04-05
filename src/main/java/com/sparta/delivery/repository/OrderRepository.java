package com.sparta.delivery.repository;

import com.sparta.delivery.model.Order;
import com.sparta.delivery.model.OrderStatement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderStatement,Long> {

}
