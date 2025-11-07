package br.com.GCprot.services;

import br.com.GCprot.entities.Inventory;
import br.com.GCprot.entities.ItemInventory;
import br.com.GCprot.repository.InventoryRepository;
import br.com.GCprot.repository.ItemInventoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Transactional
    public Inventory updateInventory(Inventory inventory) {
        Inventory inventoryUpdate = inventoryRepository.findById(inventory.getId())
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar inventário para atualizar."));

        inventoryUpdate.setName(inventory.getName());
        inventoryUpdate.setInventoryType(inventory.getType());
        return inventoryRepository.save(inventoryUpdate);
    }

    public boolean deleteInventory(int inventoryId) {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar inventário para deletar."));
        inventoryRepository.delete(inventory);
        return true;
    }

    public Inventory readInventory(int inventoryId) {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar inventário para ler"));
        return inventory;
    }

    public List<Inventory> readInventoryAll() {
        return inventoryRepository.findAll().stream().toList();
    }

    @Autowired
    private ItemInventoryRepository itemInventoryRepository;

    public ItemInventory createItemInventory(ItemInventory item) {
        return itemInventoryRepository.save(item);
    }

    @Transactional
    public ItemInventory updateItemInventory(ItemInventory itemUpdate) {
        ItemInventory item = itemInventoryRepository.findById(itemUpdate.getId()).orElseThrow(() -> new RuntimeException("Erro ao encontrar inventário para atualizar."));

        item.setName(itemUpdate.getName());
        item.setSituation(itemUpdate.getSituation());
        item.setDescription(itemUpdate.getDescription());
        item.setQuantity(itemUpdate.getQuantity());
        item.setValue(itemUpdate.getValue());
        return itemInventoryRepository.save(item);
    }

    public boolean deleteItemInventory(int id) {
        ItemInventory item = itemInventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar item de inventário para deletar. ID: " + id));
        itemInventoryRepository.delete(item);
        return true;
    }

    public ItemInventory readItemInventory(int id) {
        ItemInventory item = itemInventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Erro ao encontrar item de inventário para ler."));
        return item;
    }

    public List<ItemInventory> readItemInventoryAll() {
        return itemInventoryRepository.findAll();
    }
}