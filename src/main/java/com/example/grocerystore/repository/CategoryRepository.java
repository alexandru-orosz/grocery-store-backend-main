package com.example.grocerystore.repository;

import com.example.grocerystore.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin("http://localhost:4200")
public interface CategoryRepository extends JpaRepository<Category, String> {
    Optional<Category> findCategoryByCategoryId(String id);
    void deleteCategoryByCategoryId(String id);
}
