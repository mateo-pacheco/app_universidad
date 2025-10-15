package com.ucacue.AppCafeteria.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app_sale_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detail", unique = true, nullable = false)
    private Long idDetail;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "subtotal", precision = 10, scale = 2, nullable = false)
    private BigDecimal subtotal;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_date", nullable = false)
    private LocalDateTime updatedAt;

    // Relaciones
    // Venta Detalle - Venta
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sale", referencedColumnName = "id_sale", nullable = false)
    private SaleEntity sale;

    // Venta Detalle - Producto Venta
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product_sale", referencedColumnName = "id_product_sale", nullable = false)
    private ProductoSaleEntity productSale;
}
