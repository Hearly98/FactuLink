package com.factulink.fkb.api.service;

import com.factulink.fkb.api.model.Category;
import com.factulink.fkb.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Obtener todas las categorías
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Obtener una categoría por ID
    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }

    // Guardar o actualizar una categoría
    public Category saveOrUpdateCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Eliminar una categoría por ID
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}