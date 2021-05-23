package com.example.grocerystore.factory;

import com.example.grocerystore.dto.CustomerDto;
import com.example.grocerystore.entity.Customer;
import com.example.grocerystore.mapper.CustomerMapper;
import com.example.grocerystore.utils.Utils;

public class CustomerFactory {

    public static Customer generateCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.dtoToEntity(customerDto);
        customer.setCustomerId((Utils.generateUUID()));
        return customer;
    }

}
