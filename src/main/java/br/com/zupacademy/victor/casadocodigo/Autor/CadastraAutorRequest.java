package br.com.zupacademy.victor.casadocodigo.Autor;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CadastraAutorRequest {

    @NotBlank(message = "Nome não deve ser em branco ou nulo!")
    @Length(min = 3, message = "Nome deve ter no mínimo 3 caracteres!")
    private String nome;
    @Email(message = "Email deve ter formato válido!")
    @NotBlank(message = "Email não deve ser em branco ou nulo!")
    @Length(min = 5,message = "Email deve ter no mínimo 3 caracteres!")
    private String email;
    @NotBlank(message = "Descrição não deve ser em branco ou nulo!")
    @Length(min = 3, max = 400, message = "Descrição deve ter entre 3 e 400 caracteres!")
    private String descricao;

    public CadastraAutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    public Autor toModel() {
        return new Autor(nome, email, descricao);
    }
}
