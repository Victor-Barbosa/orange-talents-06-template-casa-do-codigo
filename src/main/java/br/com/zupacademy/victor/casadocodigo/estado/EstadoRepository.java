package br.com.zupacademy.victor.casadocodigo.estado;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    boolean existsByNomeAndPaisNome(String nome, String nomePais);

    Optional<Estado> findByNomeAndPaisNome(String nomeEstado, String nomePais);
}
