package com.learning.api.angularsystem.services.cadastro.item;

import com.learning.api.angularsystem.entitys.cadastro.item.Fabricante;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.repositories.cadastro.item.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository repository;

    @Transactional
    public Fabricante createFabricante(Fabricante fabricante){
        return repository.save(fabricante);
    }

    @Transactional(readOnly = true)
    public List<Fabricante> getAllFabricantes(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Fabricante getById(Long codigo){
        return repository.findById(codigo).orElseThrow(
                () -> new RuntimeException("Fabricante não encontrado")
        );
    }

    @Transactional()
    public Fabricante alterarStatus(Long codigo){
        Fabricante fabricante = getById(codigo);
        if(fabricante.getStatus().equals(Status.ATIVO)){
            fabricante.setStatusInativo();
        } else {
            fabricante.setStatusAtivo();
        }
        return fabricante;
    }

    @Transactional()
    public Fabricante deletarFabricante(Long codigo){
        Fabricante fabricante = getById(codigo);
        if(fabricante.getStatus().equals(Status.DESATIVADO)){
            repository.deleteById(fabricante.getCodigo());
        } else{
            throw new RuntimeException("Fabricante não pode ser deletado, pois não está desativado!");
        }
        return fabricante;
    }

    @Transactional
    public Fabricante editarFabricante(Fabricante fabricante){
        Fabricante fabricanteAtual = getById(fabricante.getCodigo());
        if(!fabricanteAtual.getStatus().equals(Status.ATIVO)){
            throw new RuntimeException("Fabricante não pode ser alterado, pois está desativado!");
        }
        fabricanteAtual.setDescricao(fabricante.getDescricao());
        fabricanteAtual.setVersao(LocalDateTime.now());
        return repository.save(fabricanteAtual);
    }
}
