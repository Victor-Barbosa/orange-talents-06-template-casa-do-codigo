package br.com.zupacademy.victor.casadocodigo.cliente;

import br.com.zupacademy.victor.casadocodigo.compartilhado.CPFOuCNPJ;
import br.com.zupacademy.victor.casadocodigo.estado.Estado;
import br.com.zupacademy.victor.casadocodigo.pais.Pais;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CadastraClienteRequest {

    @NotBlank(message = "Email é obrigatorio")
    @Email
    final String email;

    @NotBlank(message = "Nome é obrigatorio")
    final String nome;

    @NotBlank(message = "Sobrenome é obrigatorio")
    final String sobreNome;

    @NotBlank(message = "Documento é obrigatorio")
    @CPFOuCNPJ
    final String documento;

    @NotBlank(message = "Endereço é obrigatorio")
    final String endereco;

    @NotBlank(message = "Complento é obrigatorio")
    final String complemento;

    @NotBlank(message = "Cidade é obrigatorio")
    final String cidade;

    @NotBlank(message = "País é obrigatorio")
    final String nomePais;

    final String nomeEstado;

    @NotBlank(message = "Telefone é obrigatorio")
    final String telefone;

    @NotBlank(message = "Cep é obrigatorio")
    final String cep;

    public CadastraClienteRequest(String email, String nome, String sobreNome, String documento, String endereco, String complemento, String cidade,
                                  String nomePais, String nomeEstado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.nomePais = nomePais;
        this.nomeEstado = nomeEstado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente toModel(Pais pais, Estado estado) {
        return new Cliente(pais, estado, email, nome, sobreNome, documento, endereco, complemento, cidade, telefone, cep);
    }
}

