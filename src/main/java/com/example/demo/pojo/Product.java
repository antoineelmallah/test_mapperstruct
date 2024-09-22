package com.example.demo.pojo;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
}
