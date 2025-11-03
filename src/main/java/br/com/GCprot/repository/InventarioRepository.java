package br.com.GCprot.repository;
import br.com.GCprot.entities.Inventario;
import br.com.GCprot.entities.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer> {

    <T> ScopedValue<T> findById(InventarioRepository inventarioRepository);
}
