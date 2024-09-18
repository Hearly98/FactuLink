package com.factulink.fkb.api.controller;

import com.factulink.fkb.api.model.Product;
import com.factulink.fkb.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Optional<Product> product = productService.getById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product productDetails) {
        Optional<Product> product = productService.getById(id);
        if (product.isPresent()) {
            Product updatedProduct = product.get();
            updatedProduct.setCode(productDetails.getCode());
            updatedProduct.setName(productDetails.getName());
            updatedProduct.setPriceBase(productDetails.getPriceBase());
            updatedProduct.setStock(productDetails.getStock());
            updatedProduct.setPublishDate(productDetails.getPublishDate());
            updatedProduct.setCategory(productDetails.getCategory());
            productService.save(updatedProduct);
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}