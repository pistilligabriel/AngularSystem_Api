package com.learning.api.angularsystem.entitys.faturamento.pedido;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.api.angularsystem.entitys.cadastro.item.ItemEntity;
import com.learning.api.angularsystem.web.dtos.faturamento.pedido.PedidoDto;
import com.learning.api.angularsystem.entitys.cadastro.integrante.IntegranteEntity;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.enums.pedido.FinalidadePedido;
import com.learning.api.angularsystem.enums.pedido.StatusPedido;
import com.learning.api.angularsystem.enums.pedido.TipoMovimentacaoPedido;
import com.learning.api.angularsystem.enums.pedido.TipoPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoPedido tipo;

    @Column(name = "FINALIDADE")
    @Enumerated(EnumType.STRING)
    private FinalidadePedido finalidade = FinalidadePedido.NORMAL;

    @Column(name = "STATUS_PEDIDO")
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido = StatusPedido.PEDIDO;

    @Column(name = "NUMERO")
    private Long numero;

    @Column(name = "DATA_EMISSAO")
    private LocalDateTime dataEmissao;

    @Column(name = "DATA_VALIDADE")
    private LocalDateTime dataValidade;

    @JoinColumn(name = "INTEGRANTE")
    @ManyToOne
    private IntegranteEntity integrante;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ItemEntity> produtos = new HashSet<>();

    @Column(name = "TOTAL_PRODUTO")
    private Double totalProduto;

    @Column(name = "TOTAL_DESCONTO")
    private Double totalDesconto;

    @Column(name = "TOTAL_ACRESCIMO")
    private Double totalAcrescimo;

    @Column(name = "TOTAL")
    @Formula("totalProduto - totalDesconto + totalAcrescimo")
    private Double total;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status = Status.NORMAL;

    @Column(name = "EMPRESA")
    private Long empresa = 1L;

    @Column(name = "VERSAO")
    private LocalDateTime versao = LocalDateTime.now();


    public void setStatusNormal() {
        this.status = Status.NORMAL;
        this.versao = LocalDateTime.now();
    }

    public void setStatusCancelado() {
        this.status = Status.CANCELADO;
        this.versao = LocalDateTime.now();
    }
}
