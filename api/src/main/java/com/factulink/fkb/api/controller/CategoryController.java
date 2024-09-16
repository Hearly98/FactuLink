package com.factulink.fkb.api.controller;

import com.factulink.fkb.api.model.Category;
import com.factulink.fkb.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Obtener todas las categorías
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id) {
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) {
            return ResponseEntity.ok(category.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear una nueva categoría
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category newCategory = categoryService.saveOrUpdateCategory(category);
        return ResponseEntity.ok(newCategory);
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Integer id, @RequestBody Category categoryDetails) {
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) {
            Category existingCategory = category.get();
            existingCategory.setName(categoryDetails.getName());
            Category updatedCategory = categoryService.saveOrUpdateCategory(existingCategory);
            return ResponseEntity.ok(updatedCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una categoría
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) {
            categoryService.deleteCategory(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}