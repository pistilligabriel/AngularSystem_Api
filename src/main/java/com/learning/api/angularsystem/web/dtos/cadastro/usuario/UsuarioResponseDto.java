package com.learning.api.angularsystem.web.dtos.cadastro.usuario;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioResponseDto {
    private Long codigo;
    private String nome;
    private String login;
    private String status;
}
