package com.ucacue.AppCafeteria.web.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductResponse(
        Long idProduct,

        String code,

        String name,

        String description,

        BigDecimal purchasePrice,

        boolean active,

        LocalDateTime createdAt,

        LocalDateTime updatedAt
) {
}
