package com.factulink.fkb.api.controller;

import com.factulink.fkb.api.model.Product;
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

    // Obtener todos los productos
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo producto
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product newProduct = productService.saveOrUpdateProduct(product);
        return ResponseEntity.ok(newProduct);
    }

    // Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product productDetails) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            Product existingProduct = product.get();
            existingProduct.setCode(productDetails.getCode());
            existingProduct.setName(productDetails.getName());
            existingProduct.setPriceBase(productDetails.getPriceBase());
            existingProduct.setStock(productDetails.getStock());
            existingProduct.setPublishDate(productDetails.getPublishDate());
            existingProduct.setCategory(productDetails.getCategory());

            Product updatedProduct = productService.saveOrUpdateProduct(existingProduct);
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
