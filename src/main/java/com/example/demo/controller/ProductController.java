package com.example.demo.controller;

import com.example.demo.mapper.ProductMapper;
import com.example.demo.pojo.Product;
import com.example.demo.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class ProductController {

    private final ProductMapper productMapper;

    @Autowired
    public ProductController(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @GetMapping("/product")
    public ProductDTO getPerson() {
        Product product = Product.builder()
                .id(1L)
                .name("teste")
                .price(new BigDecimal("123.4"))
                .build();
        return productMapper.build(product);
    }

}

