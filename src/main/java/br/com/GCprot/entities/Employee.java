package br.com.GCprot.entities;

import br.com.GCprot.enums.Function;
import com.fasterxml.jackson.annotation.JsonManagedReference; // <-- Importante para Spring Web
import jakarta.persistence.*;


@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false) // <-- Boa prática: tipo não deve ser nulo
    private Function function;

    // <-- CORREÇÃO: Mapeamento One-to-Many
    @OneToOne(
            mappedBy = "person", // <-- Diz ao JPA: "A classe ItemInventory gerencia essa relação através do campo 'inventory'"
    )
    @JsonManagedReference // <-- Evita loop infinito ao converter para JSON (para sua API Spring Web)
    private List<ItemInventory> items = new ArrayList<>();

    private Instant createdAt;
    private Instant updatedAt;

    // <-- CORREÇÃO: Construtor vazio OBRIGATÓRIO para o JPA
    public Inventory() {
    }

    // Construtor principal otimizado (sem ID, createdAt, updatedAt)
    public Inventory(String nameInventory, InventoryType type) {
        this.nameInventory = nameInventory;
        this.type = type;
    }

    // <-- OTIMIZAÇÃO: Gerenciamento automático de datas
    @PrePersist
    protected void onCreate() {
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Instant.now();
    }

    // --- Métodos Auxiliares (Boa Prática) ---
    // Para manter os dois lados da relação sincronizados

    public void addItem(ItemInventory item) {
        items.add(item);
        item.setInventory(this);
    }

    public void removeItem(ItemInventory item) {
        items.remove(item);
        item.setInventory(null);
    }

    // --- Getters e Setters ---

    public int getId() {
        return id;
    }

    public String getNameInventory() {
        return nameInventory;
    }

    public void setNameInventory(String nameInventory) {
        this.nameInventory = nameInventory;
    }

    // <-- CORREÇÃO: Faltava o tipo de retorno
    public InventoryType getInventoryType() {
        return type;
    }

    public void setInventoryType(InventoryType type) {
        this.type = type;
    }

    public List<ItemInventory> getItems() {
        return items;
    }

    public void setItems(List<ItemInventory> items) {
        this.items = items;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    // Removido setCreatedAt (deve ser gerenciado pelo @PrePersist)

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    // Removido setUpdatedAt (deve ser gerenciado pelo @PrePersist/@PreUpdate)
}
public class Employee {
}
