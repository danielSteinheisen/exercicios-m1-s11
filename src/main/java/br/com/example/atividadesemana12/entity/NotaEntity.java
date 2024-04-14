package br.com.example.atividadesemana12.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class NotaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "id_caderno")
    private CadernoEntity caderno;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;
}
