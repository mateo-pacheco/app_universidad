package com.ucacue.AppCafeteria.domain.model;

import com.ucacue.AppCafeteria.domain.enumerations.OrderType;
import com.ucacue.AppCafeteria.domain.enumerations.PaymentMethod;
import com.ucacue.AppCafeteria.domain.enumerations.StatusSale;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sale {
    private Long idSale;

    private String tableNumber;

    private BigDecimal subtotal;

    private BigDecimal discount;

    private BigDecimal total;

    private PaymentMethod paymentMethod;

    private StatusSale status;

    private OrderType orderType;

    private String notes;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<SaleDetail> saleDetails = new ArrayList<>();
}
