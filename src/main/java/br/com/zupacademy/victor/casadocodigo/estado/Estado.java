package br.com.zupacademy.victor.casadocodigo.estado;

import br.com.zupacademy.victor.casadocodigo.pais.Pais;

import javax.persistence.*;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    private Pais pais;

    public Estado(Pais pais, String nome) {
        this.nome = nome;
        this.pais = pais;
    }

    @Deprecated
    public Estado() {

    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }
}
