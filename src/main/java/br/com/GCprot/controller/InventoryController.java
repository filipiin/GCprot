package br.com.GCprot.controller;

import br.com.GCprot.entities.Inventory;
import br.com.GCprot.entities.ItemInventory; // 1. Importe a entidade ItemInventory
import br.com.GCprot.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory") // URL base
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
        return new ResponseEntity<>(inventoryService.createInventory(inventory), HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<ItemInventory> createItemInventory(@RequestBody ItemInventory item) {
        return new ResponseEntity<>(inventoryService.createItemInventory(item), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<Inventory> ListAll() {
        return inventoryService.readInventoryAll();
    }

    @GetMapping("/list")
    public List<ItemInventory> ListAll() {
        return inventoryService.readItemInventoryAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventoryUpdate) {
        return new ResponseEntity<>(inventoryService.updateInventory(inventoryUpdate), HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<ItemInventory> updateItemInventory(@RequestBody ItemInventory item) {
        return new ResponseEntity<>(inventoryService.updateInventory(item), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable(name = "id")int id) {
        Inventory inventory = inventoryService.findById(id);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventoryUpdate) {
        Inventory inventory = inventoryService.updateInventory(inventoryUpdate); // Mudei o nome
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable int id) {
        inventoryService.deleteInventory(id); // Mudei o nome
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



        Inventory updatedInventory = inventoryService.addItemToInventory(inventoryId, item);
        return new ResponseEntity<>(updatedInventory, HttpStatus.OK);
    }

        Inventory updatedInventory = inventoryService.removeItemFromInventory(inventoryId, name, quantity);
        return new ResponseEntity<>(updatedInventory, HttpStatus.OK);
    }
}