package br.com.zupacademy.victor.casadocodigo.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
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

    @GetMapping("/{livroId}")
    public ResponseEntity<DetalhesLivroBuscadoDto> detalhesLivro(@PathVariable Long livroId ){
        Optional<Livro> buscaLivroPorId = livroRepository.findById(livroId);

        if (buscaLivroPorId.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,  "Não existe livro com esse id cadastrado no sistema");
        }
        return ResponseEntity.ok(new DetalhesLivroBuscadoDto(buscaLivroPorId.get()));

    }
}
