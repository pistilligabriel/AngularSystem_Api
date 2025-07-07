package com.learning.api.angularsystem.web.dtos.cadastro.usuario;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.learning.api.angularsystem.enums.usuario.Tipo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioResponseDto {
    private Long codigo;
    private String nomeCompleto;
    private Tipo tipo;
    private String email;
    private String telefone;
    private String documento;
    private String login;
    private String status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCadastro;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime versao;
}
