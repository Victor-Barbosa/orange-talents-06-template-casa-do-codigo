package br.com.zupacademy.victor.casadocodigo.categoria;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    boolean existsByNome(String nome);

    Optional<Categoria> findByNome(String nome);
}