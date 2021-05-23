package com.example.grocerystore.mapper;

import com.example.grocerystore.dto.OrderItemDto;
import com.example.grocerystore.entity.OrderItem;

public class OrderItemMapper {

    public static OrderItem dtoToEntity(OrderItemDto orderItemDto) {
        return OrderItem.builder()
                .imageUrl(orderItemDto.getImageUrl())
                .unitPrice(orderItemDto.getUnitPrice())
                .quantity(orderItemDto.getQuantity())
                .productId(orderItemDto.getProductId())
                .build();
    }
}
