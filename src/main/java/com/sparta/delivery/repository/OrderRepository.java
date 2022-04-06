package com.sparta.delivery.repository;

import com.sparta.delivery.model.OrderStatementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderStatementEntity,Long> {
}
