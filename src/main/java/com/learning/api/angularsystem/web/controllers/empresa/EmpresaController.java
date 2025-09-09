package com.learning.api.angularsystem.web.controllers.empresa;


import com.learning.api.angularsystem.entitys.empresa.Empresa;
import com.learning.api.angularsystem.services.empresa.EmpresaService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }


    @GetMapping("/{id}")
    public Map<String,String> getEmpresa(@PathVariable Long id) {
        String configuracao = empresaService.obterNomeEmpresa(id);
        return Map.of("nomeEmpresa",configuracao);
    }

    @GetMapping("/{id}/logo")
    public ResponseEntity<byte[]> getLogo(@PathVariable Long id) {
        byte[] image = empresaService.getLogoById(id); // retorna o array de bytes da imagem
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Empresa> editarConfiguracao(   @RequestParam(value="file",required = false) MultipartFile file,
                                                         @RequestParam("nomeEmpresa") String nomeEmpresa) {
        Empresa empresa = empresaService.editarConfiguracao(nomeEmpresa, file);
        return ResponseEntity.ok(empresa);
    }
}