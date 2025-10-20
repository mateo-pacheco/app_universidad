package com.ucacue.AppCafeteria.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryConsumable {
    private Long idCategoryConsumable;

    private String name;

    private String description;

    private boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<Consumable> consumables = new ArrayList<>();
}
