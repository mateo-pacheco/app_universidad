package com.ucacue.AppCafeteria.persistence.mapper;

import com.ucacue.AppCafeteria.domain.model.Product;
import com.ucacue.AppCafeteria.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    // Entity to Model
    Product toProduct(ProductEntity productEntity);
    List<Product> toProducts(List<ProductEntity> productEntities);

    // Model to Entity
    @Mapping(target = "recipes", ignore = true)
    ProductEntity toProductEntity(Product product);
    List<ProductEntity> toProductsEntity(List<Product> products);
}
