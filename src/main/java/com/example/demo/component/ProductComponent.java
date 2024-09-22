package com.example.demo.component;

import com.example.demo.pojo.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductComponent {
    public String buildReportDisplayName(Product product) {
        return String.format("ID: %o, PRODUCT: %s; VALUE: R$ %,.2f",
                product.getId(),
                product.getName(),
                product.getPrice());
    }

}
