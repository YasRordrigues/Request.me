package com.example.orderservice.services.interfaces;

import com.example.orderservice.dto.OrderRequestDto;
import com.example.orderservice.dto.OrderResponseDto;
import com.example.orderservice.entities.OrderEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IOrderService {
    Mono<OrderResponseDto> createOrder(OrderRequestDto orderRequestDto);
    Mono<OrderResponseDto> getOrderById(Integer id);
    Flux<OrderResponseDto> findAllOrders();
    Mono<OrderResponseDto> getOrderByName(String name);
    Mono<Void> deleteOrderById(Integer id);
}
