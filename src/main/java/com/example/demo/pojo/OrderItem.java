package com.example.demo.pojo;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class OrderItem {
    private Product product;
    private Integer quantity;
    private BigDecimal value;
    public BigDecimal getTotalValue() {
        if (value == null || quantity == null)
            return BigDecimal.ZERO;
        return BigDecimal.valueOf(quantity).multiply(value);
    }
}
