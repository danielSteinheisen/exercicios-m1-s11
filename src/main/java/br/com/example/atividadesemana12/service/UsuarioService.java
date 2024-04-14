package br.com.example.atividadesemana12.service;

import br.com.example.atividadesemana12.entity.UsuarioEntity;

import java.util.List;

public interface UsuarioService {

    public List<UsuarioEntity> buscarTodos();

    public UsuarioEntity buscarPorId(Long id);

    public UsuarioEntity criar(UsuarioEntity usuario);

    public UsuarioEntity atualizar(Long id, UsuarioEntity usuario);

    public void excluir(Long id);
}
