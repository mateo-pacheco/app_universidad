package com.ucacue.AppCafeteria.web.mapper;

import com.ucacue.AppCafeteria.domain.model.Product;
import com.ucacue.AppCafeteria.web.dto.request.ProductRequest;
import com.ucacue.AppCafeteria.web.dto.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductWebMapper {
    // Request
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "category", ignore = true)
    Product toProduct(ProductRequest productRequest);
    List<Product> toProducts(List<ProductRequest> productRequests);

    // Response
    ProductResponse toProductResponse(Product product);
    List<ProductResponse> toProductsResponse(List<Product> products);
}
