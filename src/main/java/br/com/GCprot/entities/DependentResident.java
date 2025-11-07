package br.com.GCprot.entities;

import br.com.GCprot.enums.ClassificationDependent;
import jakarta.persistence.*;

@Entity
@Table(name = "dependent_resident")
public class DependentResident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private ClassificationDependent classification;

    @OneToOne
    @JoinColumn(name = "person_id")

    @ManyToOne
    @JoinColumn(name = "resident_id")
    private DependentResident dependent;

    public DependentResident() {
    }

    public DependentResident(int id, ClassificationDependent classification) {
        this.id = id;
        this.classification = classification;
    }

    public int getId() {
        return id;
    }

    public ClassificationDependent getClassification() {
        return classification;
    }

    public void setClassificationDependent(ClassificationDependent classification) {
        this.classification = classification;
    }
}
