package com.example.requestme.Service;

import com.example.requestme.models.Order;
import com.example.requestme.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order createOrder(Order newOrder) {
        orderRepository.save(newOrder);
        return newOrder;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        Optional<Order> orders = orderRepository.findById(id);
        return orders.orElseGet(Order::new);
    }

    public Order updateOrderStatus(Long id) {
        Optional<Order> optionalOrders = orderRepository.findById(id);

        if (optionalOrders.isPresent()) {
            Order updated_user = optionalOrders.get();
            updated_user.setStatus(false);
            return orderRepository.save(updated_user);
        }
        else {
            return null;
        }

    }

}
