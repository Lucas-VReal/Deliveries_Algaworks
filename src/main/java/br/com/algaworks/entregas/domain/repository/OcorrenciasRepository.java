package br.com.algaworks.entregas.domain.repository;

import br.com.algaworks.entregas.domain.model.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcorrenciasRepository extends JpaRepository<Ocorrencia, Long> {

}
