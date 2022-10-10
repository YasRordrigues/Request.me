package com.example.requestme.Service;

import com.example.requestme.models.Orders;
import com.example.requestme.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Orders newOrder(Orders newOrder){
        orderRepository.save(newOrder);
        return newOrder;
    }

}
