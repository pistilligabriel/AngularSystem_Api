package com.learning.api.angularsystem.entitys.cadastro.item;

import com.learning.api.angularsystem.web.dtos.cadastro.item.ItemDto;
import com.learning.api.angularsystem.enums.Status;
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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

    @Column(name = "DATA_CADASTRO")
    private LocalDateTime dataCadastro;


    @ManyToOne
    @JoinColumn(name = "GRUPO_ITEM")
    private ItemGrupoEntity grupoItem;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "UNIDADE_VENDA")
    private UnidadeMedidaEntity unidadeVenda;

    @ManyToOne
    @JoinColumn(name = "FABRICANTE")
    private FabricanteEntity fabricante;

    @Column(name = "CODIGO_BARRAS", unique = true)
    private String codigoBarras;

    @Column(name = "CODIGO_ORIGINAL", unique = true)
    private String codigoOriginal;

    @Column(name = "PRECO_CUSTO")
    private Double precoCusto;

    @Column(name = "PRECO_VENDA")
    private Double precoVenda;

    @Column(name = "MARGEM_LUCRO")
    private Double margemLucro;

    @Column(name = "ESTOQUE")
    private Double estoque;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status = Status.ATIVO;

    @Column(name = "EMPRESA")
    private Long empresa = 1L;

    @Column(name = "VERSAO")
    private LocalDateTime versao = LocalDateTime.now();


    public void setStatusAtivo() {
        this.status = Status.ATIVO;
        this.versao = LocalDateTime.now();
    }

    public void setStatusInativo() {
        this.status = Status.DESATIVADO;
        this.versao = LocalDateTime.now();
    }

    public Double calcularMargemLucro(){
        precoCusto = getPrecoCusto();
        precoVenda = getPrecoVenda();
        return ((precoVenda - precoCusto) / precoCusto) * 100;
    }

}
