package com.learning.api.angularsystem.enums.usuario;

import lombok.Getter;

@Getter
public enum Role {

    SUPER("Super"),
    ADMIN("Administrador"),
    USER("Usuário");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
