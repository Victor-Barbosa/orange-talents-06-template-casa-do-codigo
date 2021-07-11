package br.com.zupacademy.victor.casadocodigo.livro;

import br.com.zupacademy.victor.casadocodigo.Autor.Autor;
import br.com.zupacademy.victor.casadocodigo.categoria.Categoria;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String titulo;

    @Column(nullable = false)
    @Size(max = 500, message = "Resumo possui limite de 500 caracteres")
    private String resumo;

    private String sumario;

    @Column(nullable = false)
    private BigDecimal precoLivro;

    @Column(nullable = false)
    private Integer numeroDePaginas;

    @Column(nullable = false, unique = true)
    private Integer isbn;

    @Column(nullable = false)
    private LocalDate dataLancamento;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Categoria categoria;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Autor Autor;

    public Livro(String titulo, String resumo, String sumario, BigDecimal precoLivro, Integer numeroDePaginas, Integer isbn,
                 LocalDate dataLancamento, Categoria categoria, br.com.zupacademy.victor.casadocodigo.Autor.Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.precoLivro = precoLivro;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.categoria = categoria;
        this.Autor = autor;
    }

    @Deprecated
    public Livro() {

    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPrecoLivro() {
        return precoLivro;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public br.com.zupacademy.victor.casadocodigo.Autor.Autor getAutor() {
        return Autor;
    }

}
