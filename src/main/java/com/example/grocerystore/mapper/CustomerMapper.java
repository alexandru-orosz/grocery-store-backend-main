package com.example.grocerystore.mapper;

import com.example.grocerystore.dto.CustomerDto;
import com.example.grocerystore.entity.Customer;

public class CustomerMapper {

    public static Customer dtoToEntity(CustomerDto customerDto) {
        return Customer.builder()
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .email(customerDto.getEmail())
                .build();
    }

}
