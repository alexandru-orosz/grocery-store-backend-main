package com.example.grocerystore.validator;

import com.example.grocerystore.dto.CategoryDto;
import org.apache.commons.lang3.StringUtils;

public class ProductCategoryValidator {

    public static void validate(CategoryDto category){
        if(category == null){
            throw new IllegalArgumentException("Category is null.");
        }

        if(StringUtils.isEmpty(category.getCategoryId())){
            throw new IllegalArgumentException("Category's id is empty.");
        }

        if(StringUtils.isEmpty(category.getName())){
            throw new IllegalArgumentException("Category's name is empty.");
        }
    }

}
