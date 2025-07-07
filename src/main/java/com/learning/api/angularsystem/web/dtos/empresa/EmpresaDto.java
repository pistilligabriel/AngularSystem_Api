package com.learning.api.angularsystem.web.dtos.empresa;

import java.io.File;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDto {
    private String nomeEmpresa;
    private File logo;
}

