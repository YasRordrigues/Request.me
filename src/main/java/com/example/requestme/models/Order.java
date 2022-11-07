package com.example.requestme.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(schema = "public", name = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private Boolean status = true;
}
