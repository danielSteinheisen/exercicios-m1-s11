package br.com.example.atividadesemana12.service;

import br.com.example.atividadesemana12.entity.UsuarioEntity;
import br.com.example.atividadesemana12.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;


    @Override
    public List<UsuarioEntity> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioEntity buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Usuário não encontrado com o ID: " + id
                ));
    }

    @Override
    public UsuarioEntity criar(UsuarioEntity usuario) {
        usuario.setId(null);
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity atualizar(Long id, UsuarioEntity usuario) {
        buscarPorId(id);
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    @Override
    public void excluir(Long id) {
        UsuarioEntity usuario = buscarPorId(id);
        usuarioRepository.delete(usuario);

    }
}
