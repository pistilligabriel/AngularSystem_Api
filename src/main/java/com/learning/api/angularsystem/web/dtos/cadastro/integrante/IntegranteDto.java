package com.learning.api.angularsystem.web.dtos.cadastro.integrante;

import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.enums.integrante.TipoIntegrante;
import com.learning.api.angularsystem.entitys.cadastro.integrante.IntegranteEntity;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IntegranteDto {

    private String nome;

    private String sobrenome;

    private String telefone;

    private String email;

    private String tipoDocumento;

    private String documento;

    private String cep;

    private String logradouro;

    private Integer numero;

    private String bairro;

    private String municipio;

    private String uf;

    private String complemento;

}
