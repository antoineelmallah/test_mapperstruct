package com.example.demo.mapper;

import com.example.demo.pojo.Product;
import com.example.demo.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "price", target = "value")
    ProductDTO build(Product product);
}
