package br.com.zupacademy.victor.casadocodigo.categoria;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class CadastraCategoriaRequest {

    @NotBlank(message = "Nome da categoria não pode ser branco ou nulo!")
    @Length(min = 3, message = "Nome da categoria deve ter no minimo 3 caracteres")
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(nome);
    }
}