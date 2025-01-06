package com.learning.api.angularsystem.repositories.cadastro.integrante;

import com.learning.api.angularsystem.entitys.cadastro.integrante.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IntegranteRepository extends JpaRepository<Cliente, Long> {

}
