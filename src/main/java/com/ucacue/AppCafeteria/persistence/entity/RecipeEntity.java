package com.ucacue.AppCafeteria.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "app_recipe")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recipe", unique = true, nullable = false)
    private Long idRecipe;

    @Column(name = "quantity", precision = 10, scale = 2, nullable = false)
    private BigDecimal quantity;

    @Column(name = "unit", length = 20, nullable = false)
    private String unit;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_date", nullable = false)
    private LocalDateTime updatedAt;

    // Relaciones
    // Receta - Producto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product", referencedColumnName = "id_product", nullable = false)
    private ProductEntity productEntity;

    // Receta - Producto Venta
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product_sale", referencedColumnName = "id_product_sale", nullable = false)
    private ProductoSaleEntity productSaleEntity;
}
