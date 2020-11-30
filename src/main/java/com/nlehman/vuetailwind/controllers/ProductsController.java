package com.nlehman.vuetailwind.controllers;

import com.nlehman.vuetailwind.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<Object> index() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Object> show(@PathVariable("productId") long productId) {
        return new ResponseEntity<>(productService.getProduct(productId), HttpStatus.OK);
    }
}
