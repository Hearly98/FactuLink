package com.factulink.fkb.api.implement;

import com.factulink.fkb.api.model.Category;
import com.factulink.fkb.api.repository.CategoryRepository;
import com.factulink.fkb.api.service.CategoryService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CategoryRepository dao;

    @Override
    public ResponseEntity<Object> getCategories(){
        List<Category> categories = dao.findAll();
        if(!categories.isEmpty()){
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Error al obtener los datos", HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public ResponseEntity<Object>addCategory(Category category){
        Category savedCategory = dao.save(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }
    @Override
    public ResponseEntity<Object> getCategoryById(Integer id){
        Optional<Category> category = dao.findById(id);
        if(category.isPresent()){
            return new ResponseEntity<>(category.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Error al obtener el id: " + id,HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public ResponseEntity<Object>updateCategory(Category cat, Integer id){
        Optional<Category> categoryExist = dao.findById(id);
        if(categoryExist.isPresent()){
            Category category = categoryExist.get();
            category.setName(cat.getName());
            dao.save(category);
            return new ResponseEntity<>("Categoría actualizada correctamente", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Error al actualizar la categoría", HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public ResponseEntity<Object> deleteCategory(Integer id){
        Optional<Category> categoryExist = dao.findById(id);
        if(categoryExist.isPresent()){
            dao.deleteById(id);
            return new ResponseEntity<>("Categoría eliminada correctamente", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Error: Categoría no encontrada", HttpStatus.NOT_FOUND);
        }
    }
}
