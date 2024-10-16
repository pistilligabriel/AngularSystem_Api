package com.learning.api.angularsystem.web.dtos.cadastro.integrante;

import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.enums.integrante.TipoIntegrante;
import com.learning.api.angularsystem.entitys.cadastro.integrante.IntegranteEntity;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public class IntegranteDto {

    private Long CODIGO;

    private String tipoIntegrante;

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

    private LocalDateTime dataCriacao;

    private String status;

    private Long empresa;

    private LocalDateTime versao;

}
