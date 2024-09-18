package com.learning.api.angularsystem.services.faturamento.pedido;

import com.learning.api.angularsystem.repositories.cadastro.item.ItemRepository;
import com.learning.api.angularsystem.repositories.cadastro.item.UnidadeMedidaRepository;
import com.learning.api.angularsystem.repositories.faturamento.pedido.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PedidoDetalheService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UnidadeMedidaRepository unidadeMedidaRepository;

    public ResponseEntity<Void> criarDetalhe(){
//        PedidoDetalheEntity pedidoDetalheEntity = new PedidoDetalheEntity(pedidoDetalheDto);
//
//        if (pedidoDetalheDto.pedido() != null) {
//            pedidoRepository.findById(pedidoDetalheDto.pedido().getCODIGO())
//                    .ifPresent(pedidoDetalheEntity::setPedido);
//        }
//
//        if (pedidoDetalheDto.item() != null) {
//            itemRepository.findById(pedidoDetalheDto.item().getCODIGO())
//                    .ifPresent(pedidoDetalheEntity::setItem);
//        }
//
//        if (pedidoDetalheDto.unidadeMedida() != null) {
//            unidadeMedidaRepository.findById(pedidoDetalheDto.unidadeMedida().getCODIGO())
//                    .ifPresent(pedidoDetalheEntity::setUnidadeMedida);
//        }
//
//        pedidoDetalheRepository.save(pedidoDetalheEntity);
//
//        return new ResponseEntity<>(HttpStatus.CREATED);
        return null;
    }

    public ResponseEntity<Void> atualizarDetalhe(){
//        PedidoDetalheEntity pedidoDetalhe = pedidoDetalheRepository.findById(pedidoDetalheDto.CODIGO())
//                .orElseThrow(() -> new RuntimeException("Pedido Detalhe não encontrado"));
//
//        pedidoDetalhe.atualizarPedidoDetalhe(pedidoDetalheDto);
//
//        if (pedidoDetalheDto.pedido() != null) {
//            pedidoRepository.findById(pedidoDetalheDto.pedido().getCODIGO())
//                    .ifPresent(pedidoDetalhe::setPedido);
//        } else {
//            pedidoDetalhe.setPedido(null);
//        }
//
//        if (pedidoDetalheDto.item() != null) {
//            itemRepository.findById(pedidoDetalheDto.item().getCODIGO())
//                    .ifPresent(pedidoDetalhe::setItem);
//        } else {
//            pedidoDetalhe.setItem(null);
//        }
//
//        if (pedidoDetalheDto.unidadeMedida() != null) {
//            unidadeMedidaRepository.findById(pedidoDetalheDto.unidadeMedida().getCODIGO())
//                    .ifPresent(pedidoDetalhe::setUnidadeMedida);
//        } else {
//            pedidoDetalhe.setUnidadeMedida(null);
//        }
//
//        pedidoDetalheRepository.save(pedidoDetalhe);
//
//        return ResponseEntity.ok(new PedidoDetalheDto(pedidoDetalhe));
        return null;
    }
}
