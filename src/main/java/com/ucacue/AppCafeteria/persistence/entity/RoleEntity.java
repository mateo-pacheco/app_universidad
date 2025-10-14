package com.ucacue.AppCafeteria.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app_role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role", unique = true, nullable = false)
    private Long idRole;

    @Column(name = "role_name", length = 50, nullable = false)
    private String roleName;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_date", nullable = false)
    private LocalDateTime updatedAt;

    // Relaciones
    // Rol - Usuario
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    @Builder.Default
    private List<UserEntity> users = new ArrayList<>();
}
