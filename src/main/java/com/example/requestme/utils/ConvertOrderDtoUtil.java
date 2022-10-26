package com.example.requestme.utils;

import com.example.requestme.models.Order;
import com.example.requestme.dtos.OrderDTO;
import org.modelmapper.ModelMapper;

public class ConvertOrderDtoUtil {


    public static OrderDTO convertToDto(Order force) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(force, OrderDTO.class);
    }

    public static Order convertToEntity(OrderDTO postDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(postDto, Order.class);
    }
}
