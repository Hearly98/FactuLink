package com.factulink.fkb.api.controller;

import com.factulink.fkb.api.model.Category;
import com.factulink.fkb.api.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // Obtener todas las categorías
    @GetMapping
    public ResponseEntity<Object> getAllCategories() {
        return categoryService.getCategories();
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    // Crear una nueva categoría
    @PostMapping
    public ResponseEntity<Object> createCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCategory(@PathVariable Integer id, @RequestBody Category category) {
        return categoryService.updateCategory(category, id);
    }

    // Eliminar una categoría
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable Integer id) {
        return  categoryService.deleteCategory(id);
    }
}