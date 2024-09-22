package com.example.demo.controller;

import com.example.demo.dto.ReportDTO;
import com.example.demo.mapper.ReportMapper;
import com.example.demo.pojo.Order;
import com.example.demo.pojo.OrderItem;
import com.example.demo.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private ReportMapper mapper;

    @GetMapping("/report")
    public ReportDTO getReport() {
        var order = Order.builder()
                .orderNumber(1L)
                .saleDate(LocalDate.of(2014, 1, 1))
                .items(buildItems())
                .build();
        return mapper.build(order);
    }

    private static List<OrderItem> buildItems() {
        return List.of(
                OrderItem.builder()
                        .product(Product.builder()
                                .id(1L)
                                .name("Produto 1")
                                .price(new BigDecimal("20.5"))
                                .build())
                        .value(new BigDecimal("100"))
                        .quantity(2)
                        .build(),
                OrderItem.builder()
                        .product(Product.builder()
                                .id(2L)
                                .name("Produto 2")
                                .price(new BigDecimal("100.1"))
                                .build())
                        .value(new BigDecimal("150"))
                        .quantity(1)
                        .build(),
                OrderItem.builder()
                        .product(Product.builder()
                                .id(3L)
                                .name("Produto 3")
                                .price(new BigDecimal("5.8"))
                                .build())
                        .value(new BigDecimal("90"))
                        .quantity(4)
                        .build()
        );
    }

}
