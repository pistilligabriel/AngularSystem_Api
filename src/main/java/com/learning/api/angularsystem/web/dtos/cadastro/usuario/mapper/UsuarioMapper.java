package com.learning.api.angularsystem.web.dtos.cadastro.usuario.mapper;

import com.learning.api.angularsystem.entitys.cadastro.usuario.Usuario;
import com.learning.api.angularsystem.web.dtos.cadastro.usuario.UsuarioDto;
import com.learning.api.angularsystem.web.dtos.cadastro.usuario.UsuarioResponseDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {
    public static Usuario toUsuario(UsuarioDto usuarioDto){
        return new ModelMapper().map(usuarioDto, Usuario.class);
    }

    public static UsuarioResponseDto toDto(Usuario usuario){
        return new ModelMapper().map(usuario,UsuarioResponseDto.class);
    }

    public static List<UsuarioResponseDto> toListDto(List<Usuario> usuarios){
        return usuarios.stream().map(usuario -> toDto(usuario)).collect(Collectors.toList());
    }
}
