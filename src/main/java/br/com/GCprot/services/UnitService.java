package br.com.GCprot.services; // Corrigido para GCprot

import java.util.List;

import br.com.GCprot.entities.Unit;
import br.com.GCprot.repository.UnitRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired; // Import necessário
import org.springframework.stereotype.Service; // Import necessário

@Service
public class UnitService {

    @Autowired
    private UnitRepository unitRepository;

    public Unit createUnit(Unit unit) {
        return unitRepository.save(unit);
    }


    public Unit updateUnit(Unit unitUpdated) {
        Unit unitBank = unitRepository.findById(unitUpdated.getId())
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar usuário para atualizar"));
        unitBank.setProprietario(unitUpdated.getProprietario());
        unitBank.setRua(unitUpdated.getRua());
        unitBank.setQuadrante(unitUpdated.getQuadrante());
        unitBank.setNumUnidade(unitUpdated.getNumUnidade());
        unitBank.setSituacao(unitUpdated.getSituacao());


        // 3. Salva a entidade atualizada
        return unitRepository.save(unitBank);
    }

    @Transactional
    public boolean deleteUnit(int unitId) {
        Unit unit = unitRepository.findById(unitId)
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar usuário para deletar"));
        unitRepository.delete(unit);
        return true;
    }

    public Unit readUnit(int unitId) {
        Unit unit = unitRepository.findById(unitId)
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar usuário para ler"));
        return unit;
    }

    public List<Unit> readUnidadeAll() {
        return unitRepository.findAll();
    }
}
// A chave extra foi removida