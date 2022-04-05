package com.sparta.delivery.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor // 기본생성자
public class Order {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id; // 주문요청 id

    @Column(nullable = false)
    private String name; // 주문 음식명

    @Column(nullable = false)
    private int quantity; // 양

    @Column(nullable = false)
    private int price; // 가격

    public Order(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
