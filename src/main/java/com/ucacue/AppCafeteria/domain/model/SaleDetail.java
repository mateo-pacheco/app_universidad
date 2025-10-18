package com.ucacue.AppCafeteria.domain.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleDetail {
    private Long idDetail;

    private Integer quantity;

    private BigDecimal unitPrice;

    private BigDecimal subtotal;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
