package br.com.GCprot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.GCprot.entities.Occurrence;

@Repository
public interface OccurrenceRepository extends JpaRepository<Occurrence, Integer> {

}
