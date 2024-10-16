package com.learning.api.angularsystem.entitys.faturamento.pedido;

import com.learning.api.angularsystem.web.dtos.faturamento.pedido.PedidoDetalheDto;
import com.learning.api.angularsystem.entitys.cadastro.item.ItemEntity;
import com.learning.api.angularsystem.entitys.cadastro.item.UnidadeMedidaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pedido_detalhe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDetalheEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

    @JoinColumn(name = "PEDIDO")
    @OneToOne
    private PedidoEntity pedido;

    @ManyToOne
    @JoinColumn(name = "pedido_codigo")
    private ItemEntity item;

    @Column(name = "CANCELADO")
    private Boolean cancelado;

    @Column(name = "ORDEM")
    private Long ordem;

    @Column(name = "DESCRICAO")
    private String descricao;

    @JoinColumn(name = "UNIDADE_MEDIDA")
    @ManyToOne
    private UnidadeMedidaEntity unidadeMedida;

    @Column(name = "QUANTIDADE")
    private Double quantidade;

    @Column(name = "VALOR_UNITARIO")
    private Double valorUnitario;

    @Column(name = "VALOR_DESCONTO")
    private Double valorDesconto;

    @Column(name = "VALOR_ACRESCIMO")
    private Double valorAcrescimo;

    @Column(name = "VALOR_TOTAL")
    @Formula("(valorUnitario * quantidade)")
    private Double valorTotal;


}
