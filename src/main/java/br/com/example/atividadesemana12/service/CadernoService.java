package br.com.example.atividadesemana12.service;

import br.com.example.atividadesemana12.entity.CadernoEntity;

import java.util.List;

public interface CadernoService {

    List<CadernoEntity> buscarTodos();

    CadernoEntity buscarPorId(Long id);

    CadernoEntity criar(CadernoEntity caderno);

    CadernoEntity atualizar(Long id, CadernoEntity caderno);

    void excluir(Long id);

    List<CadernoEntity> buscarCadernosDoUsuario(String usuarioLogado);
}
