package com.example.orderservice.repositories;

import com.example.orderservice.entities.OrderEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface IOrderRepository extends R2dbcRepository<OrderEntity, Integer> {
    Mono<OrderEntity> findByName(String name);
}
