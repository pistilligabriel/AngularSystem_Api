package com.learning.api.angularsystem.dtos.cadastro.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlterarSenhaDto {

    private Long codigo;
    @NotBlank(message = "O campo nome é obrigatório")
    private String login;
    @NotNull(message = "É necessário inserir nova senha")
    private String password;
    private String status;
    private Long empresa;
    private LocalDateTime versao;


}
