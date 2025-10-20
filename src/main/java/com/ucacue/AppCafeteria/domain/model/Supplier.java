package com.ucacue.AppCafeteria.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Supplier {
    private Long idSupplier;

    private String name;

    private String phone;

    private String email;

    private String address;

    private boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<PurchaseOrder> purchaseOrders = new ArrayList<>();
}
