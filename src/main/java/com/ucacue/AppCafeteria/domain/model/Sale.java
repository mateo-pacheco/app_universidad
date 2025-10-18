package com.ucacue.AppCafeteria.domain.model;

import com.ucacue.AppCafeteria.domain.enumerations.OrderType;
import com.ucacue.AppCafeteria.domain.enumerations.PaymentMethod;
import com.ucacue.AppCafeteria.domain.enumerations.StatusSale;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sale {
    private Long idSale;

    private BigDecimal subtotal;

    private BigDecimal discount;

    private BigDecimal total;

    private PaymentMethod paymentMethod;

    private StatusSale status;

    private OrderType orderType;

    private String notes;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
