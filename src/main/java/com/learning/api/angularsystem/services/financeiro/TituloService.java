package com.learning.api.angularsystem.services.financeiro;

import com.learning.api.angularsystem.entitys.financeiro.titulo.Titulo;
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
    public Titulo criarTitulo(Titulo titulo){
        return tituloRepository.save(titulo);
    }

    @Transactional(readOnly = true)
    public List<Titulo> buscarTitulos(){
        return tituloRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Titulo buscarTituloPorId(Long codigo){
        return tituloRepository.findById(codigo).orElseThrow(
                () -> new RuntimeException("Titulo não encontrado!")
        );
    }

    @Transactional
    public Titulo cancelarTitulo(Long codigo) {
        Titulo titulo = buscarTituloPorId(codigo);

        if(titulo.getStatus().equals(Status.CANCELADO)){
                 throw new RuntimeException("Titulo já cancelado!");
        }else {
            titulo.setStatusCancelado();
            System.out.println("Titulo cancelado com sucesso!");
        }
        return titulo;
    }
}
