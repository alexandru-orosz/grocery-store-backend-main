package com.example.grocerystore.mapper;

import com.example.grocerystore.dto.OrderDto;
import com.example.grocerystore.entity.Order;

public class OrderMapper {

    public static Order dtoToEntity(OrderDto orderDto) {
        return Order.builder()
                .totalQuantity(orderDto.getTotalQuantity())
                .totalPrice(orderDto.getTotalPrice())
                .build();
    }
}
