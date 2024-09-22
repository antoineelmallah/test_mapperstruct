package com.example.demo.pojo;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class Order {
    private Long orderNumber;
    private LocalDate saleDate;
    private List<OrderItem> items;
    public BigDecimal getTotal() {
        if (items == null)
            return BigDecimal.ZERO;
        return items.stream()
                .map(OrderItem::getTotalValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
