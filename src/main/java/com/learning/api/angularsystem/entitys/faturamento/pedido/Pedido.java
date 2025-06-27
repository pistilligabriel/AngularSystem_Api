package com.learning.api.angularsystem.entitys.faturamento.pedido;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.api.angularsystem.entitys.cadastro.integrante.Cliente;
import com.learning.api.angularsystem.entitys.cadastro.item.Item;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.enums.movimentacao.TipoFormaPagamento;
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
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status = Status.NORMAL;

    @Column(name = "DATA_EMISSAO")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataEmissao;

    @JoinColumn(name = "INTEGRANTE")
    @ManyToOne
    private Cliente integrante;

    @Enumerated(EnumType.STRING)
    private TipoFormaPagamento formaPagamento;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PedidoDetalhe> detalhes = new ArrayList<>();

    @Column(name = "DESCONTO")
    private Double desconto;

    @Column(name = "PORCENTAGEM_DESCONTO")
    private Double porcentagemDesconto;

    @Column(name = "TOTAL")
    @Formula("(valorUnitario * quantidade)")
    private Double total;

    @Column(name = "TOTAL_BRUTO")
    @Formula("(valorUnitario * quantidade)")
    private Double totalSemDesconto;

    @Column(name = "PARCELAS")
    private int parcelas;

    @Column(name = "LUCRO")
    private Double lucro;

    @Column(name = "EMPRESA")
    private Long empresa = 1L;

    @Column(name = "VERSAO")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime versao = LocalDateTime.now();


    public void setStatusNormal() {
        this.status = Status.NORMAL;
        this.versao = LocalDateTime.now();
    }

    public void setStatusCancelado() {
        this.status = Status.CANCELADO;
        this.versao = LocalDateTime.now();
    }

    public void setStatusFaturado(){
        this.status = Status.FATURADO;
        this.versao = LocalDateTime.now();
    }
}
