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

    @Autowired
    private ItemInventoryRepository itemInventoryRepository;


    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public Inventory updateInventory(Inventory inventory) {
        Inventory inventoryUpdate = inventoryRepository.findById(inventory.getId())
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar inventário para atualizar."));

        inventoryUpdate.setName(inventory.getName());
        inventoryUpdate.setInventoryType(inventory.getType());
        return inventoryRepository.save(inventoryUpdate);
    }

    @Transactional
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
        return inventoryRepository.findAll();
    }

    public ItemInventory createItemInventory(ItemInventory item) {
        return itemInventoryRepository.save(item);
    }

    public List<ItemInventory> readItemInventoryAll() {
        return itemInventoryRepository.findAll();
    }

    public ItemInventory updateItemInventory( ItemInventory itemUpdate) {

        ItemInventory item = itemInventoryRepository.findById(itemUpdate.id()).orElseThrow(() -> new RuntimeException("error search product"));
        item.setName(itemUpdate.name());
        item.setDescription(itemUpdate.description());
        item.setSituation(itemUpdate.situation());
        item.setQuantity(itemUpdate.quantity());
        item.setValue(itemUpdate.value());
        return itemInventoryRepository.save(item);

    }

    @Transactional
    public boolean deleteItemInventory(int id) {
        ItemInventory item = itemInventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar item de inventário para deletar. ID: " + id));
        itemInventoryRepository.delete(item);
        return true;
    }

    public ItemInventory readItemInventory(int id) {
        ItemInventory item = itemInventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar item de inventário para ler. ID: " + id));
        return item;
    }
    public List<Inventory> readInventoryAll() {
        return inventoryRepository.findAll();
    }


}