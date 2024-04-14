package br.com.example.atividadesemana12.security.request;

import lombok.Data;

@Data
public class LoginRequest {

    private String usuario;
    private String senha;
}
