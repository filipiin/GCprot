package br.com.GCprot.services; // Corrigido para GCprot

import java.util.List;

import br.com.GCprot.entities.Occurrence;
import br.com.GCprot.repository.OccurrenceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired; // Import necessário
import org.springframework.stereotype.Service; // Import necessário

@Service
public class OccurrenceService {

    @Autowired
    private OccurrenceRepository occurrenceRepository;

    public Occurrence createoccurrence(Occurrence occurrence) {
        return occurrenceRepository.save(occurrence);
    }

    public Occurrence updateOccurrence(Occurrence occurrenceUpdated) {
        Occurrence occurrenceBank = occurrenceRepository.findById(occurrenceUpdated.getId())
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar usuário para atualizar"));

        return occurrenceRepository.save(occurrenceBank);
    }

    @Transactional
    public boolean deleteOccurrence(int occurrenceId) {
        Occurrence occurrence = occurrenceRepository.findById(occurrenceId)
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar usuário para deletar"));
        occurrenceRepository.delete(occurrence);
        return true;
    }

    public Occurrence readOccurrence(int occurrenceId) {
        Occurrence occurrence = occurrenceRepository.findById(occurrenceId)
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar usuário para ler"));
        return occurrence;
    }

    public List<Occurrence> readOccurrenceAll() {
        return occurrenceRepository.findAll();
    }
}