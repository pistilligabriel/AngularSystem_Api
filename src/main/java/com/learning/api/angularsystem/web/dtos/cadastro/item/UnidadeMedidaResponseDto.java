package com.learning.api.angularsystem.web.dtos.cadastro.item;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UnidadeMedidaResponseDto {
    private Long codigo;
    private String descricao;
    private String simbolo;
    private String status;
    private int empresa;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime versao;
}
