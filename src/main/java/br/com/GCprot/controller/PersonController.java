// Spring Web: Permite que sua aplicação receba requisições da web (HTTP)
// É o que cria as "URLs" (endpoints) que seu frontend (um site em React, Angular, ou um aplicativo mobile) vai chamar.

// Você cria classes chamadas @RestController (Controladores)
// Dentro delas, você usa anotações como:
// @GetMapping (para buscar dados
// @PostMapping (para enviar dados).
package br.com.GCprot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.GCprot.services.PersonService;
import br.com.GCprot.entities.Person;

import java.util.List;

@RestController// Diz ao Spring que esta classe é um Controller REST
@RequestMapping("/person")// Todas as URLs deste controller começarão com /api/pessoas
public class PersonController {
    @Autowired // 1. Injeção de Dependência: Pede ao Spring uma instância do PessoaRepository
    private PersonService personService;

    @PostMapping // 2. Mapeia este metodo para r equisições HTTP POST em /api/pessoas
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person newPerson = personService.createPerson(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    // --- Endpoint de LEITURA (Read) - Todos ---
    // HTTP GET -> http://localhost:8080/unidades
    @GetMapping
    public ResponseEntity<List<Person>> searchAllPersons() {
        List<Person> people = personService.readPersonAll();
        return new ResponseEntity<>(people, HttpStatus.OK); // OK (200)
    }

    // --- Endpoint de LEITURA (Read) - Por ID ---
    // HTTP GET -> http://localhost:8080/unidades/5 (por exemplo)
    @GetMapping("/{id}")
    public ResponseEntity<Person> searchPersonById(@PathVariable int id) {
        //  @PathVariable: Pega o 'id' que veio na URL (o '5' do exemplo) e coloca na variável 'int id'
        Person person = personService.readPerson(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    // --- Endpoint de ATUALIZAÇÃO (Update) ---
    // HTTP PUT -> http://localhost:8080/unidades
    @PutMapping
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        //  @RequestBody: Pega o JSON com os dados da unidade para atualizar
        Person personUpdated = personService.updatePerson(person);
        return new ResponseEntity<>(personUpdated, HttpStatus.OK);
    }

    // --- Endpoint de DELEÇÃO (Delete) ---
    // HTTP DELETE -> http://localhost:8080/unidades/5 (por exemplo)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable int id) {
        //  @PathVariable: Pega o 'id' da URL para saber quem deletar
        personService.deletePerson(id);
        //  Para delete, não retornamos conteúdo (void) e status NO_CONTENT (204)
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

