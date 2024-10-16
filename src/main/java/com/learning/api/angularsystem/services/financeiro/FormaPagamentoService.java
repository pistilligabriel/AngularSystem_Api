package com.learning.api.angularsystem.services.financeiro;

import com.learning.api.angularsystem.entitys.financeiro.movimentacao.FormaPagamentoEntity;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.repositories.financeiro.movimentacao.FormaPagamentoRepository;
import com.learning.api.angularsystem.web.dtos.financeiro.movimentacao.FormaPagamentoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormaPagamentoService {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    public FormaPagamentoEntity criarFormaPagamento(FormaPagamentoEntity formaPagamento){
        return formaPagamentoRepository.save(formaPagamento);
    }

    public List<FormaPagamentoEntity> buscarFormasPagamento(){
        return formaPagamentoRepository.findAll();
    }

    public FormaPagamentoEntity buscarFormaPagamentoPorId(Long codigo){
        return formaPagamentoRepository.findById(codigo).orElseThrow(
                () -> new RuntimeException("Forma Pagamento não encontrada!")
        );
    }

    public FormaPagamentoEntity alterarStatus(Long codigo){
        FormaPagamentoEntity formaPagamento = buscarFormaPagamentoPorId(codigo);

        if (formaPagamento.getStatus().equals(Status.ATIVO)) {
            formaPagamento.setStatusInativo();
        } else {
            formaPagamento.setStatusAtivo();
        }
        return formaPagamento;
    }

    public FormaPagamentoEntity deletarFormaPagamento(Long codigo){
        FormaPagamentoEntity formaPagamento = buscarFormaPagamentoPorId(codigo);

        if(!formaPagamento.getStatus().equals(Status.DESATIVADO)){
            throw new RuntimeException("Forma de pagamento não pode ser removida devido não estar desativado!");
        }else{
            formaPagamentoRepository.deleteById(codigo);
            System.out.println("Registro deletado com sucesso!");
        }
        return formaPagamento;
    }
}
