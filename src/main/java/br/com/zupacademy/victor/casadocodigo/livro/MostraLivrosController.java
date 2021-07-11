package br.com.zupacademy.victor.casadocodigo.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/livro/lista_livros")
public class MostraLivrosController {

    @Autowired
    public LivroRepository livroRepository;

    @GetMapping
    public List<ListaLivrosDto> listarLivros(){
        List<Livro> listaLivros = livroRepository.findAll();
        return listaLivros.stream().map(ListaLivrosDto::new).collect(Collectors.toList());

    }
}
