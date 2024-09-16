package com.factulink.fkb.api.service;

import com.factulink.fkb.api.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getAll();

    Product save(Product product);

    void deleteById(Integer id);

}
