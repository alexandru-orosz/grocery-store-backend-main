package com.example.grocerystore.mapper;

import com.example.grocerystore.dto.ProductDto;
import com.example.grocerystore.entity.Product;

public class ProductMapper {

    public static ProductDto entityToDto(Product product){
        return ProductDto.builder()
                .productId(product.getProductId())
                .category(CategoryMapper.entityToDto(product.getCategory()))
                .name(product.getName())
                .description(product.getDescription())
                .unitPrice(product.getUnitPrice())
                .imageUrl(product.getImageUrl())
                .active(product.isActive())
                .unitsInStock(product.getUnitsInStock())
                .build();
    }

    public static Product dtoToEntity(ProductDto productDto){
        return Product.builder()
                .productId(productDto.getProductId())
                .category(CategoryMapper.dtoToEntity(productDto.getCategory()))
                .name(productDto.getName())
                .description(productDto.getDescription())
                .unitPrice(productDto.getUnitPrice())
                .imageUrl(productDto.getImageUrl())
                .active(productDto.isActive())
                .unitsInStock(productDto.getUnitsInStock())
                .build();
    }

}
