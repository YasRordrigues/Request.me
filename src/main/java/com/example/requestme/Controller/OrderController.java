package com.example.requestme.Controller;

import com.example.requestme.Service.OrderService;
import com.example.requestme.models.Orders;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("order")
public class OrderController {

    private OrderService orderService;

    @PostMapping("postOrder")
    public Orders createNewOrder(@RequestBody Orders order){
        return orderService.newOrder(order);
    }
}
