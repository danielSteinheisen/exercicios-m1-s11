package br.com.example.atividadesemana12.service;

import br.com.example.atividadesemana12.entity.CadernoEntity;
import br.com.example.atividadesemana12.repository.CadernoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CadernoServiceImpl implements CadernoService {

    @Autowired
    private final CadernoRepository cadernoRepository;

    public List<CadernoEntity> buscarTodos() {
        return cadernoRepository.findAll();
    }

    public CadernoEntity buscarPorId(Long id) {
        return cadernoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Caderno não encontrado com o ID: " + id
                ));
    }

    public CadernoEntity criar(CadernoEntity caderno) {
        return cadernoRepository.save(caderno);
    }

    public CadernoEntity atualizar(Long id, CadernoEntity caderno) {
        buscarPorId(id);
        caderno.setId(id);
        return cadernoRepository.save(caderno);
    }

    public void excluir(Long id) {
        CadernoEntity caderno = buscarPorId(id);
        cadernoRepository.delete(caderno);
    }

    @Override
    public List<CadernoEntity> buscarCadernosDoUsuario(String usuarioLogado) {
        return cadernoRepository.findByUsuario(usuarioLogado);
    }
}

