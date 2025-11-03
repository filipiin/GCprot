package br.com.GCprot.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.Instant;

public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String item;
    private String descricaoitem;
    private int situacaoitem;
    private int id;
    private float valoritem;

    public Inventario() {
    }

    public Inventario(String item, String descricaoitem, float valoritem, int situacaoitem, Instant createAt, Instant updatedAt) {
        this.id = id;
        this.situacaoitem = situacaoitem;
        this.item = item;
        this.descricaoitem = descricaoitem;
        this.valoritem = valoritem;
    }
    public int getId() {
        return id;
    }
    public String getDescricaoItem() {
        return descricaoitem;
    }
    public void setDescricaoItem(String descricaoitem) {
        this.descricaoitem = descricaoitem;
    }
    public String getItem() {
        return descricaoitem;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public float getValorItem() {
        return valoritem;
    }
    public void setValorItem(float valoritem) {
        this.valoritem = valoritem;
    }
    public int getSituacaoItem() {
        return situacaoitem;
    }
    public void setSituacaoItem(int situacaoitem) {
        this.situacaoitem = situacaoitem;
    }
}
