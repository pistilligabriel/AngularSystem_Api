package com.learning.api.angularsystem.web.dtos.cadastro.usuario;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioResponseDto {

    private Long codigo;

    private String nome;

    private String sobrenome;

    private String telefone;

    private String email;

    private String documento;

    private String login;


    private String status;

}
