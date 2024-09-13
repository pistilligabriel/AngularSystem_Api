package com.learning.api.angularsystem.repositories.financeiro.titulo;

import com.learning.api.angularsystem.entitys.financeiro.titulo.TituloEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TituloRepository extends JpaRepository<TituloEntity, Long> {
}
