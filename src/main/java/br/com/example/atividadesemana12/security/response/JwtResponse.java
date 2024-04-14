package br.com.example.atividadesemana12.security.response;

import lombok.Data;

@Data
public class JwtResponse {

    private final String token;

    public JwtResponse(String token) {
        this.token = token;
    }

}

