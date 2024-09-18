package com.learning.api.angularsystem.services.cadastro.item;

import com.learning.api.angularsystem.dtos.cadastro.item.ItemDto;
import com.learning.api.angularsystem.entitys.cadastro.item.ItemEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    public ItemEntity criarItem(ItemEntity item){
//        ItemEntity itemEntity = new ItemEntity(itemDto);
//
//        if (itemDto.grupoItem() != null) {
//            itemGrupoRepository.findById(itemDto.grupoItem().getCODIGO())
//                    .ifPresent(itemEntity::setGrupoItem);
//        }
//        // if (itemDto.fabricante() != null) {
//        //     fabricanteRepository.findById(itemDto.fabricante().getCODIGO())
//        //             .ifPresent(itemEntity::setFabricante);
//        // }
//        if (itemDto.unidadeVenda() != null) {
//            unidadeMedidaRepository.findById(itemDto.unidadeVenda().getCODIGO())
//                    .ifPresent(itemEntity::setUnidadeVenda);
//        }
//
//        itemEntity.calcularMargemLucro();
//
//        itemRepository.save(itemEntity);
//
//
//        return new ResponseEntity<>(HttpStatus.CREATED);
        return null;
    }

    public ItemEntity editarItem(){
//        ItemEntity item = itemRepository.findById(itemDto.CODIGO())
//                .orElseThrow(() -> new RuntimeException("Item não encontrado"));
//
//        item.atualizarItem(itemDto);
//
//        if (itemDto.grupoItem() != null) {
//            itemGrupoRepository.findById(itemDto.grupoItem().getCODIGO())
//                    .ifPresent(item::setGrupoItem);
//        } else {
//            item.setGrupoItem(null);
//        }
//        // if (itemDto.fabricante() != null) {
//        //     fabricanteRepository.findById(itemDto.fabricante().getCODIGO())
//        //             .ifPresent(item::setFabricante);
//        // } else {
//        //     item.setFabricante(null);
//        // }
//        if (itemDto.unidadeVenda() != null) {
//            unidadeMedidaRepository.findById(itemDto.unidadeVenda().getCODIGO())
//                    .ifPresent(item::setUnidadeVenda);
//        } else {
//            item.setUnidadeVenda(null);
//        }
//
//
//        itemRepository.save(item);
//
//        item.calcularMargemLucro();
//
//        return ResponseEntity.ok(new ItemDto(item));
        return null;
    }
}
