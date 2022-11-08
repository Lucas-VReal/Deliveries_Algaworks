package br.com.algaworks.deliveries.domain.repository;

import br.com.algaworks.deliveries.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findClientByNome(String nome);
    Optional<Client> findClientByEmail (String email);

}
