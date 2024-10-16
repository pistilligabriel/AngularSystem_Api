package com.learning.api.angularsystem.entitys.faturamento.estoque;

import com.learning.api.angularsystem.entitys.cadastro.integrante.IntegranteEntity;
import com.learning.api.angularsystem.entitys.cadastro.item.ItemEntity;
import com.learning.api.angularsystem.entitys.cadastro.item.UnidadeMedidaEntity;
import com.learning.api.angularsystem.entitys.faturamento.pedido.PedidoDetalheEntity;
import com.learning.api.angularsystem.enums.estoque.TipoEstoque;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "estoque")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoEstoque tipo;

    @Column(name = "DATA_OPERACAO")
    private LocalDateTime dataOperacao;

    @JoinColumn(name = "ITEM")
    @ManyToOne
    private ItemEntity item;

    @JoinColumn(name = "UNDIADE_MEDIDA")
    @ManyToOne
    private UnidadeMedidaEntity unidadeMedida;

    @Column(name = "QUANTIDADE")
    private Double quantidade;

    @Column(name = "VALOR_UNITARIO")
    private Double valorUnitario;

    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;

    @JoinColumn(name = "FUNCIONARIO")
    @ManyToOne
    private IntegranteEntity funcionario;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @JoinColumn(name = "PEDIDO_DETALHE")
    @ManyToOne
    private PedidoDetalheEntity pedidoDetalhe;

    @Column(name = "EMPRESA")
    private Long empresa = 1L;

    @Column(name = "VERSAO")
    private LocalDateTime versao = LocalDateTime.now();


}
