package br.com.GCprot.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.Instant;

public class Ocorrencia {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String pessoaassociada;
        private String descricao;
        private int id; //Long ou int?


    public Ocorrencia() {
    }

    public Ocorrencia(int id, int numero, String pessoaassociada, Instant createAt, Instant updatedAt) {
        this.id = id;
        this.descricao = descricao;
        this.pessoaassociada = pessoaassociada;
    }
        public int getId() {
        return id;
    }
        public String getPessoaassociada() {
        return pessoaassociada;
    }
        public void setPessoaassociada(String pessoaassociada) {
        this.pessoaassociada = pessoaassociada;
    }
        public String getDescricao() {
        return descricao;
    }
        public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
