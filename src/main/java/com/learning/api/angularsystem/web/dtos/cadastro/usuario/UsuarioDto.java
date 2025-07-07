package com.learning.api.angularsystem.web.dtos.cadastro.usuario;

import com.learning.api.angularsystem.enums.usuario.Tipo;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioDto {
    private Long codigo;

    @NotBlank(message = "O campo nome é obrigatório")
    private String nomeCompleto;

    private Tipo tipo;

    private String email;

    private String documento;

    private String telefone;

    @NotBlank(message = "O campo login é obrigatório")
    private String login;

    @NotBlank(message = "O campo senha é obrigatório")
    private String password;

}
