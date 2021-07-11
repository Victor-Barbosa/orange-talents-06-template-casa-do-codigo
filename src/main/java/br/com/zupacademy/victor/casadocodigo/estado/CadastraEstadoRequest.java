package br.com.zupacademy.victor.casadocodigo.estado;

import br.com.zupacademy.victor.casadocodigo.pais.Pais;

import javax.validation.constraints.NotBlank;

public class CadastraEstadoRequest {

    @NotBlank(message = "Nome é obrigatório")
    final String nome;

    @NotBlank(message = "Id do País é obrigatório")
    final String nomePais;

    public CadastraEstadoRequest(String nome, String nomePais) {
        this.nome = nome;
        this.nomePais = nomePais;
    }

    public Estado toModel(Pais pais) {
        return new Estado(pais, nome);
    }
}
