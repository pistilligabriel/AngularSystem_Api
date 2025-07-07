package com.learning.api.angularsystem.repositories.empresa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.api.angularsystem.entitys.empresa.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa,Long> {

}
