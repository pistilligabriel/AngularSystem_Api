package com.learning.api.angularsystem.dtos.faturamento.ordem_servico;

public class NewOrdemServicoDto {

    private final Long CODIGO;

    public NewOrdemServicoDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
