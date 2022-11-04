package br.com.algaworks.entregas.domain.repository;

import br.com.algaworks.entregas.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findClienteByNome(String nome);
    Optional<Cliente> findClienteByEmail (String email);
}
