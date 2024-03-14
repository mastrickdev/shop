package com.shop.springboot.controllers;

import com.shop.springboot.dtos.ProductDTO;
import com.shop.springboot.models.ProductModel;
import com.shop.springboot.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
