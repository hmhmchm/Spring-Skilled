package com.sparta.delivery.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor // 기본생성자
public class OrderStatement {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

//    @Column(nullable = false)
    private String restaurantName; // 주문 음식점 이름

//    @Column(nullable = false)
    private int deliveryFee; // 배달비

//    @Column(nullable = false)
    private int totalPrice; // 최종 결제 금액

    @ManyToOne(targetEntity = Restaurant.class) // 이게 왜 필요한지
    @JoinColumn(nullable = false)
    private Restaurant restaurant;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private List<Order> order;

    public OrderStatement(String restaurantName, int deliveryFee, int totalPrice, List<Order> order) {
        this.restaurantName = restaurantName;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
        this.order = order;
    }
}
