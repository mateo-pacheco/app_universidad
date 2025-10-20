package com.ucacue.AppCafeteria.domain.validation;

import com.ucacue.AppCafeteria.domain.model.Product;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductValidation {

    public void createProduct(Product product) {
        if (product == null) {
            throw new IllegalStateException("El producto no puede ser nulo");
        }

        if (product.getIdProduct() != null) {
            throw new IllegalStateException("El id del producto debe ser nulo");
        }
    }

    public void updateProduct(Product product) {
        if (product == null) {
            throw new IllegalStateException("El producto no puede ser nulo");
        }

        if (product.getIdProduct() == null) {
            throw new IllegalStateException("El id del producto no debe ser nulo");
        }
    }

    public void deleteProduct(Long id) {
        if (id == null) {
            throw new IllegalStateException("El id del producto no debe ser nulo");
        }
    }

    public void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("El nombre del producto no puede estar vacío");
        }
        if (name.length() > 100) {
            throw new IllegalStateException("El nombre del producto no debe superar los 100 caracteres");
        }
    }

    public void validatePrice(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalStateException("El precio debe ser mayor que cero");
        }
    }

    public void validateActive(Boolean active) {
        if (active == null) {
            throw new IllegalStateException("El estado activo no puede ser nulo");
        }
    }
}
