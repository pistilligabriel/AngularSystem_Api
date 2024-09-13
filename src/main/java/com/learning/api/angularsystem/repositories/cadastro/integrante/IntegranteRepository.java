package com.learning.api.angularsystem.repositories.cadastro.integrante;

import com.learning.api.angularsystem.entitys.cadastro.integrante.IntegranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegranteRepository extends JpaRepository<IntegranteEntity, Long> {

}
