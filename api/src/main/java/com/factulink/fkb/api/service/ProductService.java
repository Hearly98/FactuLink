package com.factulink.fkb.api.service;

import com.factulink.fkb.api.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    // Obtener todos los productos
    public ResponseEntity<Object> getAllProducts();

    // Obtener un producto por ID
    public ResponseEntity<Object> getProductById(Integer id);

    public ResponseEntity<Object> addProduct(Product product);

    // Actualizar un producto
    public ResponseEntity<Object> updateProduct(Product product, Integer id);

    // Eliminar un producto por ID
    public ResponseEntity<Object> deleteProduct(Integer id);
}