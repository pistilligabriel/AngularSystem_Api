package com.learning.api.angularsystem.web.controllers.empresa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.learning.api.angularsystem.entitys.empresa.Empresa;
import com.learning.api.angularsystem.services.empresa.EmpresaService;


@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;


    @GetMapping("/{id}")
    public ResponseEntity<Empresa> obterConfiguracao(@PathVariable Long id) {
        Empresa configuracao = empresaService.obterConfiguracao();
        if (configuracao != null) {
            return ResponseEntity.ok(configuracao);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/logo")
    public ResponseEntity<byte[]> getLogo(@PathVariable Long id) {
        byte[] image = empresaService.getLogoById(id); // retorna o array de bytes da imagem
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG); // ou IMAGE_JPEG conforme o tipo
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Empresa> editarConfiguracao(   @RequestParam("file") MultipartFile file,
                                                         @RequestParam("nomeEmpresa") String nomeEmpresa) {
        Empresa empresa = empresaService.editarConfiguracao(nomeEmpresa, file);
        return ResponseEntity.ok(empresa);
    }
}