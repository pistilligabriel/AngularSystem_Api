package com.learning.api.angularsystem.dtos.faturamento.ordem_servico;

public class NewOrdemServicoDetalheDto {

    private final Long CODIGO;

    public NewOrdemServicoDetalheDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
