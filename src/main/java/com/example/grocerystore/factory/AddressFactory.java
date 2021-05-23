package com.example.grocerystore.factory;

import com.example.grocerystore.dto.AddressDto;
import com.example.grocerystore.entity.Address;
import com.example.grocerystore.mapper.AddressMapper;
import com.example.grocerystore.utils.Utils;

public class AddressFactory {

    public static Address generateAddress(AddressDto addressDto) {
        Address address = AddressMapper.dtoToEntitu(addressDto);
        address.setAddressId(Utils.generateUUID());
        return  address;
    }

}
