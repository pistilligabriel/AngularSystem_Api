package com.learning.api.angularsystem.entitys.cadastro.item;

import com.learning.api.angularsystem.web.dtos.cadastro.item.UnidadeMedidaDto;
import com.learning.api.angularsystem.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "unidade_medida")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnidadeMedidaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

    @Column(name = "DESCRICAO", unique = true)
    private String descricao;

    @Column(name = "SIMBOLO", unique = true)
    private String simbolo;

    @OneToMany(mappedBy = "unidadeVenda",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ItemEntity> produtos;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "EMPRESA")
    private Long empresa;

    @Column(name = "VERSAO")
    private LocalDateTime versao;

    public void setStatusAtivo() {
        this.status = Status.ATIVO;
        this.versao = LocalDateTime.now();
    }

    public void setStatusInativo() {
        this.status = Status.DESATIVADO;
        this.versao = LocalDateTime.now();
    }
}
