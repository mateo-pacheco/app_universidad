package com.ucacue.AppCafeteria.domain.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseOrderDetail {
    private Long idPurchaseOrderDetail;

    private Integer quantity;

    private BigDecimal unitPrice;

    private BigDecimal subtotal;

    private Consumable consumable;

    private PurchaseOrder purchaseOrder;
}
