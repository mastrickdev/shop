package com.shop.springboot.controllers;

import com.shop.springboot.dtos.ProductDTO;
import com.shop.springboot.models.ProductModel;
import com.shop.springboot.repositories.ProductRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductDTO product) {
        var productModel = new ProductModel();
        BeanUtils.copyProperties(product, productModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts() {

        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable(value="id") UUID id) {
        Optional<ProductModel> product = productRepository.findById(id);
        if (product.isEmpty()) { return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found!"); }

        return ResponseEntity.status(HttpStatus.OK).body(product.get());
    }
}
