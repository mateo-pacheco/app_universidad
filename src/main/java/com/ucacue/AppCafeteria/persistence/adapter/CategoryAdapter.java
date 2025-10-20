package com.ucacue.AppCafeteria.persistence.adapter;

import com.ucacue.AppCafeteria.domain.model.Category;
import com.ucacue.AppCafeteria.domain.respository.CategoryRepository;
import com.ucacue.AppCafeteria.persistence.entity.CategoryEntity;
import com.ucacue.AppCafeteria.persistence.mapper.CategoryMapper;
import com.ucacue.AppCafeteria.persistence.springData.CategoryData;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryAdapter implements CategoryRepository {

    private final CategoryData categoryData;
    private final CategoryMapper categoryMapper;

    public CategoryAdapter(CategoryData categoryData, CategoryMapper categoryMapper) {
        this.categoryData = categoryData;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<Category> getAll() {
        List<CategoryEntity> categoryEntity = categoryData.findAll();
        return categoryMapper.toCategories(categoryEntity);
    }

    @Override
    public Category getById(Long id) {
        CategoryEntity categoryEntity =  categoryData.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Category with id " + id + " not found")
        );
        return categoryMapper.toCategory(categoryEntity);
    }

    @Override
    public List<Category> getByName(String name) {
        List<CategoryEntity> categoryEntities = categoryData.findAllByNameIgnoreCase(name);
        return categoryMapper.toCategories(categoryEntities);
    }

    @Override
    public List<Category> getByActiveTrue() {
        List<CategoryEntity> categoryEntity = categoryData.findByActiveTrue();
        return categoryMapper.toCategories(categoryEntity);
    }

    @Override
    public List<Category> getByActiveFalse() {
        List<CategoryEntity> categoryEntity = categoryData.findByActiveFalse();
        return categoryMapper.toCategories(categoryEntity);
    }

    @Override
    public Category create(Category category) {
        CategoryEntity categoryEntity = categoryMapper.toCategoryEntity(category);
        CategoryEntity categorySaved = categoryData.save(categoryEntity);
        return categoryMapper.toCategory(categorySaved);
    }

    @Override
    public void delete(Long id) {
        categoryData.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return categoryData.existsById(id);
    }
}
