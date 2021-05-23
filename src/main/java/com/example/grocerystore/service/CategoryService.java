package com.example.grocerystore.service;

import com.example.grocerystore.dto.CategoryDto;
import com.example.grocerystore.exception.CategoryNotFoundException;
import com.example.grocerystore.mapper.CategoryMapper;
import com.example.grocerystore.repository.CategoryRepository;
import com.example.grocerystore.validator.ProductCategoryValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryDto addCategory(CategoryDto category){
        ProductCategoryValidator.validate(category);
        return CategoryMapper.entityToDto(categoryRepository.save(CategoryMapper.dtoToEntity(category)));
    }

    public CategoryDto updateCategory(CategoryDto category){
        ProductCategoryValidator.validate(category);
        return CategoryMapper.entityToDto(categoryRepository.save(CategoryMapper.dtoToEntity(category)));
    }

    public void deleteCategory(String id){
        categoryRepository.deleteCategoryByCategoryId(id);
    }

    public CategoryDto findCategoryById(String id){
        return CategoryMapper.entityToDto(categoryRepository.findCategoryByCategoryId(id).
                orElseThrow(() -> new CategoryNotFoundException("Category with id + " + id + " was not found.")));
    }

    public Set<CategoryDto> findAllCategories(){
        return categoryRepository.findAll().stream().map(CategoryMapper::entityToDto).collect(Collectors.toSet());
    }

}
