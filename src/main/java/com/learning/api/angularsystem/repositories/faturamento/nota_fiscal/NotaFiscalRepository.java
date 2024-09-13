package com.learning.api.angularsystem.repositories.faturamento.nota_fiscal;

import com.learning.api.angularsystem.entitys.faturamento.nota_fiscal.NotaFiscalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscalEntity, Long> {
}
