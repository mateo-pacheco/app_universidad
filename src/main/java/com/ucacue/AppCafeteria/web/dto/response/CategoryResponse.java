package com.ucacue.AppCafeteria.web.dto.response;

import com.ucacue.AppCafeteria.domain.model.Product;

import java.time.LocalDateTime;
import java.util.List;

public record CategoryResponse(
        Long idCategory,

        String name,

        String description,

        boolean active,

        LocalDateTime createdAt,

        LocalDateTime updatedAt
) {
}
