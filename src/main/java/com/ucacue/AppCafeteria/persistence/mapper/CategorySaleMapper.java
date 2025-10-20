package com.ucacue.AppCafeteria.persistence.mapper;

import com.ucacue.AppCafeteria.domain.model.CategorySale;
import com.ucacue.AppCafeteria.persistence.entity.CategorySaleEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductSaleMapper.class})
public interface CategorySaleMapper {
    // Entity to Model
    CategorySale toCategorySale(CategorySaleEntity categorySaleEntity);
    List<CategorySale> toCategorySales(List<CategorySaleEntity> categorySales);

    // Model to Entity
    CategorySaleEntity toCategorySaleEntity(CategorySale categorySale);
    List<CategorySaleEntity> toCategorySalesEntity(List<CategorySale> categorySales);
}
