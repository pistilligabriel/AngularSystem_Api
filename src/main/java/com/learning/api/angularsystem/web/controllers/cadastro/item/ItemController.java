package com.learning.api.angularsystem.web.controllers.cadastro.item;

import com.learning.api.angularsystem.entitys.cadastro.item.ItemEntity;
import com.learning.api.angularsystem.services.cadastro.item.ItemService;
import com.learning.api.angularsystem.web.dtos.cadastro.item.ItemDto;
import com.learning.api.angularsystem.web.dtos.cadastro.item.ItemResponseDto;
import com.learning.api.angularsystem.web.dtos.cadastro.item.mapper.ItemMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
public class ItemController {

    @Autowired
    private ItemService itemService;


    @PostMapping
    @Transactional
    public ResponseEntity<ItemResponseDto> cadastrarProduto(@RequestBody @Valid ItemDto itemDto) {
        ItemEntity item = itemService.criarItem(ItemMapper.toItem(itemDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(ItemMapper.toDto(item));
    }

    @GetMapping
    public List<ItemResponseDto> listarProdutos() {
        List<ItemEntity> itens = itemService.listarProdutos();
        return ResponseEntity.status(HttpStatus.OK).body(ItemMapper.toListDto(itens)).getBody();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ItemResponseDto> buscarProduto(@PathVariable Long codigo) {
        ItemEntity item = itemService.buscarProduto(codigo);
        return ResponseEntity.status(HttpStatus.OK).body(ItemMapper.toDto(item));
    }

    @PutMapping
    public ResponseEntity<ItemDto> atualizarProduto(@RequestBody @Valid ItemDto itemDto) {
      return null;
    }

    @PostMapping("/status/{codigo}")
    public ResponseEntity<ItemResponseDto> alterarStatusProduto(@PathVariable Long codigo) {
        ItemEntity item = itemService.alterarStatus(codigo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<ItemResponseDto> deletarProduto(@PathVariable Long codigo) {
        ItemEntity item = itemService.deletarProduto(codigo);
        return ResponseEntity.noContent().build();
    }
}
