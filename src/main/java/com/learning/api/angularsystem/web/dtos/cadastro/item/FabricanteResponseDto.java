package com.learning.api.angularsystem.web.dtos.cadastro.item;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FabricanteResponseDto {
    private Long codigo;
    private String descricao;
    private String status;
    private int empresa;
    private LocalDateTime versao;
}
