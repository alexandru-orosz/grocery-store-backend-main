package com.example.grocerystore.controller;

import com.example.grocerystore.dto.CategoryDto;
import com.example.grocerystore.factory.CategoryFactory;
import com.example.grocerystore.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<Set<CategoryDto>> getAllCategories(){
        Set<CategoryDto> categories = categoryService.findAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CategoryDto> getProductById(@PathVariable("id") String id){
        CategoryDto category = categoryService.findCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto category){
        CategoryDto newCategory = categoryService.addCategory(CategoryFactory.generateCategory(category));
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto category){
        CategoryDto updatedCategory = categoryService.updateCategory(category);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") String id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
