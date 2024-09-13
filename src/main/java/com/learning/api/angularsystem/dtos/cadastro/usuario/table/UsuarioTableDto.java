package com.learning.api.angularsystem.dtos.cadastro.usuario.table;

import com.learning.api.angularsystem.entitys.cadastro.usuario.UsuarioEntity;
import com.learning.api.angularsystem.enums.Status;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record UsuarioTableDto(

        Long CODIGO,

        @NotBlank(message = "O campo nome é obrigatório")
        String login,

        @NotBlank(message = "O campo senha é obrigatório")
        String password,

        @Enumerated
        Status status,

        LocalDateTime versao
) {

    public UsuarioTableDto(UsuarioEntity usuarioEntity) {
        this(usuarioEntity.getCODIGO(),
                usuarioEntity.getLogin(),
                usuarioEntity.getPassword(),
                usuarioEntity.getStatus(),
                usuarioEntity.getVersao());
    }
}
