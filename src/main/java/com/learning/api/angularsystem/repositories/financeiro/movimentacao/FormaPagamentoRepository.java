package com.learning.api.angularsystem.repositories.financeiro.movimentacao;

import com.learning.api.angularsystem.entitys.financeiro.movimentacao.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
}
