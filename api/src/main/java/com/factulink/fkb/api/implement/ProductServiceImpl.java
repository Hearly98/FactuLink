package com.factulink.fkb.api.implement;

import com.factulink.fkb.api.model.Product;
import com.factulink.fkb.api.repository.ProductRepository;
import com.factulink.fkb.api.service.ProductService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ProductRepository dao;

    @Override
    public ResponseEntity<Object> getAllProducts(){
        List<Product> products = dao.findAll();
        if(!products.isEmpty()){
            return new ResponseEntity<>(products, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Error al obtener los datos", HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public ResponseEntity<Object>addProduct(Product product){
        Product savedProduct = dao.save(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
    @Override
    public ResponseEntity<Object> getProductById(Integer id){
        Optional<Product> product = dao.findById(id);
        if(product.isPresent()){
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Error al obtener el id: " + id,HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public ResponseEntity<Object>updateProduct(Product prod, Integer id){
        Optional<Product> productExist = dao.findById(id);
        if(productExist.isPresent()){
            Product product = productExist.get();
            product.setName(prod.getName());
            product.setCode(prod.getCode());
            product.setStock(prod.getStock());
            product.setPriceBase(prod.getPriceBase());
            product.setPublishDate(prod.getPublishDate());
            product.setCategory(prod.getCategory());
            dao.save(product);
            return new ResponseEntity<>("Producto actualizado correctamente", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Error al actualizar el producto", HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public ResponseEntity<Object> deleteProduct(Integer id){
        Optional<Product> productExist = dao.findById(id);
        if(productExist.isPresent()){
            dao.deleteById(id);
            return new ResponseEntity<>("Producto eliminado correctamente", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Error: Producto no encontrada", HttpStatus.NOT_FOUND);
        }
    }
}
