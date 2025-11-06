package br.com.GCprot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// import java.time.Instant; // Não estamos usando por enquanto

@Entity // 💡 Avisa ao JPA que esta classe é uma tabela
@Table(name = "unidade") // 💡 Define o nome da tabela no MySQL
public class Unit {

    @Id // 💡 Avisa que ESTE é o campo de Chave Primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 💡 Pede ao MySQL para autoincrementar o valor (1, 2, 3...)
    private int id; // ✅ O ID deve ser numérico para usar IDENTITY

    private String proprietario;
    private String rua;
    private int quadrante;
    private int numUnidade;
    private int situacao;

    // Construtor, createAt e updatedAt removidos por enquanto para simplificar

    // 💡 IMPORTANTE: Construtor padrão (vazio) exigido pelo JPA
    public Unit() {
    }

    // Getters e Setters (agora corretos)

    public int getId() {
        return id;
    }

    // Não precisamos de um setId(), pois o banco vai gerenciá-lo

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public int getQuadrante() {
        return quadrante;
    }

    public void setQuadrante(int quadrante) { // ✅ Corrigido para retornar 'void'
        this.quadrante = quadrante;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) { // ✅ Corrigido para retornar 'void'
        this.situacao = situacao;
    }

    public int getNumUnidade() {
        return numUnidade;
    }

    public void setNumUnidade(int numUnidade) {
        this.numUnidade = numUnidade;
    }
}