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
    private int quantity; // 양

    @ManyToOne(targetEntity = Food.class)
    @JoinColumn(nullable = false)
    private Food food; // 음식 주문 정보가 필요함

    @ManyToOne(targetEntity = Restaurant.class)
    @JoinColumn(nullable = false)
    private Restaurant restaurant;


}
