package com.ucacue.AppCafeteria.persistence.mapper;

import com.ucacue.AppCafeteria.domain.model.ProductSale;
import com.ucacue.AppCafeteria.persistence.entity.ProductoSaleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductSaleMapper {
    // Entity to Model
    ProductSale toProductSale(ProductoSaleEntity productSaleEntity);
    List<ProductSale> toProductSales(List<ProductoSaleEntity> productSalesEntity);

    // Model to Entity
    @Mapping(target = "saleDetails", ignore = true)
    @Mapping(target = "recipes", ignore = true)
    ProductoSaleEntity toProductSaleEntity(ProductSale productSale);
    List<ProductoSaleEntity> toProductSalesEntity(List<ProductSale> productSales);
}
