package br.com.zupacademy.victor.casadocodigo.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByDocumento(String documento);

    boolean existsByEmail(String email);
}
