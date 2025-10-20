package com.ucacue.AppCafeteria.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long idUser;

    private String fullName;

    private String email;

    private String passwordHash;

    private String phone;

    private String address;

    private String identification;

    private boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Role role;
}
