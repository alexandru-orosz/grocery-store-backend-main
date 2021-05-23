package com.example.grocerystore.service;

import com.example.grocerystore.dto.ProductDto;
import com.example.grocerystore.exception.ProductNotFoundException;
import com.example.grocerystore.mapper.ProductMapper;
import com.example.grocerystore.repository.ProductRepository;
import com.example.grocerystore.validator.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public ProductDto addProduct(ProductDto product){
        ProductValidator.validate(product);
        return ProductMapper.entityToDto(productRepository.save(ProductMapper.dtoToEntity(product)));
    }

    public ProductDto updateProduct(ProductDto product){
        ProductValidator.validate(product);
        return ProductMapper.entityToDto(productRepository.save(ProductMapper.dtoToEntity(product)));
    }

    public void deleteProduct(String id){
        productRepository.deleteProductByProductId(id);
    }

    public ProductDto findProductById(String id){
        return ProductMapper.entityToDto(productRepository.findProductByProductId(id).
                orElseThrow(() -> new ProductNotFoundException("Product with id + " + id + " was not found.")));
    }

    public Set<ProductDto> findAllProducts(){
        return productRepository.findAll().stream().map(ProductMapper::entityToDto).collect(Collectors.toSet());
    }

    public Set<ProductDto> findAllProductsByCategoryId(String id){
        return productRepository.findProductsByCategoryCategoryId(id).stream().map(ProductMapper::entityToDto).collect(Collectors.toSet());
    }

    public Set<ProductDto> findProductsByKeyword(String keyword){
        return productRepository.findByNameContainingIgnoreCase(keyword).stream().map(ProductMapper::entityToDto).collect(Collectors.toSet());
    }

}
