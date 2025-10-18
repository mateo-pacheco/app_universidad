package com.ucacue.AppCafeteria.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategorySale {
    private Long idCategorySale;

    private String name;

    private String description;

    private boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
