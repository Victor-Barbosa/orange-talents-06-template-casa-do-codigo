package br.com.zupacademy.victor.casadocodigo.Autor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    @Email
    private String email;
    @Column(nullable = false)
    @Size(max = 400)
    private String descricao;
    @Column(updatable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    @Deprecated
    public Autor() {
    }
}
