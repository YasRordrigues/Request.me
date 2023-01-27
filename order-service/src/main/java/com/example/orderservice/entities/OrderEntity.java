package com.example.orderservice.entities;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Table(value = "orders", schema = "orders")
public class OrderEntity {
    @Id
    private Integer id;
    private String name;
    private Float value;
    private String order_description;
}
