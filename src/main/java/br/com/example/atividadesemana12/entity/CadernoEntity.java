package br.com.example.atividadesemana12.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CadernoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

}

