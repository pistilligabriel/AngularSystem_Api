package com.learning.api.angularsystem.services.cadastro.item;

import com.learning.api.angularsystem.entitys.cadastro.item.Fabricante;
import com.learning.api.angularsystem.entitys.cadastro.item.UnidadeMedida;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.repositories.cadastro.item.UnidadeMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UnidadeMedidaService {
    
    @Autowired
    private UnidadeMedidaRepository repository;

    @Transactional
    public UnidadeMedida createUnidadeMedida(UnidadeMedida unidadeMedida){
        unidadeMedida.setVersao(LocalDateTime.now());
        return repository.save(unidadeMedida);
    }

    @Transactional(readOnly = true)
    public List<UnidadeMedida> getAllUnidadeMedidas(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public UnidadeMedida getById(Long codigo){
        return repository.findById(codigo).orElseThrow(
                () -> new RuntimeException("Unidade Medida não encontrada")
        );
    }

    @Transactional()
    public UnidadeMedida alterarStatus(Long codigo){
        UnidadeMedida unidadeMedida = getById(codigo);
        if(unidadeMedida.getStatus().equals(Status.ATIVO)){
            unidadeMedida.setStatusInativo();
        } else {
            unidadeMedida.setStatusAtivo();
        }
        return unidadeMedida;
    }

    @Transactional()
    public UnidadeMedida deletarUnidadeMedida(Long codigo){
        UnidadeMedida unidadeMedida = getById(codigo);
        if(unidadeMedida.getStatus().equals(Status.DESATIVADO)){
            repository.deleteById(unidadeMedida.getCodigo());
        } else{
            throw new RuntimeException("Unidade Medida não pode ser deletado!");
        }
        return unidadeMedida;
    }

    public UnidadeMedida editarUnidade(UnidadeMedida unidade){
        UnidadeMedida unidadeAtual = getById(unidade.getCodigo());
        if(!unidadeAtual.getStatus().equals(Status.ATIVO)){
            throw new RuntimeException("Unidade não pode ser alterada, pois está desativada!");
        }
        unidadeAtual.setDescricao(unidade.getDescricao());
        unidadeAtual.setSimbolo(unidade.getSimbolo());
        unidadeAtual.setVersao(LocalDateTime.now());
        return repository.save(unidadeAtual);
    }
}
