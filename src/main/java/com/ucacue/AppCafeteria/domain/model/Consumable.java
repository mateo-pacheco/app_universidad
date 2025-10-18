package com.ucacue.AppCafeteria.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Consumable {
    private Long idConsumable;

    private String name;

    private String description;

    private BigDecimal purchasePrice;

    private BigDecimal salePrice;

    private Integer maximumStock;

    private Integer minimumStock;

    private Integer currentStock;

    private String code;

    private String imageUrl;

    private BigDecimal discount;

    private boolean active = true;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
