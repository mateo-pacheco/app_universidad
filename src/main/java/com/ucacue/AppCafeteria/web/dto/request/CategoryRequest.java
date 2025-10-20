package com.ucacue.AppCafeteria.web.dto.request;

import jakarta.validation.constraints.NotNull;


public record CategoryRequest(
        Long idCategory,

        @NotNull(message = "El nombre de la categoria no puede ser nulo")
        String name,

        @NotNull(message = "La descripción  de la categoria no puede ser nulo")
        String description,

        boolean active
) {
}
