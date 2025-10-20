package com.ucacue.AppCafeteria.persistence.mapper;

import com.ucacue.AppCafeteria.domain.model.Consumable;
import com.ucacue.AppCafeteria.persistence.entity.ConsumableEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConsumableMapper {
    // Entity to Model
    Consumable toConsumable(ConsumableEntity consumableEntity);
    List<Consumable> toConsumables(List<ConsumableEntity> consumableEntities);

    // Model to Entity
    @Mapping(target = "purchaseOrderDetails", ignore = true)
    ConsumableEntity toConsumableEntity(Consumable consumable);
    List<ConsumableEntity> toConsumablesEntity(List<Consumable> consumables);
}
