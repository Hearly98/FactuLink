package com.factulink.fkb.api.controller;

import com.factulink.fkb.api.model.Product;
import com.factulink.fkb.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<Object> getAllProducts() {
        return productService.getAllProducts();
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Integer id) {
       return productService.getProductById(id);
    }

    // Crear un nuevo producto
    @PostMapping("/save")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // Actualizar un producto existente
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Integer id, @RequestBody Product productDetails) {
      return productService.updateProduct(productDetails, id);
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Integer id) {
       return productService.deleteProduct(id);
    }
}
