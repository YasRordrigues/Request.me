package com.example.requestme.Controller;

import com.example.requestme.Services.OrderService;
import com.example.requestme.dtos.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("postOrder")
    public ResponseEntity<OrderDTO> createNewOrder(@RequestBody OrderDTO order){
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @GetMapping("findAllOrders")
    public ResponseEntity<List<OrderDTO>> findAllPosts(){
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @PutMapping("updateOrderStatus/{id}")
    public ResponseEntity<OrderDTO> changeOrderStatus(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(orderService.updateOrderStatus(id), HttpStatus.OK);
    }

    @GetMapping("getOrderById/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }
}
