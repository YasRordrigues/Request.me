package com.example.orderservice.controllers;

import com.example.orderservice.dto.OrderRequestDto;
import com.example.orderservice.dto.OrderResponseDto;
import com.example.orderservice.services.interfaces.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/order-service")
@RequiredArgsConstructor
public class OrderController {

    private final IOrderService orderService;

    @GetMapping
    public Flux<OrderResponseDto> getAllOrders() {
        return orderService.findAllOrders();
    }

    @GetMapping("/{id}")
    public Mono<OrderResponseDto> getUserById(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/findByName/{name}")
    public Mono<OrderResponseDto> getOrderByName(@PathVariable String name) {
        return orderService.getOrderByName(name);
    }

    @PostMapping
    public Mono<OrderResponseDto> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        return orderService.createOrder(orderRequestDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteOrderById(@PathVariable Integer id) {
        return orderService.deleteOrderById(id);
    }

}
