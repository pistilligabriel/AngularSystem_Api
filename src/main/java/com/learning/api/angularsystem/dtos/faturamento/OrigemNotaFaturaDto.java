package com.learning.api.angularsystem.dtos.faturamento;

import com.learning.api.angularsystem.dtos.faturamento.nota_fiscal.NewNotaFiscalDetalheDto;
import com.learning.api.angularsystem.dtos.faturamento.ordem_servico.NewOrdemServicoDetalheDto;
import com.learning.api.angularsystem.dtos.faturamento.pedido.NewPedidoDetalheDto;
import com.learning.api.angularsystem.entitys.faturamento.OrigemNotaFaturaEntity;

import java.time.LocalDateTime;

public record OrigemNotaFaturaDto(

        Long CODIGO,
        LocalDateTime dataCriacao,
        NewPedidoDetalheDto pedidoDetalhe,
        NewOrdemServicoDetalheDto ordemServicoDetalhe,
        NewNotaFiscalDetalheDto notaFiscalDetalhe

) {

    public OrigemNotaFaturaDto(OrigemNotaFaturaEntity origemNotaFaturaEntity){
        this(origemNotaFaturaEntity.getCODIGO(),
                origemNotaFaturaEntity.getDataCriacao(),
                origemNotaFaturaEntity.getPedidoDetalhe() != null ?
                        new NewPedidoDetalheDto(origemNotaFaturaEntity.getPedidoDetalhe().getCODIGO()) : null,
                origemNotaFaturaEntity.getOrdemServicoDetalhe() != null ?
                        new NewOrdemServicoDetalheDto(origemNotaFaturaEntity.getOrdemServicoDetalhe().getCODIGO()) : null,
                origemNotaFaturaEntity.getNotaFiscalDetalhe() != null ?
                        new NewNotaFiscalDetalheDto(origemNotaFaturaEntity.getNotaFiscalDetalhe().getCODIGO()) : null
        );
    }
}
