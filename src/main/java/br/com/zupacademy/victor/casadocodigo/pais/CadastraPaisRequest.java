package br.com.zupacademy.victor.casadocodigo.pais;

import javax.validation.constraints.NotBlank;

public class CadastraPaisRequest {

    @NotBlank(message = "Nome do País não pode ser branco ou nulo!")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Pais toModel() {
        return new Pais(nome);
    }
}
