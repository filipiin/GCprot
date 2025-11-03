package br.com.GCprot.controller;

import br.com.GCprot.entities.Unidade;
import br.com.GCprot.services.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 1. Avisa ao Spring que esta classe é um Controller REST (vai receber e enviar JSON)
@RequestMapping("/unidades") // 2. Define a URL base. Todas as operações aqui dentro começarão com http://localhost:8080/unidades
public class UnidadeController {

    @Autowired //  3. Injeta o "Cérebro" (Service). O Controller SÓ fala com o Service.
    private UnidadeService unidadeService;

    // --- Endpoint de CRIAÇÃO (Create) ---
    // HTTP POST -> http://localhost:8080/unidades
    @PostMapping
    public ResponseEntity<Unidade> criarUnidade(@RequestBody Unidade unidade) {
        //  @RequestBody: Pega o JSON enviado pelo front-end e transforma no objeto 'Unidade'
        Unidade novaUnidade = unidadeService.createUnidade(unidade);
        //  ResponseEntity: Permite retornar um status HTTP. 201 CREATED é o padrão para criação.
        return new ResponseEntity<>(novaUnidade, HttpStatus.CREATED);
    }

    // --- Endpoint de LEITURA (Read) - Todos ---
    // HTTP GET -> http://localhost:8080/unidades
    @GetMapping
    public ResponseEntity<List<Unidade>> buscarTodasUnidades() {
        List<Unidade> unidades = unidadeService.readUnidadeAll();
        return new ResponseEntity<>(unidades, HttpStatus.OK); // OK (200)
    }

    // --- Endpoint de LEITURA (Read) - Por ID ---
    // HTTP GET -> http://localhost:8080/unidades/5 (por exemplo)
    @GetMapping("/{id}")
    public ResponseEntity<Unidade> buscarUnidadePorId(@PathVariable int id) {
        //  @PathVariable: Pega o 'id' que veio na URL (o '5' do exemplo) e coloca na variável 'int id'
        Unidade unidade = unidadeService.readUnidade(id);
        return new ResponseEntity<>(unidade, HttpStatus.OK);
    }

    // --- Endpoint de ATUALIZAÇÃO (Update) ---
    // HTTP PUT -> http://localhost:8080/unidades
    @PutMapping
    public ResponseEntity<Unidade> atualizarUnidade(@RequestBody Unidade unidade) {
        //  @RequestBody: Pega o JSON com os dados da unidade para atualizar
        Unidade unidadeAtualizada = unidadeService.updateUnidade(unidade);
        return new ResponseEntity<>(unidadeAtualizada, HttpStatus.OK);
    }

    // --- Endpoint de DELEÇÃO (Delete) ---
    // HTTP DELETE -> http://localhost:8080/unidades/5 (por exemplo)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUnidade(@PathVariable int id) {
        //  @PathVariable: Pega o 'id' da URL para saber quem deletar
        unidadeService.deleteUnidade(id);
        //  Para delete, não retornamos conteúdo (void) e status NO_CONTENT (204)
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}