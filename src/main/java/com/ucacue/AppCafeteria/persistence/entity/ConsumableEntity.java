package com.ucacue.AppCafeteria.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app_consumable")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsumableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consumable", unique = true, nullable = false)
    private Long idConsumable;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "purchase_price", precision = 10, scale = 2,  nullable = false)
    private BigDecimal purchasePrice;

    @Column(name = "sale_price", precision = 10, scale = 2,  nullable = false)
    private BigDecimal salePrice;

    @Column(name = "maximum_stock", nullable = false)
    private Integer maximumStock;

    @Column(name = "minimum_stock", nullable = false)
    private Integer minimumStock;

    @Column(name = "current_stock", nullable = false)
    private Integer currentStock;

    @Column(name = "code", length = 250, unique = true, nullable = false)
    private String code;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "discount", precision = 10, scale = 2, nullable = false)
    private BigDecimal discount;

    @Column(name = "active")
    private boolean active = true;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_date", nullable = false)
    private LocalDateTime updatedAt;

    // Relaciones
    // Producto Consumible - Categoria Consumible
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category_consumable", referencedColumnName = "id_category_consumable", nullable = false)
    private CategoryConsumableEntity categoryConsumable;

    // Producto Consumible - Orden Compra Detalle
    @OneToMany(mappedBy = "consumable", fetch = FetchType.LAZY)
    @Builder.Default
    private List<PurchaseOrderDetailEntity> purchaseOrderDetails = new ArrayList<>();
}
