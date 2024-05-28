package com.learning.api.minisys.dtos.cadastro.integrante;

import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.integrante.TipoDocumento;
import com.learning.api.minisys.enums.integrante.TipoIntegrante;
import com.learning.api.minisys.enums.integrante.TipoLogradouro;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record IntegranteDto(

        Long CODIGO,

        TipoIntegrante tipoIntegrante,

        String nome,

        String segundoNome,

        String telefone,

        String email,

        TipoDocumento tipoDocumento,

        String documento,

        String cep,

        TipoLogradouro tipoLogradouro,

        String logradouro,

        int numero,

        String bairro,

        String municipio,

        String uf,

        String complemento,

        LocalDateTime dataCriacao,

        @Enumerated
        Status status,


        LocalDateTime versao
) {

    public IntegranteDto(IntegranteEntity integranteEntity) {
        this(integranteEntity.getCODIGO(),
                integranteEntity.getTipoIntegrante(),
                integranteEntity.getNome(),
                integranteEntity.getSegundoNome(),
                integranteEntity.getTelefone(),
                integranteEntity.getEmail(),
                integranteEntity.getTipoDocumento(),
                integranteEntity.getDocumento(),
                integranteEntity.getCep(),
                integranteEntity.getTipoLogradouro(),
                integranteEntity.getLogradouro(),
                integranteEntity.getNumero(),
                integranteEntity.getBairro(),
                integranteEntity.getMunicipio(),
                integranteEntity.getUf(),
                integranteEntity.getComplemento(),
                integranteEntity.getDataCriacao(),
                integranteEntity.getStatus(),
                integranteEntity.getVersao());
    }
}
