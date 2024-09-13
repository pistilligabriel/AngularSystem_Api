package com.learning.api.angularsystem.repositories.faturamento.ordem_servico;

import com.learning.api.angularsystem.entitys.faturamento.ordem_servico.OrdemServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemServicoRepository extends JpaRepository<OrdemServicoEntity, Long> {
}
