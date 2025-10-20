package com.ucacue.AppCafeteria.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app_category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category", unique = true, nullable = false)
    private Long idCategory;

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
    // Categoria - Producto
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @Builder.Default
    @JsonIgnore
    private List<ProductEntity> products = new ArrayList<>();
}
