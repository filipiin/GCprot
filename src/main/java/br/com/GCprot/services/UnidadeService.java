package br.com.GCprot.services; // Corrigido para GCprot

import java.util.List;

import br.com.GCprot.entities.Unidade;
import br.com.GCprot.repository.UnidadeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired; // Import necessário
import org.springframework.stereotype.Service; // Import necessário

@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository unidadeRepository;

    public Unidade createUnidade(Unidade unidade) {
        return unidadeRepository.save(unidade);
    }

    /**
     * Atualiza uma pessoa.
     * 'pessoaAtualizada' contém os novos dados (pode ser um DTO ou a própria entidade vinda do JSON).
     */
    public Unidade updateUnidade(Unidade unidadeUpdated) {
        Unidade unidadeBank = unidadeRepository.findById(unidadeUpdated.getId())
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar usuário para atualizar"));
        unidadeBank.setProprietario(unidadeUpdated.getProprietario());
        unidadeBank.setRua(unidadeUpdated.getRua());
        unidadeBank.setQuadrante(unidadeUpdated.getQuadrante());
        unidadeBank.setNumUnidade(unidadeUpdated.getNumUnidade());
        unidadeBank.setSituacao(unidadeUpdated.getSituacao());


        // 3. Salva a entidade atualizada
        return unidadeRepository.save(unidadeBank);
    }

    @Transactional
    public boolean deleteUnidade(int unidadeId) {
        Unidade unidade = unidadeRepository.findById(unidadeId)
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar usuário para deletar"));
        unidadeRepository.delete(unidade);
        return true;
    }

    public Unidade readUnidade(int unidadeId) {
        Unidade unidade = unidadeRepository.findById(unidadeId)
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar usuário para ler"));
        return unidade;
    }

    public List<Unidade> readUnidadeAll() {
        return unidadeRepository.findAll();
    }
}
// A chave extra foi removida