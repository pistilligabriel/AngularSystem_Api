package com.learning.api.minisys.controllers.cadastro.item;

import com.learning.api.minisys.dtos.cadastro.item.ItemDto;
import com.learning.api.minisys.entitys.cadastro.item.ItemEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.repositories.cadastro.item.FabricanteRepository;
import com.learning.api.minisys.repositories.cadastro.item.ItemGrupoRepository;
import com.learning.api.minisys.repositories.cadastro.item.ItemRepository;
import com.learning.api.minisys.repositories.cadastro.item.UnidadeMedidaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/produtos")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemGrupoRepository itemGrupoRepository;
    @Autowired
    private FabricanteRepository fabricanteRepository;
    @Autowired
    private UnidadeMedidaRepository unidadeMedidaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarItem(@RequestBody @Valid ItemDto itemDto) {
        ItemEntity itemEntity = new ItemEntity(itemDto);

        if (itemDto.grupoItem() != null) {
            itemGrupoRepository.findById(itemDto.grupoItem().getCODIGO())
                    .ifPresent(itemEntity::setGrupoItem);
        }
        // if (itemDto.fabricante() != null) {
        //     fabricanteRepository.findById(itemDto.fabricante().getCODIGO())
        //             .ifPresent(itemEntity::setFabricante);
        // }
        if (itemDto.unidadeVenda() != null) {
            unidadeMedidaRepository.findById(itemDto.unidadeVenda().getCODIGO())
                    .ifPresent(itemEntity::setUnidadeVenda);
        }

        itemEntity.calcularMargemLucro();

        itemRepository.save(itemEntity);


        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<ItemDto> listarItens() {
        return itemRepository.findAll().stream().map(ItemDto::new).toList();
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<ItemDto> buscarItem(@PathVariable Long CODIGO) {
        var item = itemRepository.getReferenceById(CODIGO);

        return ResponseEntity.ok(new ItemDto(item));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ItemDto> atualizarItem(@RequestBody @Valid ItemDto itemDto) {
        ItemEntity item = itemRepository.findById(itemDto.CODIGO())
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        item.atualizarItem(itemDto);

        if (itemDto.grupoItem() != null) {
            itemGrupoRepository.findById(itemDto.grupoItem().getCODIGO())
                    .ifPresent(item::setGrupoItem);
        } else {
            item.setGrupoItem(null);
        }
        // if (itemDto.fabricante() != null) {
        //     fabricanteRepository.findById(itemDto.fabricante().getCODIGO())
        //             .ifPresent(item::setFabricante);
        // } else {
        //     item.setFabricante(null);
        // }
        if (itemDto.unidadeVenda() != null) {
            unidadeMedidaRepository.findById(itemDto.unidadeVenda().getCODIGO())
                    .ifPresent(item::setUnidadeVenda);
        } else {
            item.setUnidadeVenda(null);
        }

        
        itemRepository.save(item);
        
        item.calcularMargemLucro();
        
        return ResponseEntity.ok(new ItemDto(item));
    }

    @PostMapping("/desativar/{CODIGO}")
    @Transactional
    public ResponseEntity<ItemDto> desativarItem(@PathVariable Long CODIGO) {
        var item = itemRepository.getReferenceById(CODIGO);

        if (item.getStatus().equals(Status.ATIVO)) {
            item.setStatusInativo();
        } else {
            item.setStatusAtivo();
        }

        return ResponseEntity.ok(new ItemDto(item));
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarItem(@PathVariable Long CODIGO) {
        itemRepository.deleteById(CODIGO);

        return ResponseEntity.noContent().build();
    }
}
