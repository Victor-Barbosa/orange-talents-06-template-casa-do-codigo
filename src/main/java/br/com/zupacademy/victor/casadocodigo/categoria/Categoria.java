package br.com.zupacademy.victor.casadocodigo.categoria;

import javax.persistence.*;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nome;

    public Categoria(String categoriaNome) {
        this.nome = categoriaNome;
    }

    @Deprecated
    public Categoria() {

    }
}