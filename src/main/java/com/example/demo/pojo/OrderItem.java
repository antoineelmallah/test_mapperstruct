package com.example.demo.pojo;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class OrderItem {
    private Product product;
    private Integer quantity;
    public BigDecimal getTotalValue() {
        if (product == null)
            return BigDecimal.ZERO;
        if (product.getPrice() == null)
            return BigDecimal.ZERO;
        if (quantity == null)
            return BigDecimal.ZERO;
        return BigDecimal.valueOf(quantity).multiply(product.getPrice());
    }
}
