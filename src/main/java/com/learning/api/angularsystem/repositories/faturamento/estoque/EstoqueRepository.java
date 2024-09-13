package com.learning.api.angularsystem.repositories.faturamento.estoque;

import com.learning.api.angularsystem.entitys.faturamento.estoque.EstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<EstoqueEntity, Long> {
}
