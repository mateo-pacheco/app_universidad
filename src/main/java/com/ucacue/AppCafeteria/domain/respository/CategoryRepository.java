package com.ucacue.AppCafeteria.domain.respository;

import com.ucacue.AppCafeteria.domain.model.Category;

import java.util.List;

public interface CategoryRepository {
    public List<Category> getAll();
    public Category getById(Long id);
    public List<Category> getByName(String name);
    public List<Category> getByActiveTrue();
    public List<Category> getByActiveFalse();
    public Category create(Category category);
    public void delete(Long id);
    public boolean existsById(Long id);
}
