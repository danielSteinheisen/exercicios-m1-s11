package br.com.example.atividadesemana12.service;

import br.com.example.atividadesemana12.entity.NotaEntity;

import java.util.List;

public interface NotaService {

    List<NotaEntity> buscarTodos();

    NotaEntity buscarPorId(Long id);

    NotaEntity criar(NotaEntity nota);

    NotaEntity atualizar(Long id, NotaEntity nota);

    void excluir(Long id);

    List<NotaEntity> buscarNotasDoUsuario(String usuarioLogado);
}
