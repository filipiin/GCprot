package br.com.GCprot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.GCprot.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
