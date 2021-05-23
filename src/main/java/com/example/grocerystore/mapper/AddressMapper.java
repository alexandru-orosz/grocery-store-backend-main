package com.example.grocerystore.mapper;

import com.example.grocerystore.dto.AddressDto;
import com.example.grocerystore.entity.Address;

public class AddressMapper {

    public static Address dtoToEntitu(AddressDto addressDto) {
        return Address.builder()
                .country(addressDto.getCountry())
                .city(addressDto.getCity())
                .state(addressDto.getState())
                .street(addressDto.getStreet())
                .zipCode(addressDto.getZipCode())
                .build();
    }
}
