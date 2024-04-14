package br.com.example.atividadesemana12.controller;

import br.com.example.atividadesemana12.entity.NotaEntity;
import br.com.example.atividadesemana12.repository.NotaRepository;
import br.com.example.atividadesemana12.service.NotaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class NotaController {


    private final NotaService notaService;
    private final NotaRepository notaRepository;

    @GetMapping("/notas")
    public ResponseEntity<List<NotaEntity>> getNotasDoUsuario() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String usuarioLogado = authentication.getName();
        List<NotaEntity> notas = notaService.buscarNotasDoUsuario(usuarioLogado);
        return ResponseEntity.ok(notas);
    }
    @PostMapping
    public ResponseEntity<NotaEntity> criarNota(@RequestBody NotaEntity notaNova) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(notaRepository.save(notaNova));
    }

    @GetMapping
    public List<NotaEntity> buscarTodasNotas() {
        return notaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotaEntity> buscarNotaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(notaRepository.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotaEntity> atualizarNota(
            @PathVariable Long id, @RequestBody NotaEntity nota) {
        return ResponseEntity.ok(notaRepository.alterar(id, nota));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarNota(@PathVariable Long id) {
        notaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
