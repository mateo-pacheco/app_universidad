package com.ucacue.AppCafeteria.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "app_purchase_order_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseOrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_purchase_order_detail", unique = true, nullable = false)
    private Long idPurchaseOrderDetail;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "subtotal", precision = 10, scale = 2, nullable = false)
    private BigDecimal subtotal;

    // Relaciones
    // Orden Compra Detalle - Producto Consumible
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_consumable", referencedColumnName = "id_consumable", nullable = false)
    private ConsumableEntity consumable;

    // Orden Compra Detalle - Orden Compra
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_purchase_order", referencedColumnName = "id_purchase_order", nullable = false)
    private PurchaseOrderEntity purchaseOrder;
}
