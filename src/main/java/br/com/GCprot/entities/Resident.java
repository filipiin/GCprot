package br.com.GCprot.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "resident")
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Resident() {
    }

    public Resident(int id, Person person) {
        this.id = id;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setResident(Person person) {
        this.person = person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

