package com.learning.api.angularsystem.web.controllers.cadastro.item;

import com.learning.api.angularsystem.web.dtos.cadastro.item.ItemGrupoDto;
import com.learning.api.angularsystem.services.cadastro.item.ItemGrupoService;
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
@RequestMapping("/api/v1/item-grupos")
public class ItemGrupoController {

    @Autowired
    private ItemGrupoService itemGrupoService;

    @PostMapping
    @Transactional
    public void cadastrarItemGrupo(@RequestBody @Valid ItemGrupoDto itemGrupoDto) {

    }

    @GetMapping
    public Iterable<ItemGrupoDto> listarItemGrupos() {
        return null;
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<ItemGrupoDto> buscarItemGrupo(@PathVariable Long CODIGO) {
        return null;
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ItemGrupoDto> atualizarItemGrupo(@RequestBody @Valid ItemGrupoDto itemGrupoDto) {
        return null;
    }

    @PostMapping("/desativar/{CODIGO}")
    @Transactional
    public ResponseEntity<ItemGrupoDto> desativarItemGrupo(@PathVariable Long CODIGO) {
        return null;
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarItemGrupo(@PathVariable Long CODIGO) {
        return null;
    }
}
