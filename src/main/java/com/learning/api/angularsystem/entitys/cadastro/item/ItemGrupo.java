package com.learning.api.angularsystem.entitys.cadastro.item;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.learning.api.angularsystem.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "item_grupo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemGrupo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "DESCRICAO", unique = true)
    private String descricao;

    @OneToMany(mappedBy = "grupoItem",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> produtos;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status = Status.ATIVO;

    @Column(name = "EMPRESA")
    private Long empresa = 1L;

    @Column(name = "VERSAO")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime versao = LocalDateTime.now();


    public void setStatusAtivo() {
        this.status = Status.ATIVO;
        this.versao = LocalDateTime.now();
    }

    public void setStatusInativo() {
        this.status = Status.DESATIVADO;
        this.versao = LocalDateTime.now();
    }
}
