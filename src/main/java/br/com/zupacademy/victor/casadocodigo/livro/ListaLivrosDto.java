package br.com.zupacademy.victor.casadocodigo.livro;

public class ListaLivrosDto {

    private Long id;
    private String titulo;

    public ListaLivrosDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

}
