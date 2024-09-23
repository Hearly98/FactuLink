package com.factulink.fkb.api.service;

import com.factulink.fkb.api.model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    public ResponseEntity<Object> getCategories();
    public ResponseEntity<Object> addCategory(Category category);
    public ResponseEntity<Object> getCategoryById(Integer id);
    public ResponseEntity<Object> updateCategory(Category category, Integer id);
    public ResponseEntity<Object> deleteCategory(Integer id);
}