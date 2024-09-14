package com.learning.api.angularsystem.dtos.cadastro.integrante;

import com.learning.api.angularsystem.entitys.cadastro.integrante.IntegranteEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IntegranteResponseDto {
    private Long codigo;
    private String status;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String email;
    private String cep;
    private String logradouro;
    private Integer numero;
    private String bairro;
    private String municipio;
    private String uf;
}
