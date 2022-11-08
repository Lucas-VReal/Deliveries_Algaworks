package br.com.algaworks.deliveries.domain.repository;

import br.com.algaworks.deliveries.domain.model.Occurrence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccurrenceRepository extends JpaRepository<Occurrence, Long> {

}
