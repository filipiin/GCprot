package br.com.GCprot.services; // Corrigido para GCprot

import java.util.List;

import br.com.GCprot.entities.Pessoa;
import br.com.GCprot.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired; // Import necessário
import org.springframework.stereotype.Service; // Import necessário

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa createPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa updatePessoa(Pessoa pessoaUpdated) {
        Pessoa pessoaBank = pessoaRepository.findById(pessoaUpdated.getId())
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar usuário para atualizar"));
        pessoaBank.setName(pessoaUpdated.getName());
        pessoaBank.setEmail(pessoaUpdated.getEmail());
        pessoaBank.setPassword(pessoaUpdated.getPassword());

        return pessoaRepository.save(pessoaBank);
    }

    @Transactional
    public boolean deletePessoa(int pessoaId) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar usuário para deletar"));
        pessoaRepository.delete(pessoa);
        return true;
    }

    public Pessoa readPessoa(int pessoaId) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar usuário para ler"));
        return pessoa;
    }

    public List<Pessoa> readPessoaAll() {
        return pessoaRepository.findAll();
    }
}
// A chave extra foi removida