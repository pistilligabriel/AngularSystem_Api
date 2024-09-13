package com.learning.api.angularsystem.dtos.faturamento.ordem_servico;

public class NewOrdemServicoEquipamentoDto {

    private final Long CODIGO;

    public NewOrdemServicoEquipamentoDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
