package com.example.requestme.Service;

import com.example.requestme.models.Orders;
import com.example.requestme.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Orders createOrder(Orders newOrder){
        orderRepository.save(newOrder);
        return newOrder;
    }

    public List<Orders> getAllOrders(){
        return orderRepository.findAll();
    }

    public Orders getOrderById(Long id){
        Optional<Orders> orders = orderRepository.findById(id);
        return orders.orElseGet(Orders::new);
    }

    public Orders updateOrderStatus(Long id){
        Optional<Orders> optionalOrders = orderRepository.findById(id);
        optionalOrders.ifPresent(orders -> orders.setStatus(false));
        return null;
    }

}
