package com.learning.api.angularsystem.services.cadastro.integrante;

import com.learning.api.angularsystem.entitys.cadastro.integrante.Cliente;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.repositories.cadastro.integrante.IntegranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IntegranteService {
    @Autowired
    private IntegranteRepository integranteRepository;

    @Transactional
    public Cliente criarIntegrante(Cliente integrante){
        return integranteRepository.save(integrante);
    }

    @Transactional(readOnly = true)
    public Cliente getIntegranteById(Long codigo){
        return integranteRepository.findById(codigo).orElseThrow(
                () -> new RuntimeException("Integrante não encontrado!")
        );
    }

    @Transactional(readOnly = true)
    public List<Cliente> getTodosIntegrantes(){
        return integranteRepository.findAll();
    }


    @Transactional
    public Cliente alterarStatus(Long codigo ){
        Cliente integrante = getIntegranteById(codigo);

        if(integrante.getStatus().equals(Status.ATIVO)){
            integrante.setStatusInativo();
        }else{
            integrante.setStatusAtivo();
        }
        return integrante;
    }

    @Transactional
    public Cliente deletarIntegrante(Long codigo){
        Cliente integrante = getIntegranteById(codigo);
        integranteRepository.deleteById(integrante.getCODIGO());
        return integrante;
    }



    /*
    public IntegranteEntity atualizarIntegrante(IntegranteEntity integrante){
        // Busca a entidade existente no banco de dados
        getIntegranteById(integrante.getCODIGO());

        // Atualiza os dados da entidade existente com base nos dados recebidos no DTO
        this.atualizarIntegrante(integrante);

        // Salva as alterações no banco de dados
        integranteRepository.save(integrante);
    } */
}
