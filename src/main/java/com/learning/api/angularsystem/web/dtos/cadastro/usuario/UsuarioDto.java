package com.learning.api.angularsystem.web.dtos.cadastro.usuario;

import com.learning.api.angularsystem.entitys.cadastro.usuario.UsuarioEntity;
import com.learning.api.angularsystem.enums.Status;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioDto {

    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;

    private String sobrenome;

    private String telefone;

    private String email;

    @NotBlank(message = "O campo documento é obrigatório")
    private String documento;

    @NotBlank(message = "O campo login é obrigatório")
    private String login;

    @NotBlank(message = "O campo senha é obrigatório")
    private String password;

}
