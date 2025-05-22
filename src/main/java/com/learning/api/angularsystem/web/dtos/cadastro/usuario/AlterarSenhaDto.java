package com.learning.api.angularsystem.web.dtos.cadastro.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlterarSenhaDto {

    @NotBlank(message = "O campo nome é obrigatório")
    private String login;
    @NotNull(message = "É necessário inserir nova senha")
    private String password;

}
