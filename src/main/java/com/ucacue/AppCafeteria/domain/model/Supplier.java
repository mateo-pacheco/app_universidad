package com.ucacue.AppCafeteria.domain.model;

import lombok.*;

import java.time.LocalDateTime;

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
}
