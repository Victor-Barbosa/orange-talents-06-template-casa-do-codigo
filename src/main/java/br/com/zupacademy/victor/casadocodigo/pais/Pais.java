package br.com.zupacademy.victor.casadocodigo.pais;

import br.com.zupacademy.victor.casadocodigo.estado.Estado;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nome;

    @OneToMany(mappedBy = "pais")
    private List<Estado> estados = new ArrayList<>();

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

    public List<Estado> getEstados() {
        return estados;
    }
}
