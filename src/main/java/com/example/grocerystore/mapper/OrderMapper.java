package com.example.grocerystore.mapper;

import com.example.grocerystore.dto.OrderDto;
import com.example.grocerystore.entity.Order;
import com.example.grocerystore.utils.Utils;

public class OrderMapper {

    public static Order dtoToEntity(OrderDto orderDto) {
        return Order.builder()
                .totalQuantity(orderDto.getTotalQuantity())
                .totalPrice(orderDto.getTotalPrice())
                .build();
    }

    public static OrderDto entityToDto(Order order) {
        return OrderDto.builder()
                .orderTrackingNumber(order.getOrderTrackingNumber())
                .totalQuantity(order.getTotalQuantity())
                .totalPrice(order.getTotalPrice())
                .date(Utils.formatDate(order.getDateCreated()))
                .status(order.getStatus())
                .build();
    }
}
