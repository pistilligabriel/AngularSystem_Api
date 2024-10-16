package com.learning.api.angularsystem.web.dtos.cadastro.usuario;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthenticationDto {

    private String login;
    private String password;

}
