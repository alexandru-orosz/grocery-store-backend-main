package com.example.grocerystore.factory;

import com.example.grocerystore.dto.OrderItemDto;
import com.example.grocerystore.entity.OrderItem;
import com.example.grocerystore.mapper.OrderItemMapper;

import java.util.Set;
import java.util.stream.Collectors;

public class OrderItemFactory {

    public static Set<OrderItem> generateOrderItems(Set<OrderItemDto> orderItemDtos) {
        return orderItemDtos.stream().map(OrderItemMapper::dtoToEntity).collect(Collectors.toSet());
    }
}
