package br.com.zupacademy.victor.casadocodigo.pais;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaisRepository extends JpaRepository<Pais, Long> {

    boolean existsByNome(String nome);


    Optional<Pais> findByNome(String idPais);
}
