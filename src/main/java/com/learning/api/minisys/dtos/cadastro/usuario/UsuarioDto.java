package com.learning.api.minisys.dtos.cadastro.usuario;

import com.learning.api.minisys.dtos.cadastro.integrante.NewIntegranteDto;
import com.learning.api.minisys.entitys.cadastro.usuario.UsuarioEntity;
import com.learning.api.minisys.enums.Status;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UsuarioDto(

        Long CODIGO,

        @NotBlank(message = "O campo nome é obrigatório")
        String nome,

        String sobrenome,

        String telefone,

        String email,

        @NotBlank(message = "O campo documento é obrigatório")
        String documento,

        @NotBlank(message = "O campo login é obrigatório")
        String login,

        @NotBlank(message = "O campo senha é obrigatório")
        String password,

        @Enumerated
        Status status,

        Long empresa,

        LocalDateTime versao

) {

    public UsuarioDto(UsuarioEntity usuarioEntity) {
        this(usuarioEntity.getCODIGO(),
                usuarioEntity.getNome(),
                usuarioEntity.getSobrenome(),
                usuarioEntity.getTelefone(),
                usuarioEntity.getEmail(),
                usuarioEntity.getDocumento(),
                usuarioEntity.getLogin(),
                usuarioEntity.getPassword(),
                usuarioEntity.getStatus(),
                usuarioEntity.getEmpresa(),
                usuarioEntity.getVersao());
    }
}
