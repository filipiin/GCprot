package br.com.GCprot.controller;

import br.com.GCprot.entities.Unit;
import br.com.GCprot.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 1. Avisa ao Spring que esta classe é um Controller REST (vai receber e enviar JSON)
@RequestMapping("/unidades") // 2. Define a URL base. Todas as operações aqui dentro começarão com http://localhost:8080/unidades
public class UnitController {

    @Autowired //  3. Injeta o "Cérebro" (Service). O Controller SÓ fala com o Service.
    private UnitService unitService;

    // --- Endpoint de CRIAÇÃO (Create) ---
    // HTTP POST -> http://localhost:8080/unidades
    @PostMapping
    public ResponseEntity<Unit> createUnit(@RequestBody Unit unit) {
        //  @RequestBody: Pega o JSON enviado pelo front-end e transforma no objeto 'Unidade'
        Unit newUnit = unitService.createUnit(unit);
        //  ResponseEntity: Permite retornar um status HTTP. 201 CREATED é o padrão para criação.
        return new ResponseEntity<>(newUnit, HttpStatus.CREATED);
    }

    // --- Endpoint de LEITURA (Read) - Todos ---
    // HTTP GET -> http://localhost:8080/unidades
    @GetMapping
    public ResponseEntity<List<Unit>> searchAllUnits() {
        List<Unit> unities = unitService.readAllUnits();
        return new ResponseEntity<>(unities, HttpStatus.OK); // OK (200)
    }

    // --- Endpoint de LEITURA (Read) - Por ID ---
    // HTTP GET -> http://localhost:8080/unidades/5 (por exemplo)
    @GetMapping("/{id}")
    public ResponseEntity<Unit> searchUnitById(@PathVariable int id) {
        //  @PathVariable: Pega o 'id' que veio na URL (o '5' do exemplo) e coloca na variável 'int id'
        Unit unit = unitService.readUnit(id);
        return new ResponseEntity<>(unit, HttpStatus.OK);
    }

    // --- Endpoint de ATUALIZAÇÃO (Update) ---
    // HTTP PUT -> http://localhost:8080/unidades
    @PutMapping
    public ResponseEntity<Unit> updateUnit(@RequestBody Unit unit) {
        //  @RequestBody: Pega o JSON com os dados da unidade para atualizar
        Unit unitUpdated = unitService.updateUnit(unit);
        return new ResponseEntity<>(unitUpdated, HttpStatus.OK);
    }

    // --- Endpoint de DELEÇÃO (Delete) ---
    // HTTP DELETE -> http://localhost:8080/unidades/5 (por exemplo)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnit(@PathVariable int id) {
        //  @PathVariable: Pega o 'id' da URL para saber quem deletar
        unitService.deleteUnit(id);
        //  Para delete, não retornamos conteúdo (void) e status NO_CONTENT (204)
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}