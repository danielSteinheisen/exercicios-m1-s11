package br.com.example.atividadesemana12.repository;

import br.com.example.atividadesemana12.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
