package br.com.GCprot.entities;

import br.com.GCprot.enums.Function;
import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descriptionFunction;

    @Enumerated(EnumType.STRING)
    private Function function;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Employee employee;

    public Employee() {
    }

    public Employee(int id, Function function, String descriptionFunction) {
        this.id = id;
        this.function = function;
        this.descriptionFunction = descriptionFunction;
    }

    public int getId() {
        return id;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
         this.function = function;
    }

    public String getDescriptionFunction() {
        return descriptionFunction;
    }

    public void setDescriptionFunction(String descriptionFunction) {
        this.descriptionFunction = descriptionFunction;
    }
}

