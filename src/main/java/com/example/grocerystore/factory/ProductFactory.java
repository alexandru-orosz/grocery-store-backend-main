package com.example.grocerystore.factory;

import com.example.grocerystore.dto.ProductDto;
import com.example.grocerystore.utils.Utils;

public class ProductFactory {

    public static ProductDto generateProduct(ProductDto product){
        return ProductDto.builder()
                .productId(Utils.generateUUID())
                .category(product.getCategory())
                .name(product.getName())
                .description(product.getDescription())
                .unitPrice(product.getUnitPrice())
                .imageUrl(product.getImageUrl())
                .unitsInStock(0)
                .active(true)
                .build();
    }

}
