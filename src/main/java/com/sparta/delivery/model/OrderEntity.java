package com.sparta.delivery.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자
@Getter
@Entity
public class OrderEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id; // 주문요청 id

    @Column(nullable = false)
    private String name; // 주문 음식명

    @Column(nullable = false)
    private int quantity; // 양

    @Column(nullable = false)
    private int price; // 가격

    public OrderEntity(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price * quantity;
    }
}
