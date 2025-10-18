package com.ucacue.AppCafeteria.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {
    private Long idRole;

    private String roleName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
