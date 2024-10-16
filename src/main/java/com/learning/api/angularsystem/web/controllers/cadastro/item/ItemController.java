package com.learning.api.angularsystem.web.controllers.cadastro.item;

import com.learning.api.angularsystem.web.dtos.cadastro.item.ItemDto;
import com.learning.api.angularsystem.services.cadastro.item.ItemService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ItemService itemService;


    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarItem(@RequestBody @Valid ItemDto itemDto) {
        return null;
    }

    @GetMapping
    public Iterable<ItemDto> listarItens() {
        return null;
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<ItemDto> buscarItem(@PathVariable Long CODIGO) {
        return null;
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ItemDto> atualizarItem(@RequestBody @Valid ItemDto itemDto) {
      return null;
    }

    @PostMapping("/desativar/{CODIGO}")
    @Transactional
    public ResponseEntity<ItemDto> desativarItem(@PathVariable Long CODIGO) {
        return null;
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarItem(@PathVariable Long CODIGO) {
        return null;
    }
}
