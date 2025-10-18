package com.ucacue.AppCafeteria.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recipe {
    private Long idRecipe;

    private BigDecimal quantity;

    private String unit;

    private String notes;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
