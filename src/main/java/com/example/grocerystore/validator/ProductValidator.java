package com.example.grocerystore.validator;

import com.example.grocerystore.dto.ProductDto;
import org.apache.commons.lang3.StringUtils;

public class ProductValidator {

    public static void validate(ProductDto product){
        if(product == null){
            throw new IllegalArgumentException("Product is null.");
        }

        if(product.getProductId() == null) {
            throw new IllegalArgumentException("The product's id is null.");
        }

        if(product.getCategory() == null){
            throw new IllegalArgumentException("The product's category is null.");
        }

        if(StringUtils.isEmpty(product.getName())){
            throw new IllegalArgumentException("Product name is empty.");
        }

        if(product.getUnitPrice().floatValue() <= 0){
            throw new IllegalArgumentException("Product's price is invalid.");
        }

        if(product.getUnitsInStock() < 0){
            throw new IllegalArgumentException("Product's stock is invalid.");
        }

        if(StringUtils.isEmpty(product.getImageUrl()) || StringUtils.containsWhitespace(product.getImageUrl())){
            throw new IllegalArgumentException("Product's image is invalid or empty.");
        }
    }

}
