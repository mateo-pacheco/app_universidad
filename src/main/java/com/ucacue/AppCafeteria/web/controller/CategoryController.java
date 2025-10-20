package com.ucacue.AppCafeteria.web.controller;

import com.ucacue.AppCafeteria.domain.model.Category;
import com.ucacue.AppCafeteria.domain.service.CategoryService;
import com.ucacue.AppCafeteria.web.dto.request.CategoryRequest;
import com.ucacue.AppCafeteria.web.dto.response.CategoryResponse;
import com.ucacue.AppCafeteria.web.mapper.CategoryWebMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryWebMapper categoryWebMapper;

    public CategoryController(CategoryService categoryService, CategoryWebMapper categoryWebMapper) {
        this.categoryService = categoryService;
        this.categoryWebMapper = categoryWebMapper;
    }

    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> getAll() {
        List<Category> categories = categoryService.getAll();
        List<CategoryResponse> categoryResponses = categoryWebMapper.toCategoriesResponse(categories);
        return ResponseEntity.ok(categoryResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable Long id) {
        Category category = categoryService.getById(id);
        CategoryResponse categoryResponse = categoryWebMapper.toCategoryResponse(category);
        return ResponseEntity.ok(categoryResponse);
    }

    @GetMapping("/by-name")
    public ResponseEntity<List<CategoryResponse>> getByName(@RequestParam String name) {
        List<Category> categories = categoryService.getByName(name);
        List<CategoryResponse> categoryResponses = categoryWebMapper.toCategoriesResponse(categories);
        return ResponseEntity.ok(categoryResponses);
    }

    @GetMapping("/is-active-true")
    public ResponseEntity<List<CategoryResponse>> getByActiveTrue() {
        List<Category> categories = categoryService.getByActiveTrue();
        List<CategoryResponse> categoryResponses = categoryWebMapper.toCategoriesResponse(categories);
        return ResponseEntity.ok(categoryResponses);
    }

    @GetMapping("/is-active-false")
    public ResponseEntity<List<CategoryResponse>> getByActiveFalse() {
        List<Category> categories = categoryService.getByActiveFalse();
        List<CategoryResponse> categoryResponses = categoryWebMapper.toCategoriesResponse(categories);
        return ResponseEntity.ok(categoryResponses);
    }

    @PostMapping()
    public ResponseEntity<CategoryResponse> create(@Valid @RequestBody CategoryRequest categoryRequest) {
        Category category = categoryWebMapper.toCategory(categoryRequest);
        Category categorySaved = categoryService.create(category);
        CategoryResponse categoryResponse = categoryWebMapper.toCategoryResponse(categorySaved);
        return ResponseEntity.ok(categoryResponse);
    }

    @PutMapping()
    public ResponseEntity<CategoryResponse> update(@Valid @RequestBody CategoryRequest categoryRequest) {
        Category category = categoryWebMapper.toCategory(categoryRequest);
        Category categorySaved = categoryService.update(category);
        CategoryResponse categoryResponse = categoryWebMapper.toCategoryResponse(categorySaved);
        return ResponseEntity.ok(categoryResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
