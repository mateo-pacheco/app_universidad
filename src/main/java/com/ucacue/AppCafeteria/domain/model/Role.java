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
public class Role {
    private Long idRole;

    private String roleName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<User> users = new ArrayList<>();
}
