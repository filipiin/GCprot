package br.com.GCprot.entities;

import br.com.GCprot.enums.SituationItem;
import com.fasterxml.jackson.annotation.JsonBackReference; // <-- Importante para Spring Web
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "item_inventory")
public class ItemInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    @Enumerated(EnumType.STRING)
    private SituationItem situation;
    private String name;
    private String description;
    private int quantity;
    private float value;
    private Instant createdAt;
    private Instant updatedAt;


    public ItemInventory() {
    }


    public ItemInventory(int id, String name, String description, int quantity, SituationItem situation, float value) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.value = value;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
        this.situation = situation;
    }
        public int getId () {
            return id;
        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }

        public SituationItem getSituation () {
            return situation;
        }

        public void setSituation (SituationItem situation){
            this.situation = situation;
        }

        public String getDescription () {
            return description;
        }

        public void setDescription (String description){
            this.description = description;
        }

        public int getQuantity () {
            return quantity;
        }

        public void setQuantity ( int quantity){
            this.quantity = quantity;
        }

        public float getValue () {
            return value;
        }

        public void setValue ( float value){
            this.value = value;
        }

        public Instant getUpdatedAt () {
            return updatedAt;
        }

        public Instant getCreatedAt () {
            return createdAt;
        }
}