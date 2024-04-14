package br.com.example.atividadesemana12.service;

import br.com.example.atividadesemana12.entity.NotaEntity;
import br.com.example.atividadesemana12.repository.NotaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NotaServiceImpl implements NotaService {

    private final NotaRepository notaRepository;
    @Override
    public List<NotaEntity> buscarTodos() {
        return notaRepository.findAll();
    }

    @Override
    public NotaEntity buscarPorId(Long id) {
        return notaRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Nota não encontrada com o ID: " + id
                ));
    }

    @Override
    public NotaEntity criar(NotaEntity nota) {
        nota.setId(null);
        return notaRepository.save(nota);
    }

    @Override
    public NotaEntity atualizar(Long id, NotaEntity nota) {
        buscarPorId(id);
        nota.setId(id);
        return notaRepository.save(nota);
    }
    public List<NotaEntity> buscarNotasDoUsuario(String usuario) {
        return notaRepository.findByUsuario(usuario);
    }

    @Override
    public void excluir(Long id) {
        NotaEntity nota = buscarPorId(id);
        notaRepository.delete(nota);

    }
}
