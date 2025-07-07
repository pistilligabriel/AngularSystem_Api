package com.learning.api.angularsystem.services.cadastro.integrante;

import com.learning.api.angularsystem.entitys.cadastro.integrante.Cliente;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.repositories.cadastro.integrante.IntegranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
        integranteRepository.deleteById(integrante.getCodigo());
        return integrante;
    }

    @Transactional
    public Cliente atualizarIntegrante(Cliente cliente){
        // Busca a entidade existente no banco de dados
        Cliente clienteAtualizar = getIntegranteById(cliente.getCodigo());

        if(!clienteAtualizar.getStatus().equals(Status.ATIVO)){
            throw new RuntimeException("Cliente não pode ser alterado, pois está desativado!");
        }
        // Atualiza os dados da entidade existente com base nos dados recebidos no DTO
        clienteAtualizar.setNomeCompleto(cliente.getNomeCompleto());
        clienteAtualizar.setTelefone(cliente.getTelefone());
        clienteAtualizar.setEmail(cliente.getEmail());
        clienteAtualizar.setTipoDocumento(cliente.getTipoDocumento());
        clienteAtualizar.setDocumento(cliente.getDocumento());
        clienteAtualizar.setCep(cliente.getCep());
        clienteAtualizar.setLogradouro(cliente.getLogradouro());
        clienteAtualizar.setNumero(cliente.getNumero());
        clienteAtualizar.setBairro(cliente.getBairro());
        clienteAtualizar.setMunicipio(cliente.getMunicipio());
        clienteAtualizar.setUf(cliente.getUf());
        clienteAtualizar.setComplemento(cliente.getComplemento());
        clienteAtualizar.setVersao(LocalDateTime.now()); //Salva data e hora do momento que edita o registro
        // Salva as alterações no banco de dados
        return integranteRepository.save(clienteAtualizar);
    }
}
