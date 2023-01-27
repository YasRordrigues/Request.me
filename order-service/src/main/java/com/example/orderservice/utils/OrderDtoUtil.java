package com.example.orderservice.utils;

import com.example.orderservice.dto.OrderRequestDto;
import com.example.orderservice.dto.OrderResponseDto;
import com.example.orderservice.entities.OrderEntity;
import org.modelmapper.ModelMapper;

public class OrderDtoUtil {

    public static OrderResponseDto convertOrderEntityToResponseDto(OrderEntity orderEntity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(orderEntity, OrderResponseDto.class);
    }

    public static OrderEntity convertRequestDtoToEntity(OrderRequestDto orderRequestDto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(orderRequestDto, OrderEntity.class);
    }
}
