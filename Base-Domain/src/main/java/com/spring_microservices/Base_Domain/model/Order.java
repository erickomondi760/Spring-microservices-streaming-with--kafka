package com.spring_microservices.Base_Domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Long id;
    private int qty;
    private double price;
    private String name;
}
