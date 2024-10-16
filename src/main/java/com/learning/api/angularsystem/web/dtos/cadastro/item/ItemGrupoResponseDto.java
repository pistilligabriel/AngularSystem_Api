package com.learning.api.angularsystem.web.dtos.cadastro.item;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemGrupoResponseDto {

    private Long codigo;

    private String descricao;

    private String status;
}
