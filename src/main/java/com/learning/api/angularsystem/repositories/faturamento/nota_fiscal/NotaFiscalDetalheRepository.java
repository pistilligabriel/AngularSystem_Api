package com.learning.api.angularsystem.repositories.faturamento.nota_fiscal;

import com.learning.api.angularsystem.entitys.faturamento.nota_fiscal.NotaFiscalDetalheEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaFiscalDetalheRepository extends JpaRepository<NotaFiscalDetalheEntity, Long> {
}
