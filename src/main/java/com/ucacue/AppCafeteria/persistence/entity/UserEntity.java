package com.ucacue.AppCafeteria.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "app_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", unique = true, nullable = false)
    private Long idUser;

    @Column(name = "full_name", length = 50, nullable = false)
    private String fullName;

    @Column(name = "email", length = 50, unique = true, nullable = false)
    private String email;

    @Column(name = "password_hash", length = 255, nullable = false)
    private String passwordHash;

    @Column(name = "phone", length = 10, nullable = false)
    private String phone;

    @Column(name = "address", length = 200,  nullable = false)
    private String address;

    @Column(name = "identification", length = 10, unique = true, nullable = false)
    private String identification;

    @Column(name = "active")
    private boolean active;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_date", nullable = false)
    private LocalDateTime updatedAt;

    //  Relaciones
    // Usuario - Rol
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role", referencedColumnName = "id_role", nullable = false)
    private RoleEntity role;
}
