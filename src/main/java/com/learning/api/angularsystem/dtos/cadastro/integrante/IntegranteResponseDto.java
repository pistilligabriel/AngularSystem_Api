package com.learning.api.angularsystem.dtos.cadastro.integrante;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IntegranteResponseDto {
    private Long codigo;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String email;
    private String cep;
    private String enderecoCompleto;
}
