package com.ucacue.AppCafeteria.domain.service;

import com.ucacue.AppCafeteria.domain.model.Category;
import com.ucacue.AppCafeteria.domain.respository.CategoryRepository;
import com.ucacue.AppCafeteria.domain.validation.CategoryValidation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryValidation categoryValidation;

    public CategoryService(CategoryRepository categoryRepository, CategoryValidation categoryValidation) {
        this.categoryRepository = categoryRepository;
        this.categoryValidation = categoryValidation;
    }

    @Transactional(readOnly = true)
    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    @Transactional(readOnly = true)
    public Category getById(Long id) {
        return categoryRepository.getById(id);
    }

    @Transactional(readOnly = true)
    public List<Category> getByName(String name){
        return categoryRepository.getByName(name);
    }

    @Transactional(readOnly = true)
    public List<Category> getByActiveTrue() {
        return categoryRepository.getByActiveTrue();
    }

    @Transactional(readOnly = true)
    public List<Category> getByActiveFalse() {
        return categoryRepository.getByActiveFalse();
    }

    @Transactional
    public Category create(Category category) {
        categoryValidation.createCategoria(category);
        categoryValidation.validateName(category.getName());
        categoryValidation.validateActive(category.isActive());
        category.setCreatedAt(LocalDateTime.now());
        category.setUpdatedAt(LocalDateTime.now());
        return categoryRepository.create(category);
    }

    @Transactional
    public Category update(Category category) {
        if (categoryRepository.existsById(category.getIdCategory())) {
            categoryValidation.updateCategoria(category);
            categoryValidation.validateName(category.getName());
            categoryValidation.validateActive(category.isActive());
            Category oldCategory = categoryRepository.getById(category.getIdCategory());
            category.setCreatedAt(oldCategory.getCreatedAt());
            category.setUpdatedAt(LocalDateTime.now());
            return categoryRepository.create(category);
        } else {
            throw new IllegalStateException("La categoria no existe");
        }
    }

    @Transactional
    public void deleteById(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryValidation.deleteCategoria(id);
            categoryRepository.delete(id);
        }
    }
}
