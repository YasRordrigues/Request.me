package com.example.requestme.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
//@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO {
    private String box;
}
