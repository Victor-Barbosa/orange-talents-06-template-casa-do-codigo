package br.com.zupacademy.victor.casadocodigo.estado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {



    boolean existsByNomeAndPaisNome(String nome, String nomePais);

}
