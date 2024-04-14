package br.com.example.atividadesemana12.repository;

import br.com.example.atividadesemana12.entity.CadernoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CadernoRepository  extends JpaRepository<CadernoEntity, Long> {

    List<CadernoEntity> findByUsuario(String usuarioLogado);

    CadernoEntity atualizar(Long id, CadernoEntity caderno);

    CadernoEntity buscarPorId(Long id);
}
