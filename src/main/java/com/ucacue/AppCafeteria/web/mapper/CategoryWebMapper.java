package com.ucacue.AppCafeteria.web.mapper;

import com.ucacue.AppCafeteria.domain.model.Category;
import com.ucacue.AppCafeteria.web.dto.request.CategoryRequest;
import com.ucacue.AppCafeteria.web.dto.response.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryWebMapper {
    // Request
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Category toCategory(CategoryRequest categoryRequest);
    List<Category> toCategories(List<CategoryRequest> categoryRequests);

    // Response
    CategoryResponse toCategoryResponse(Category category);
    List<CategoryResponse> toCategoriesResponse(List<Category> categories);
}
