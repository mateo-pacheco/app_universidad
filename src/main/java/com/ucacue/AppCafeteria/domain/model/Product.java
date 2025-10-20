package com.ucacue.AppCafeteria.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private Long idProduct;

    private String code;

    private String name;

    private String description;

    private BigDecimal purchasePrice;

    private String imageUrl;

    private Boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
