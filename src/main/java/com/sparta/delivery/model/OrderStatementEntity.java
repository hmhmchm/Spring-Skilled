package com.sparta.delivery.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor // 기본생성자
public class OrderStatementEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String restaurantName; // 주문 음식점 이름

    @Column(nullable = false)
    private int deliveryFee; // 배달비

    @Column(nullable = false)
    private int totalPrice; // 최종 결제 금액

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn
    private List<OrderEntity> orderEntity;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID")
    private Restaurant restaurant;

    public OrderStatementEntity(String restaurantName, List<OrderEntity> foodOrderEntities, int deliveryFee, int totalPrice) {
        this.restaurantName = restaurantName;
        this.orderEntity = foodOrderEntities;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
    }
}
