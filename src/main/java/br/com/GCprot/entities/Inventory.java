package br.com.GCprot.entities;

import br.com.GCprot.enums.InventoryType;
import jakarta.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false) // <-- Boa prática: nome não deve ser nulo
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false) // <-- Boa prática: tipo não deve ser nulo
    private InventoryType type;

    @OneToMany
    @JoinColumn(name = "item_inventory")

    private Instant createdAt;
    private Instant updatedAt;

    public Inventory() {
    }

    public Inventory(int id, String name, InventoryType type, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InventoryType getType() {
        return type;
    }

    public void setInventoryType(InventoryType type) {
        this.type = type;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setId(int id) {
    }

}