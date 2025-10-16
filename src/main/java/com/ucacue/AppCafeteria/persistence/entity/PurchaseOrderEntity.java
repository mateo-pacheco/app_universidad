package com.ucacue.AppCafeteria.persistence.entity;

import com.ucacue.AppCafeteria.domain.enumerations.PurchaseOrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app_purchase_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_purchase_order", unique = true, nullable = false)
    private Long idPurchaseOrder;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "issue_date", nullable = false)
    private LocalDateTime issueDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PurchaseOrderStatus status;

    @Column(name = "subtotal", precision = 10, scale = 2, nullable = false)
    private BigDecimal subtotal;

    @Column(name = "taxes", precision = 10, scale = 2, nullable = false)
    private BigDecimal taxes;

    @Column(name = "total", precision = 10, scale = 2, nullable = false)
    private BigDecimal total;

    @Column(name = "notes", nullable = false, columnDefinition = "TEXT")
    private String notes;

    // Relaciones
    // Orden Compra - Orden Compra Detalle
    @OneToMany(mappedBy = "purchaseOrder", fetch = FetchType.LAZY)
    @Builder.Default
    private List<PurchaseOrderDetailEntity> purchaseOrderDetails = new ArrayList<>();

    // Orden Compra - Proveedor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_supplier", referencedColumnName = "id_supplier", nullable = false)
    private SupplierEntity supplier;
}
