package com.learning.api.angularsystem.services.faturamento.pedido;

import com.learning.api.angularsystem.services.cadastro.integrante.IntegranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private IntegranteService integranteService;

    public ResponseEntity<Void> criarPedido(){
//        PedidoEntity pedidoEntity = new PedidoEntity(pedidoDto);
//
//        if (pedidoDto.integrante() != null) {
//            integranteRepository.findById(pedidoDto.integrante().getCODIGO())
//                    .ifPresent(pedidoEntity::setIntegrante);
//        }
//
//        pedidoRepository.save(pedidoEntity);
//
//        return new ResponseEntity<>(HttpStatus.CREATED);
        return null;
    }

    public ResponseEntity<Void> atualizarPedido(){
//        PedidoEntity pedido = pedidoRepository.findById(pedidoDto.CODIGO())
//                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
//
//        pedido.atualizarPedido(pedidoDto);
//
//        if (pedidoDto.integrante() != null) {
//            IntegranteEntity integrante = integranteRepository.findById(pedidoDto.integrante().getCODIGO())
//                    .orElseThrow(() -> new RuntimeException("Integrante não encontrado"));
//
//            pedido.setIntegrante(integrante);
//        } else {
//            pedido.setIntegrante(null);
//        }
//
//        pedidoRepository.save(pedido);
//
//        return ResponseEntity.ok(new PedidoDto(pedido));
        return null;
    }
}
