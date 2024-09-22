package com.example.demo.mapper;

import com.example.demo.component.ProductComponent;
import com.example.demo.dto.ReportDTO;
import com.example.demo.dto.ReportItem;
import com.example.demo.pojo.Order;
import com.example.demo.pojo.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ReportMapper {

    @Autowired
    protected ProductComponent productComponent;

    @Mapping(target = "itemCount", expression = "java(itemCount(order))")
    @Mapping(source = "saleDate", target = "date")
    @Mapping(source = "total", target = "totalValue")
    public abstract ReportDTO build(Order order);

    @Mapping(target = "product", expression = "java(productComponent.buildReportDisplayName(item.getProduct()))")
    @Mapping(source = "totalValue", target = "total")
    public abstract ReportItem build(OrderItem item);

    public int itemCount(Order order) {
        return order.getItems().size();
    }

}
