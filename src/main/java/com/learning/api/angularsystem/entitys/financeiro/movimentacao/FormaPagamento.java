package com.learning.api.angularsystem.entitys.financeiro.movimentacao;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.enums.movimentacao.TipoFormaPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "forma_pagamento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormaPagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status = Status.ATIVO;

    @Column(name = "EMPRESA")
    private Long empresa = 1L;

    @Column(name = "VERSAO")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime versao = LocalDateTime.now();

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoFormaPagamento tipo;

    @Column(name = "DESCRICAO")
    private String descricao;

    public void setStatusAtivo() {
        this.status = Status.ATIVO;
    }

    public void setStatusInativo() {
        this.status = Status.DESATIVADO;
    }
}
