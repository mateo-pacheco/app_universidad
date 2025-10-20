package com.ucacue.AppCafeteria.web.dto.request;

import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;


public record ProductRequest(
        Long idProduct,

        @NotNull(message = "El código del producto no puede ser nulo.")
        String code,

        @NotNull(message = "El nombre del producto no puede ser nulo.")
        String name,

        @NotNull(message = "La descripción del producto no puede ser nulo.")
        String description,

        @Positive(message = "El precio de venta no puede ser negativo")
        BigDecimal purchasePrice,

        @NotNull(message = "La url de la imagen no puede ser nulo.")
        String imageUrl,

        boolean active,

        @NotNull(message = "El id del producto no puede ser nulo.")
        Long idCategory
) {
}
