package com.ucacue.AppCafeteria.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app_category_sale")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategorySaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category_sale", unique = true, nullable = false)
    private Long idCategorySale;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "active")
    private boolean active;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_date", nullable = false)
    private LocalDateTime updatedAt;

    // Relaciones
    // Categoria Venta - Producto Venta
    @OneToMany(mappedBy = "categorySale", fetch = FetchType.LAZY)
    @Builder.Default
    private List<ProductoSaleEntity> productoSaleEntities = new ArrayList<>();
}
