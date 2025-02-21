package br.com.zupacademy.victor.casadocodigo.livro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    boolean existsByTitulo(String titulo);

    boolean existsByIsbn(Integer isbn);


}
