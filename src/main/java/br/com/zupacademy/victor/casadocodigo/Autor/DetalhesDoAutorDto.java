package br.com.zupacademy.victor.casadocodigo.Autor;

public class DetalhesDoAutorDto {

    private final String nome;
    private final String descricao;

    public DetalhesDoAutorDto(Autor autor){
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();

    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
