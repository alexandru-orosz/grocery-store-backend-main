package com.example.grocerystore.factory;

import com.example.grocerystore.dto.CategoryDto;
import com.example.grocerystore.utils.Utils;

public class CategoryFactory {

    public static CategoryDto generateCategory(CategoryDto category){
        return CategoryDto.builder()
                .categoryId(Utils.generateUUID())
                .name(category.getName())
                .build();
    }

}
