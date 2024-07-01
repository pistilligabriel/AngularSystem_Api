package com.learning.api.minisys.dtos.cadastro.usuario;

import com.learning.api.minisys.dtos.cadastro.integrante.NewIntegranteDto;
import com.learning.api.minisys.entitys.cadastro.usuario.UsuarioEntity;
import com.learning.api.minisys.enums.Status;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AlterarSenhaDto(

        Long CODIGO,

        @NotBlank(message = "O campo nome é obrigatório")
        String login,

        @NotNull(message = "É necessário inserir nova senha")
        String password,

        @Enumerated
        Status status,

        Long empresa,

        LocalDateTime versao

) {

    public AlterarSenhaDto(UsuarioEntity usuarioEntity) {
        this(usuarioEntity.getCODIGO(),
                usuarioEntity.getLogin(),
                usuarioEntity.getPassword(),
                usuarioEntity.getStatus(),
                usuarioEntity.getEmpresa(),
                usuarioEntity.getVersao());
    }
}
