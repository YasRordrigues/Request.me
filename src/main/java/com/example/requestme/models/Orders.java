package com.example.requestme.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "orders")
@Entity
public class Orders {
    @Id
    @GeneratedValue
    private Long id;

    private String box;
}
