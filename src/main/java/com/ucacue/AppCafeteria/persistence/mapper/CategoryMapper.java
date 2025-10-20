package com.ucacue.AppCafeteria.persistence.mapper;

import com.ucacue.AppCafeteria.domain.model.Category;
import com.ucacue.AppCafeteria.persistence.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface CategoryMapper {
    // Entity to Model
    Category toCategory(CategoryEntity categoryEntity);
    List<Category> toCategories(List<CategoryEntity> categoryEntities);

    // Model to Entity
    @Mapping(target = "products", ignore = true)
    CategoryEntity toCategoryEntity(Category category);
    List<CategoryEntity> toCategoriesEntity(List<CategoryEntity> categoryEntities);
}
