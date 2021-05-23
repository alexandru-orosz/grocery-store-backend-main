package com.example.grocerystore.mapper;

import com.example.grocerystore.dto.CategoryDto;
import com.example.grocerystore.entity.Category;

public class CategoryMapper {

    public static CategoryDto entityToDto(Category category){
        return CategoryDto.builder()
                .categoryId(category.getCategoryId())
                .name(category.getName())
                .build();
    }

    public static Category dtoToEntity(CategoryDto categoryDto){
        return Category.builder()
                .categoryId(categoryDto.getCategoryId())
                .name(categoryDto.getName())
                .build();
    }

}
