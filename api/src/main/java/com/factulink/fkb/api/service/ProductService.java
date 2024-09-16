package com.factulink.fkb.api.service;

import com.factulink.fkb.api.model.Product;
import com.factulink.fkb.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Obtener todos los productos
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Obtener un producto por ID
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    // Guardar o actualizar un producto
    public Product saveOrUpdateProduct(Product product) {
        return productRepository.save(product);
    }

    // Eliminar un producto por ID
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
