package com.example.demo.mapper;

import com.example.demo.dto.ReportDTO;
import com.example.demo.dto.ReportItem;
import com.example.demo.pojo.Order;
import com.example.demo.pojo.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReportMapper {

    @Mapping(target = "itemCount", expression = "java(itemCount(order))")
    @Mapping(source = "saleDate", target = "date")
    @Mapping(source = "total", target = "totalValue")
    ReportDTO build(Order order);

    @Mapping(target = "product", expression = "java(item.getProduct().getName())")
    @Mapping(source = "totalValue", target = "total")
    ReportItem build(OrderItem item);

    default int itemCount(Order order) {
        return order.getItems().size();
    }

}
