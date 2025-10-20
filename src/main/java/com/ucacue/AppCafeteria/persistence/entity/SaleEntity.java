package com.ucacue.AppCafeteria.persistence.entity;

import com.ucacue.AppCafeteria.domain.enumerations.OrderType;
import com.ucacue.AppCafeteria.domain.enumerations.PaymentMethod;
import com.ucacue.AppCafeteria.domain.enumerations.StatusSale;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app_sale")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sale", unique = true, nullable = false)
    private Long idSale;

    @Column(name = "table_number", nullable = false)
    private String tableNumber;

    @Column(name = "subtotal", precision = 10, scale = 2, nullable = false)
    private BigDecimal subtotal;

    @Column(name = "discount", precision = 10, scale = 2, nullable = false)
    private BigDecimal discount;

    @Column(name = "total", precision = 10, scale = 2, nullable = false)
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusSale status;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_type", nullable = false)
    private OrderType orderType;

    @Column(name = "notes",  nullable = false, columnDefinition = "TEXT")
    private String notes;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_date", nullable = false)
    private LocalDateTime updatedAt;

    // Relaciones
    // Venta - Venta Detalle
    @OneToMany(mappedBy = "sale", fetch = FetchType.LAZY)
    @Builder.Default
    private List<SaleDetailEntity> saleDetails = new ArrayList<>();
}
