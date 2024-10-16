package com.learning.api.angularsystem.services.financeiro;

import com.learning.api.angularsystem.entitys.financeiro.titulo.TituloEntity;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.repositories.financeiro.titulo.TituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TituloService {

    @Autowired
   private TituloRepository tituloRepository;

    @Transactional
    public TituloEntity criarTitulo(TituloEntity titulo){
        return tituloRepository.save(titulo);
    }

    @Transactional(readOnly = true)
    public List<TituloEntity> buscarTitulos(){
        return tituloRepository.findAll();
    }

    @Transactional(readOnly = true)
    public TituloEntity buscarTituloPorId(Long codigo){
        return tituloRepository.findById(codigo).orElseThrow(
                () -> new RuntimeException("Titulo não encontrado!")
        );
    }

    @Transactional
    public TituloEntity cancelarTitulo(Long codigo) {
        TituloEntity titulo = buscarTituloPorId(codigo);

        if(titulo.getStatus().equals(Status.CANCELADO)){
                 throw new RuntimeException("Titulo já cancelado!");
        }else {
            titulo.setStatusCancelado();
            System.out.println("Titulo cancelado com sucesso!");
        }
        return titulo;
    }
}
