package com.example.grocerystore.controller;

import com.example.grocerystore.dto.ProductDto;
import com.example.grocerystore.factory.ProductFactory;
import com.example.grocerystore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<Set<ProductDto>> getAllProducts(){
        Set<ProductDto> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Set<ProductDto>> getProductsByCategoryId(@PathVariable("id") String id){
        Set<ProductDto> products = productService.findAllProductsByCategoryId(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<Set<ProductDto>> getProductsByKeyword(@PathVariable("keyword") String keyword){
        Set<ProductDto> products = productService.findProductsByKeyword(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") String id){
        ProductDto product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto product){
        ProductDto newProduct = productService.addProduct(ProductFactory.generateProduct(product));
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto product){
        ProductDto updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") String id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
