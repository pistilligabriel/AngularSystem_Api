package com.learning.api.angularsystem.repositories.financeiro.movimentacao;

import com.learning.api.angularsystem.entitys.financeiro.movimentacao.FormaPagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamentoEntity, Long> {
}
