package br.com.example.atividadesemana12.controller;

import br.com.example.atividadesemana12.entity.UsuarioEntity;
import br.com.example.atividadesemana12.filtro.util.JwtUtil;
import br.com.example.atividadesemana12.security.request.LoginRequest;
import br.com.example.atividadesemana12.security.response.JwtResponse;
import br.com.example.atividadesemana12.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UsuarioController {


    private final AuthenticationManager authenticationManager;


    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsuario(), loginRequest.getSenha()));


        String token = JwtUtil.generateToken((UserDetails) authentication);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @Autowired
    private final UsuarioService usuarioService;

    @PostMapping("/usuarios")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioEntity usuario) {
        try {
            usuarioService.criar(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar usuário");
        }
    }

}



