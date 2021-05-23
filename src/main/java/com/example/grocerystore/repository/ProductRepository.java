package com.example.grocerystore.repository;

import com.example.grocerystore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findProductByProductId(String id);
    void deleteProductByProductId(String id);
    Set<Product> findProductsByCategoryCategoryId(String name);
    Set<Product> findByNameContainingIgnoreCase(String name);
}
