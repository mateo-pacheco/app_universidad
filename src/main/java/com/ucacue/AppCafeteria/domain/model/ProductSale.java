package com.ucacue.AppCafeteria.domain.model;

import com.ucacue.AppCafeteria.domain.enumerations.StatusProductSale;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductSale {
    private Long idProductSale;

    private String code;

    private String name;

    private String description;

    private String imageUrl;

    private BigDecimal salePrice;

    private BigDecimal discount;

    private Integer stock;

    private boolean active;

    private StatusProductSale status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private CategorySale categorySale;
}
