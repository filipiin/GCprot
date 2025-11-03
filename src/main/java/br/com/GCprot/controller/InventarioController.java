package br.com.GCprot.controller;

import br.com.GCprot.entities.Inventario;
import br.com.GCprot.services.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario") // ✅ URL base correta: /inventario
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;


    @PostMapping
    public ResponseEntity<Inventario> criarItemInventario(@RequestBody Inventario inventario) {
        // 💡 @RequestBody: Pega o JSON e transforma no objeto 'Inventario'
        Inventario novoItemInventario = inventarioService.createInventario(inventario);
        return new ResponseEntity<>(novoItemInventario, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Inventario>> buscarTodosItensInventario() {
        List<Inventario> inventario = inventarioService.readInventarioAll();
        return new ResponseEntity<>(inventario, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Inventario> buscaItemInventarioPorId(@PathVariable int id) {
        Inventario inventario = inventarioService.readInventario(id);
        return new ResponseEntity<>(inventario, HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<Inventario> atualizarItemInventario(@RequestBody Inventario inventario) {

        Inventario inventarioUpdated = inventarioService.updateInventario(inventario);
        return new ResponseEntity<>(inventarioUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItemInventario(@PathVariable int id) {

        inventarioService.deleteItemInventario(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}