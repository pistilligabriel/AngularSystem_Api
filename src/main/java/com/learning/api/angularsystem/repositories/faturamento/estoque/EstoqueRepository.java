package com.learning.api.angularsystem.repositories.faturamento.estoque;

import com.learning.api.angularsystem.entitys.faturamento.estoque.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
