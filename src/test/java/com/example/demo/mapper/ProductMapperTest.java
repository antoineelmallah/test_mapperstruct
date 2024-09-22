package com.example.demo.mapper;

import com.example.demo.pojo.Product;
import com.example.demo.dto.ProductDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductMapperTest {

    @Spy
    private ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Test
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
        assertEquals(new BigDecimal("123.4"), productDTO.getValue());
    }

}