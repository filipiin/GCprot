package br.com.GCprot.controller;

import br.com.GCprot.entities.Inventory;
import br.com.GCprot.entities.ItemInventory;
import br.com.GCprot.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
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
    public List<Inventory> listInventoryAll() {
        return inventoryService.readInventoryAll();
    }

    @GetMapping("/item/list/")
    public List<ItemInventory> listItemInventoryAll() {
        return inventoryService.readItemInventoryAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventoryUpdate) {
        return new ResponseEntity<>(inventoryService.updateInventory(inventoryUpdate), HttpStatus.OK);

    }
    @PutMapping("/item/{id}")
    public ResponseEntity<ItemInventory> updateItemInventory(@RequestBody ItemInventory itemUpdate) {
        return new ResponseEntity<>(inventoryService.updateItemInventory(itemUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteInventory(@PathVariable(name = "id")  int id) {// Mudei o nome
        return new ResponseEntity<>(inventoryService.deleteInventory(id), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<Boolean> deleteItemInventory(@PathVariable(name = "id") int item_id) {// Mudei o nome
        return new ResponseEntity<>(inventoryService.deleteItemInventory(item_id), HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<Inventory> readInventory(@PathVariable(name = "id")int id){
        return new ResponseEntity<>(inventoryService.readInventory(id), HttpStatus.OK);
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<ItemInventory> readItemInventory(@PathVariable(name = "id")int item_id){
        return new ResponseEntity<>(inventoryService.readItemInventory(item_id), HttpStatus.OK);
    }
}