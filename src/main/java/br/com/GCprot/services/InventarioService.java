package br.com.GCprot.services; // Corrigido para GCprot

import java.util.List;

import br.com.GCprot.entities.Inventario;
import br.com.GCprot.repository.InventarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public Inventario createInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }


    public Inventario updateInventario(Inventario inventarioUpdated) {
        Inventario inventarioBank = inventarioRepository.findById(inventarioUpdated.getId())
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar usuário para atualizar"));
        inventarioBank.setItem(inventarioUpdated.getItem());
        inventarioBank.setDescricaoItem(inventarioUpdated.getDescricaoItem());
        inventarioBank.setValorItem(inventarioUpdated.getValorItem());
        inventarioBank.setSituacaoItem(inventarioUpdated.getSituacaoItem());

        return inventarioRepository.save(inventarioBank);
    }

    @Transactional
    public boolean deleteInventario(int inventarioId) {
        Inventario inventario = inventarioRepository.findById(inventarioRepository)
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar usuário para deletar"));
        inventarioRepository.delete(inventario);
        return true;
    }

    public Inventario readInventario(int inventarioId) {
        Inventario inventario = inventarioRepository.findById(inventarioId)
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar usuário para ler"));
        return inventario;
    }

    public List<Inventario> readInventarioAll() {
        return inventarioRepository.findAll();
    }
}
