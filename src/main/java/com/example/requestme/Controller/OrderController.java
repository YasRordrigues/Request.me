package com.example.requestme.Controller;

import com.example.requestme.Service.OrderService;
import com.example.requestme.dtos.OrderDTO;
import com.example.requestme.models.Orders;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("order")
public class OrderController {

    @Autowired
    private ModelMapper modelMapper;

    private OrderService orderService;

    @PostMapping("postOrder")
    public Orders createNewOrder(@RequestBody Orders order){
        return orderService.createOrder(order);
    }

    @GetMapping("findAllOrders")
    public List<OrderDTO> findAllPosts(){
        return orderService.getAllOrders().stream().map(orders -> modelMapper.map(orders,OrderDTO.class))
                .collect(Collectors.toList());
    }
    @PutMapping("updateOrderStatus/{id}")
    public Orders changeOrderStatus(@PathVariable(name = "id") Long id){
        return orderService.updateOrderStatus(id);
    }

    @GetMapping("getOrderById/{id}")
    public OrderDTO findById(@PathVariable(name = "id") Long id){
        Orders orders = orderService.getOrderById(id);
        OrderDTO orderResponse = modelMapper.map(orders, OrderDTO.class);

        return ResponseEntity.ok().body(orderResponse).getBody();
    }
}
