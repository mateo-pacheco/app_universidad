package com.ucacue.AppCafeteria.domain.validation;

import com.ucacue.AppCafeteria.domain.model.Category;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CategoryValidation {

    public void createCategoria(Category category) {
        if (category == null) {
            throw new IllegalStateException("La categoria no puede ser nulo");
        }

        if (category.getIdCategory() != null) {
            throw new IllegalStateException("El id de la categoria debe ser nulo");
        }
    }

    public void updateCategoria(Category category) {
        if (category == null) {
            throw new IllegalStateException("La categoria no puede ser nulo");
        }

        if (category.getIdCategory() == null) {
            throw new IllegalStateException("El id de la categoria no debe ser nulo");
        }
    }

    public void deleteCategoria(Long id) {
        if (id == null) {
            throw new IllegalStateException("El id de la categoria no debe ser nulo");
        }
    }

    public void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("El nombre de la categoria no puede estar vacío");
        }
        if (name.length() > 100) {
            throw new IllegalStateException("El nombre de la categoria no debe superar los 100 caracteres");
        }
    }

    public void validateActive(Boolean active) {
        if (active == null) {
            throw new IllegalStateException("El estado activo no puede ser nulo");
        }
    }
}
