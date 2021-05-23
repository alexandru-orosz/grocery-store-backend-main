package com.example.grocerystore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor

@NoArgsConstructor
public class Purchase {

    private CustomerDto customer;
    private AddressDto shippingAddress;
    private AddressDto billingAddress;
    private OrderDto order;
    private Set<OrderItemDto> orderItems;
    private String invoice;
}
