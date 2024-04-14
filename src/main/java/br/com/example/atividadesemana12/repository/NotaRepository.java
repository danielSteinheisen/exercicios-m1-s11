package br.com.example.atividadesemana12.repository;

import br.com.example.atividadesemana12.entity.NotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotaRepository extends JpaRepository<NotaEntity, Long> {
    List<NotaEntity> findByUsuario(String usuario);

    NotaEntity buscarPorId(Long id);

    NotaEntity alterar(Long id, NotaEntity nota);
}
