package br.com.zupacademy.victor.casadocodigo.livro;

import br.com.zupacademy.victor.casadocodigo.Autor.Autor;
import br.com.zupacademy.victor.casadocodigo.Autor.AutorRepository;
import br.com.zupacademy.victor.casadocodigo.categoria.Categoria;
import br.com.zupacademy.victor.casadocodigo.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/livro/cadastra")
public class CadastraLivroController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LivroRepository livroRepository;

    public Categoria buscaCategoriaPorNome(String categoria){
        return categoriaRepository.findByNome(categoria)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe essa Categoria no sistema!"));
    }

    public Autor buscaAutorPorEmail(String email){
        return autorRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe Autor para esse email!"));

    }
    @PostMapping
    public void cadastraLivro(@Valid @RequestBody CadastraLivroRequest cadastraLivroRequest){
        Categoria categoria = buscaCategoriaPorNome(cadastraLivroRequest.getCategoria());
        Autor autor = buscaAutorPorEmail(cadastraLivroRequest.getEmailAutor());

        if (livroRepository.existsByTitulo(cadastraLivroRequest.getTitulo())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe livro com esse titulo!");
        }
        if (livroRepository.existsByIsbn(cadastraLivroRequest.getIsbn())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe livro com esse ISBN!");
        }

        Livro novoLivro = cadastraLivroRequest.toModel(categoria, autor);
        livroRepository.save(novoLivro);
    }

}
