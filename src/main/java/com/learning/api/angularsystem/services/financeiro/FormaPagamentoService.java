package com.learning.api.angularsystem.services.financeiro;

import com.learning.api.angularsystem.entitys.financeiro.movimentacao.FormaPagamento;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.repositories.financeiro.movimentacao.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FormaPagamentoService {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Transactional
    public FormaPagamento criarFormaPagamento(FormaPagamento formaPagamento){
        return formaPagamentoRepository.save(formaPagamento);
    }

    @Transactional(readOnly = true)
    public List<FormaPagamento> buscarFormasPagamento(){
        return formaPagamentoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public FormaPagamento buscarFormaPagamentoPorId(Long codigo){
        return formaPagamentoRepository.findById(codigo).orElseThrow(
                () -> new RuntimeException("Forma Pagamento não encontrada!")
        );
    }

    @Transactional
    public FormaPagamento alterarStatus(Long codigo){
        FormaPagamento formaPagamento = buscarFormaPagamentoPorId(codigo);

        if (formaPagamento.getStatus().equals(Status.ATIVO)) {
            formaPagamento.setStatusInativo();
        } else {
            formaPagamento.setStatusAtivo();
        }
        return formaPagamento;
    }

    @Transactional
    public FormaPagamento deletarFormaPagamento(Long codigo){
        FormaPagamento formaPagamento = buscarFormaPagamentoPorId(codigo);

        if(!formaPagamento.getStatus().equals(Status.DESATIVADO)){
            throw new RuntimeException("Forma de pagamento não pode ser removida devido não estar desativado!");
        }else{
            formaPagamentoRepository.deleteById(codigo);
            System.out.println("Registro deletado com sucesso!");
        }
        return formaPagamento;
    }
}
