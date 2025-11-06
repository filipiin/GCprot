package br.com.GCprot.entities;

import br.com.GCprot.enums.TypeOccurrance;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "occurrence")

public class Occurrence {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String description;
        private int typeoccurrance;

        @Enumerated(EnumType.STRING)
        private TypeOccurrance typeoccurrance;


    public Occurrence() {
    }

    public Occurrence(int id, TypeOccurrance typeoccurrance, String description, Instant createAt, Instant updatedAt) {
        this.id = id;
        this.description = description;
        this.typeoccurrance = typeoccurrance;
    }
    public Integer getId() {
        return id;
    }
        public String getDescription() {
        return description;
    }
        public void setDescription(String description) {
        this.description = description;
    }
    public String getTypeOccurrance() {
        return typeoccurrance();
    }
    public void setTypeOccurrance(int typeoccurrance) {
        this.typeoccurrance = typeoccurrance;
    }

}
