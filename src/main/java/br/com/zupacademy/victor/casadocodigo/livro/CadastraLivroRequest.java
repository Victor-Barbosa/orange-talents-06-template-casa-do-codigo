package br.com.zupacademy.victor.casadocodigo.livro;

import br.com.zupacademy.victor.casadocodigo.Autor.Autor;
import br.com.zupacademy.victor.casadocodigo.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CadastraLivroRequest {

    @NotBlank
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    private String sumario;
    @Min(value = 20, message = "Valor minimo é 20!")
    @NotNull
    private BigDecimal precoLivro;
    @NotNull
    @Min(value = 100, message = "Livro deve conter no minimo 100 paginas!")
    private Integer numeroDePaginas;
    @NotNull
    private Integer isbn;
    @NotNull
    @Future(message = "A data de lancamento deve ser posterior a data de hoje!")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataLancamento;
    @NotBlank
    private String categoria;
    @NotBlank
    private String emailAutor;

    public CadastraLivroRequest(String titulo, String resumo, String sumario, BigDecimal precoLivro, Integer numeroDePaginas, Integer isbn, String categoria, String emailAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.precoLivro = precoLivro;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.categoria = categoria;
        this.emailAutor = emailAutor;
    }

    public Livro toModel(Categoria categoria, Autor emailAutor) {
        return new Livro(titulo, resumo, sumario, precoLivro, numeroDePaginas, isbn, dataLancamento, categoria, emailAutor);
    }

    public String getCategoria() {
        return categoria;
    }

    public String getEmailAutor() {
        return emailAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
