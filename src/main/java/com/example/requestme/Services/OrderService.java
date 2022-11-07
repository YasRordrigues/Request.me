package com.example.requestme.Services;

import com.example.requestme.dtos.OrderDTO;
import com.example.requestme.models.Order;
import com.example.requestme.repository.OrderRepository;
import com.example.requestme.utils.ConvertOrderDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public OrderDTO createOrder(OrderDTO newOrder) {
        Order order = ConvertOrderDtoUtil.convertToEntity(newOrder);
        orderRepository.save(order);
        return newOrder;
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream().map(ConvertOrderDtoUtil::convertToDto).collect(Collectors.toList());
    }

    public OrderDTO getOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.map(ConvertOrderDtoUtil::convertToDto).orElse(null);
    }

    public OrderDTO updateOrderStatus(Long id) {
        Optional<Order> optionalOrders = orderRepository.findById(id);

        if (optionalOrders.isPresent()) {
            OrderDTO updated_user = ConvertOrderDtoUtil.convertToDto(optionalOrders.get());
            updated_user.setStatus(false);
            orderRepository.save(ConvertOrderDtoUtil.convertToEntity(updated_user));
            return updated_user;
        }

        return null;
    }

}
