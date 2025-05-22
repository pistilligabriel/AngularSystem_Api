package com.learning.api.angularsystem.web.dtos.cadastro.integrante;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClienteResponseDto {
    private Long codigo;
    private String status;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String email;
    private String cep;
    private String logradouro;
    private int numero;
    private String bairro;
    private String municipio;
    private String uf;
}
