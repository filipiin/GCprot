package br.com.GCprot.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.Instant;

public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String tipoinventario;
    private int id;
    private int[] itensinventario;

    public Inventario(String tipoinventario, int id, int itensinventario,Instant createAt, Instant updatedAt) {
        this.id = id;
        this.tipoinventario = tipoinventario;
        this.itensinventario = itensinventario;

            }
            public int getId() {
                return id;
            }
            public String getTipoinventarioItem() {
                return tipoinventario;
            }
            public void setTipoinventario(String tipoinventario) {
                this.tipoinventario = tipoinventario;
            }

}
