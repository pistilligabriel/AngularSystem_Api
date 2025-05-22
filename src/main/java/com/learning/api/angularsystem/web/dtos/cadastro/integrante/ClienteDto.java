package com.learning.api.angularsystem.web.dtos.cadastro.integrante;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClienteDto {

    private String nome;

    private String sobrenome;

    private String telefone;

    private String email;

    private String tipoDocumento;

    private String documento;

    private String cep;

    private String logradouro;

    private int numero;

    private String bairro;

    private String municipio;

    private String uf;

    private String complemento;

}
