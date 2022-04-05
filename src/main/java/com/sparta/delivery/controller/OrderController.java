package com.sparta.delivery.controller;

import com.sparta.delivery.dto.OrderStatementRequestDto;
import com.sparta.delivery.dto.OrderStatementResponseDto;
import com.sparta.delivery.service.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    // 주문 조회
    @GetMapping("/orders")
    public List<OrderStatementResponseDto> getOrderStatement (){

        return orderService.orderStatementResponseDtoList();
    }

    // 주문
    @PostMapping("/order/request")
    public OrderStatementResponseDto getOrder(@RequestBody OrderStatementRequestDto orderStatementRequestDto){
        return orderService.orderFood(orderStatementRequestDto);
    }
}
