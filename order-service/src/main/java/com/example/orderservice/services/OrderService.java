package com.example.orderservice.services;

import com.example.orderservice.dto.OrderRequestDto;
import com.example.orderservice.dto.OrderResponseDto;
import com.example.orderservice.repositories.IOrderRepository;
import com.example.orderservice.services.interfaces.IOrderService;
import com.example.orderservice.utils.OrderDtoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final IOrderRepository iOrderRepository;


    @Override
    public Mono<OrderResponseDto> createOrder(OrderRequestDto order) {
        return iOrderRepository.save(OrderDtoUtil.convertRequestDtoToEntity(order))
                .map(OrderDtoUtil::convertOrderEntityToResponseDto);
    }

    @Override
    public Mono<OrderResponseDto> getOrderById(Integer id) {
        return iOrderRepository.findById(id).map(OrderDtoUtil::convertOrderEntityToResponseDto);
    }

    @Override
    public Flux<OrderResponseDto> findAllOrders() {
        return iOrderRepository
                .findAll().map(OrderDtoUtil::convertOrderEntityToResponseDto);
    }

    @Override
    public Mono<OrderResponseDto> getOrderByName(String name) {
        return iOrderRepository.findByName(name).map(OrderDtoUtil::convertOrderEntityToResponseDto);
    }

    @Override
    public Mono<Void> deleteOrderById(Integer id) {
        return iOrderRepository.deleteById(id);
    }
}
