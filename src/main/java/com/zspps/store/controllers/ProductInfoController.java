package com.zspps.store.controllers;

import com.zspps.store.models.Product;
import com.zspps.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info")
public class ProductInfoController
{
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductToBuy(@PathVariable Long id)
    {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }
}