package com.ucacue.AppCafeteria.persistence.mapper;

import com.ucacue.AppCafeteria.domain.model.CategoryConsumable;
import com.ucacue.AppCafeteria.persistence.entity.CategoryConsumableEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ConsumableMapper.class})
public interface CategoryConsumableMapper {
    // Entity to Model
    CategoryConsumable toCategoryConsumable(CategoryConsumableEntity categoryConsumableEntity);
    List<CategoryConsumable> toCategoryConsumables(List<CategoryConsumableEntity> categoryConsumableEntities);

    // Model to Entity
    CategoryConsumableEntity toCategoryConsumableEntity(CategoryConsumable categoryConsumable);
    List<CategoryConsumableEntity> toCategoryConsumablesEntity(List<CategoryConsumableEntity> categoryConsumableEntities);
}
