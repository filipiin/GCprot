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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.GCprot.entities.Pessoa;
import br.com.GCprot.repository.PessoaRepository;

@RestController// Diz ao Spring que esta classe é um Controller REST
@RequestMapping("/api/pessoas")// Todas as URLs deste controller começarão com /api/pessoas
public class PessoaController {
    @Autowired // 1. Injeção de Dependência: Pede ao Spring uma instância do PessoaRepository
    private PessoaRepository pessoaRepository;

    @PostMapping // 2. Mapeia este metodo para r equisições HTTP POST em /api/pessoas
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa novaPessoa) {
        // @RequestBody: Pega o JSON enviado no corpo da requisição e transforma em um objeto Pessoa

        Pessoa pessoaSalva = pessoaRepository.save(novaPessoa);

        //Retorna a pessoa salva e um status HTTP 201 (created)
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

}
