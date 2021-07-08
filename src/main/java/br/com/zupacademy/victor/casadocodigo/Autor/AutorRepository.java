package br.com.zupacademy.victor.casadocodigo.Autor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    boolean existsByEmail(String email);

    Optional<Autor> findByEmail(String email);
}
