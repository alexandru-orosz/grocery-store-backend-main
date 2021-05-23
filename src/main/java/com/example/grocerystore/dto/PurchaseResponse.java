package com.example.grocerystore.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PurchaseResponse {

    private final String orderTrackingNumber;

}
