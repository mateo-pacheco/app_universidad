package com.ucacue.AppCafeteria.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "app_product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product", unique = true, nullable = false)
    private Long idProduct;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "purchase_price", precision = 10, scale = 2,  nullable = false)
    private BigDecimal purchasePrice;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_date", nullable = false)
    private LocalDateTime updatedAt;

    // Relaciones
    // Producto - Categoria
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category", referencedColumnName = "id_category", nullable = false)
    private CategoryEntity category;
}
