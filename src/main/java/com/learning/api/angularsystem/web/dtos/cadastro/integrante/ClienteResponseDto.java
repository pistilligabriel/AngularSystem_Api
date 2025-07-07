package com.learning.api.angularsystem.web.dtos.cadastro.integrante;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClienteResponseDto {
    private Long codigo;
    private String status;
    private String nomeCompleto;
    private String telefone;
    private String documento;
    private String tipoDocumento;
    private String email;
    private String cep;
    private String logradouro;
    private int numero;
    private String bairro;
    private String municipio;
    private String uf;
    private int empresa;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime versao;
}
