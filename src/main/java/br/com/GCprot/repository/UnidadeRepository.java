package br.com.GCprot.repository;

import br.com.GCprot.entities.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Integer> {

    // É SÓ ISSO!

    // Métodos que você GANHA DE GRAÇA do JpaRepository:
    //
    // -> save(Unidade unidade)             (Usado no create e update)
    // -> findById(Integer id)              (Usado no read, update, delete)
    // -> findAll()                         (Usado no readAll)
    // -> delete(Unidade unidade)           (Usado no delete)
    // -> count()
    // -> existsById(Integer id)
    // ... e muitos outros!
}