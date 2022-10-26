package com.example.requestme.Controller;

import com.example.requestme.Service.OrderService;
import com.example.requestme.dtos.OrderDTO;
import com.example.requestme.models.Order;
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
    public Order createNewOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }

    @GetMapping("findAllOrders")
    public List<OrderDTO> findAllPosts(){
        return orderService.getAllOrders().stream().map(order -> modelMapper.map(order,OrderDTO.class))
                .collect(Collectors.toList());
    }
    @PutMapping("updateOrderStatus/{id}")
    public Order changeOrderStatus(@PathVariable(name = "id") Long id){
        return orderService.updateOrderStatus(id);
    }

    @GetMapping("getOrderById/{id}")
    public OrderDTO findById(@PathVariable(name = "id") Long id){
        Order order = orderService.getOrderById(id);
        OrderDTO orderResponse = modelMapper.map(order, OrderDTO.class);

        return ResponseEntity.ok().body(orderResponse).getBody();
    }
}
