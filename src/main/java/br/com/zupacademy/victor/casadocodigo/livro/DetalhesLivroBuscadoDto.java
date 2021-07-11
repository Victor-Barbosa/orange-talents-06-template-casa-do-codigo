package br.com.zupacademy.victor.casadocodigo.livro;

import br.com.zupacademy.victor.casadocodigo.Autor.DetalhesDoAutorDto;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class DetalhesLivroBuscadoDto {

    private final String titulo;
    private final String resumo;
    private final String sumario;
    private final BigDecimal precoLivro;
    private final Integer numeroDePaginas;
    private final Integer isbn;
    private final String dataLancamento;
    private final DetalhesDoAutorDto autor;

    public DetalhesLivroBuscadoDto(Livro livro){
        autor = new DetalhesDoAutorDto(livro.getAutor());
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.precoLivro = livro.getPrecoLivro();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.isbn = livro.getIsbn();
        this.dataLancamento = livro.getDataLancamento()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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

    public String getDataLancamento() {
        return dataLancamento;
    }

    public DetalhesDoAutorDto getAutor() {
        return autor;
    }
}
