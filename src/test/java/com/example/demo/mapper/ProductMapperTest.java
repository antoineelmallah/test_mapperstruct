package com.example.demo.mapper;

import com.example.demo.pojo.Product;
import com.example.demo.dto.ProductDTO;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {

    private ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    //@Test
    void testMapping() {
        var product = Product.builder()
                .id(1L)
                .name("PRODUTO 1")
                .price(new BigDecimal("123.4"))
                .build();
        ProductDTO productDTO = mapper.build(product);

        assertNotNull(productDTO);
        assertInstanceOf(ProductDTO.class, productDTO);

        assertEquals("PRODUTO 1", productDTO.getName());
        assertEquals(123.4, productDTO.getValue());
    }

}