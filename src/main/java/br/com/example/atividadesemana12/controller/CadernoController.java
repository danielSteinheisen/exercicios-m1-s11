package br.com.example.atividadesemana12.controller;

import br.com.example.atividadesemana12.entity.CadernoEntity;
import br.com.example.atividadesemana12.entity.UsuarioEntity;
import br.com.example.atividadesemana12.repository.CadernoRepository;
import br.com.example.atividadesemana12.service.CadernoService;
import br.com.example.atividadesemana12.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CadernoController {

    private final CadernoService cadernoService;
    private final CadernoRepository cadernoRepository;

    @GetMapping("/cadernos")
    public ResponseEntity<List<CadernoEntity>> getCadernosDoUsuario() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String usuarioLogado = authentication.getName();
        List<CadernoEntity> cadernos = cadernoService.buscarCadernosDoUsuario(usuarioLogado);
        return ResponseEntity.ok(cadernos);
    }
    @PostMapping
    public ResponseEntity<CadernoEntity> criarCaderno(@RequestBody CadernoEntity cadernoNovo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cadernoRepository.save(cadernoNovo));
    }
    @GetMapping
    public List<CadernoEntity> buscarTodosCadernos() {
        return cadernoRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<CadernoEntity> buscarCadernoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cadernoRepository.buscarPorId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CadernoEntity> atualizarCaderno(
            @PathVariable Long id, @RequestBody CadernoEntity caderno) {
        return ResponseEntity.ok(cadernoRepository.atualizar(id, caderno));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarCaderno(@PathVariable Long id) {
        cadernoRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

}

