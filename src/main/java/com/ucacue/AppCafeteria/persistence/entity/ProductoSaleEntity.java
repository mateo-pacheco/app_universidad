package com.ucacue.AppCafeteria.persistence.entity;

import com.ucacue.AppCafeteria.domain.enumerations.StatusProductSale;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app_product_sale")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoSaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_sale", unique = true, nullable = false)
    private Long idProductSale;

    @Column(name = "code", length = 250, unique = true, nullable = false)
    private String code;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "sale_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal salePrice;

    @Column(name = "discount", precision = 10, scale = 2, nullable = false)
    private BigDecimal discount;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "active")
    private boolean active;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusProductSale status;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_date", nullable = false)
    private LocalDateTime updatedAt;

    // Relaciones
    // Producto Venta - Categoria Venta
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category_sale", referencedColumnName = "id_category_sale", nullable = false)
    private CategorySaleEntity categorySale;

    // Producto Venta - Venta Detalle
    @OneToMany(mappedBy = "productSale", fetch = FetchType.LAZY)
    @Builder.Default
    private List<SaleDetailEntity> saleDetails = new ArrayList<>();

    // Producto Venta - Receta
    @OneToMany(mappedBy = "productSale", fetch = FetchType.LAZY)
    @Builder.Default
    private List<RecipeEntity> recipes = new ArrayList<>();
}
