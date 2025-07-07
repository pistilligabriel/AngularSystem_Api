package com.learning.api.angularsystem.web.dtos.cadastro.usuario;

import com.learning.api.angularsystem.entitys.cadastro.usuario.Usuario;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginResponseDto {
    private String token;
    private Usuario usuario;
}
