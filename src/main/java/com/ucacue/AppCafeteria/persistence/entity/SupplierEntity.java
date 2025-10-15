package com.ucacue.AppCafeteria.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app_supplier")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_supplier", unique = true, nullable = false)
    private Long idSupplier;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "phone", length = 10, nullable = false)
    private String phone;

    @Column(name = "email", length = 50, unique = true, nullable = false)
    private String email;

    @Column(name = "address", length = 200, nullable = false)
    private String address;

    @Column(name = "active")
    private boolean active;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_date", nullable = false)
    private LocalDateTime updatedAt;

    // Relaciones
}
