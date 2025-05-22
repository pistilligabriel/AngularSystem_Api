package com.learning.api.angularsystem.services.cadastro.item;

import com.learning.api.angularsystem.entitys.cadastro.item.Item;
import com.learning.api.angularsystem.enums.Status;
import com.learning.api.angularsystem.repositories.cadastro.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Transactional()
    public Item criarItem(Item item){
        return itemRepository.save(item);
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
    }
    @Transactional(readOnly = true)
    public List<Item> listarProdutos(){
        return itemRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Item buscarProduto(Long codigo){
        return itemRepository.findById(codigo).orElseThrow(
                () -> new RuntimeException("Produto não encontrado!")
        );
    }

    @Transactional()
    public Item alterarStatus(Long codigo){
        Item item = buscarProduto(codigo);
        if(item.getStatus().equals(Status.ATIVO) && item.getEstoque() == 0){
            item.setStatusInativo();
        } else if(item.getStatus().equals(Status.ATIVO) && item.getEstoque() > 0){
            throw new RuntimeException("Não é possível desativar produto com estoque!");
        } else {
            item.setStatusAtivo();
        }
        return item;
    }

    @Transactional()
    public Item deletarProduto(Long codigo){
        Item item = buscarProduto(codigo);
        if(item.getStatus().equals(Status.DESATIVADO)){
            itemRepository.deleteById(item.getCodigo());
        } else{
            throw new RuntimeException("Produto não pode ser deletado!");
        }
        return item;
    }

    @Transactional()
    public Item editarItem(){
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
