package com.learning.api.angularsystem.entitys.financeiro.titulo;


import com.learning.api.angularsystem.entitys.cadastro.integrante.Cliente;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.enums.titulo.StatusTitulo;
import com.learning.api.angularsystem.enums.titulo.TipoTitulo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "titulo")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Titulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "STATUS_TITULO")
    @Enumerated(EnumType.STRING)
    private StatusTitulo statusTitulo;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoTitulo tipo;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @JoinColumn(name = "INTEGRANTE")
    @ManyToOne
    private Cliente integrante;

    @JoinColumn(name = "FUNCIONARIO")
    @ManyToOne
    private Cliente funcionario;

    @Column(name = "DATA_LANCAMENTO")
    private LocalDateTime dataLancamento;

    @Column(name = "DATA_VENCIMENTO")
    private LocalDateTime dataVencimento;

    @Column(name = "DATA_ULTIMO_PAGAMENTO")
    private LocalDateTime dataUltimoPagamento;

    @Column(name = "VALOR")
    private Double valor;

    @Column(name = "VALOR_DESCONTO")
    private Double valorDesconto;

    @Column(name = "VALOR_ACRESCIMO")
    private Double valorAcrescimo;

    @Column(name = "VALOR_PAGO")
    private Double valorPago;

    @Column(name = "VALOR_EM_ABERTO")
    private Double valorEmAberto;

    @Column(name = "TOTAL")
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
