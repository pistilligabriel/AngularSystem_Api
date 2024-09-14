package com.learning.api.angularsystem.entitys.cadastro.integrante;

import com.learning.api.angularsystem.dtos.cadastro.integrante.IntegranteDto;
import com.learning.api.angularsystem.dtos.cadastro.integrante.NewIntegranteDto;
import com.learning.api.angularsystem.dtos.cadastro.integrante.table.IntegranteTableDto;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.enums.integrante.TipoIntegrante;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "integrante")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntegranteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoIntegrante tipoIntegrante = TipoIntegrante.CLIENTE;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SEGUNDO_NOME")
    private String sobrenome;

    @Column(name = "TELEFONE")
    private String telefone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;

    @Column(name = "DOCUMENTO", unique = true)
    private String documento;

    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "NUMERO")
    private Integer numero;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "MUNICIPIO")
    private String municipio;

    @Column(name = "UF")
    private String uf;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "EMPRESA")
    private Long empresa = 1L;

    @Column(name = "VERSAO")
    private LocalDateTime versao;


    public IntegranteEntity(IntegranteDto dadosIntegrante) {
        this.tipoIntegrante = dadosIntegrante.tipoIntegrante();
        this.nome = dadosIntegrante.nome();
        this.sobrenome = dadosIntegrante.sobrenome();
        this.telefone = dadosIntegrante.telefone();
        this.email = dadosIntegrante.email();
        this.tipoDocumento = dadosIntegrante.tipoDocumento();
        this.documento = dadosIntegrante.documento();
        this.dataCriacao = LocalDateTime.now();
        this.status = Status.ATIVO;
        this.cep = dadosIntegrante.cep();
        this.logradouro = dadosIntegrante.logradouro();
        this.numero = dadosIntegrante.numero();
        this.bairro = dadosIntegrante.bairro();
        this.municipio = dadosIntegrante.municipio();
        this.uf = dadosIntegrante.uf();
        this.complemento = dadosIntegrante.complemento();
        this.empresa = dadosIntegrante.empresa();
        this.versao = LocalDateTime.now();
    }

    public IntegranteEntity(NewIntegranteDto integrante) {
    }


    public void atualizarIntegrante(IntegranteDto dadosIntegrante) {

        if (dadosIntegrante.nome() != null) {
            this.nome = dadosIntegrante.nome();
        }
        if (dadosIntegrante.sobrenome() != null) {
            this.sobrenome = dadosIntegrante.sobrenome();
        }
        if (dadosIntegrante.telefone() != null) {
            this.telefone = dadosIntegrante.telefone();
        }
        if (dadosIntegrante.email() != null) {
            this.email = dadosIntegrante.email();
        }
        if (dadosIntegrante.tipoDocumento() != null) {
            this.tipoDocumento = dadosIntegrante.tipoDocumento();
        }
        if (dadosIntegrante.documento() != null) {
            this.documento = dadosIntegrante.documento();
        }
        if (dadosIntegrante.status() != null) {
            this.status = dadosIntegrante.status();
        }
        this.versao = LocalDateTime.now();
    }

    public void setStatusAtivo() {
        this.status = Status.ATIVO;
        this.versao = LocalDateTime.now();
    }

    public void setStatusInativo() {
        this.status = Status.DESATIVADO;
        this.versao = LocalDateTime.now();
    }
}
