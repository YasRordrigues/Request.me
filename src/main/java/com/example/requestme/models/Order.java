package com.example.requestme.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private String box;
    private Boolean status = true;
}
