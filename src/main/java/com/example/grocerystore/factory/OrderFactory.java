package com.example.grocerystore.factory;

import com.example.grocerystore.dto.OrderDto;
import com.example.grocerystore.entity.Order;
import com.example.grocerystore.mapper.OrderMapper;
import com.example.grocerystore.utils.Utils;

public class OrderFactory {

    public static Order generateOrder(OrderDto orderDto){
        Order order = OrderMapper.dtoToEntity(orderDto);
        order.setOrderId(Utils.generateUUID());
        order.setOrderTrackingNumber(Utils.generateUUID());
        order.setStatus("PLACED");
        return order;
    }

}
