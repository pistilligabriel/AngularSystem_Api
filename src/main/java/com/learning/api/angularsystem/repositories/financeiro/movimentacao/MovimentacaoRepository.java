package com.learning.api.angularsystem.repositories.financeiro.movimentacao;

import com.learning.api.angularsystem.entitys.financeiro.movimentacao.MovimentacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<MovimentacaoEntity, Long> {
}
