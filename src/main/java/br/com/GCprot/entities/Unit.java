package br.com.GCprot.entities;

import br.com.GCprot.enums.BlockUnit;
import br.com.GCprot.enums.SituationUnit;
import jakarta.persistence.*;

import java.time.Instant;


@Entity
@Table(name = "unit")
public class Unit {

    @Id //
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private BlockUnit block;

    @Enumerated(EnumType.STRING)
    private SituationUnit situation;

    @OneToMany
    @JoinColumn(name = "resident_id")

    private int num;
    private String street;
    private Instant createdAt;
    private Instant updatedAt;

    public Unit() {
    }

    public Unit(int id, int num, String street, BlockUnit block, SituationUnit situation, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.num = num;
        this.street = street;
        this.block = block;
        this.situation = situation;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() { return id; }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public BlockUnit getBlock() {
        return block;
    }

    public void setBlock(BlockUnit block) {
        this.block = block;
    }

    public SituationUnit getSituation() {
        return situation;
    }

    public void setSituation(SituationUnit situation) {
        this.situation = situation;
    }

    public int getNum() { return num; }

    public void setNum(int num) {
        this.num = num;
    }

    public Instant getCreateAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}