package com.ucacue.AppCafeteria.domain.model;

import com.ucacue.AppCafeteria.domain.enumerations.PurchaseOrderStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseOrder {
    private Long idPurchaseOrder;

    private String code;

    private LocalDateTime issueDate;

    private PurchaseOrderStatus status;

    private BigDecimal subtotal;

    private BigDecimal taxes;

    private BigDecimal total;

    private String notes;
}
