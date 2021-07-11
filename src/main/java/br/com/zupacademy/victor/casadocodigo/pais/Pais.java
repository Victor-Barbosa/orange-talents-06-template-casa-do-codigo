package br.com.zupacademy.victor.casadocodigo.pais;

import javax.persistence.*;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nome;

    public Pais(String nome) {
        this.nome = nome;
    }

    @Deprecated
    public Pais() {

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
