package br.com.GCprot.entities;
// Spring Data JPA(Java Persistence API)
// Ao criar classes Java (Ex: Pessoa.java) e as anota com @Entity.
// Isso diz ao JPA: "Esta classe representa uma tabela no banco".
// Você cria interfaces (Ex: PessoaRepository) que estendem JpaRepository
// O Spring Data JPA automaticamente cria os métodos para você (como save(), findById(), findAll(), etc.).

import br.com.GCprot.enums.TypeTitle;
import br.com.GCprot.enums.SituationTitle;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "title")

public class Title
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float value;
    private Date vality; //Long ou int?
    private String description;
    private Instant createdAt;
    private Instant updatedAt;

    @Enumerated(EnumType.STRING)
    private SituationTitle situation;

    @Enumerated(EnumType.STRING)
    private TypeTitle type;

    public Title() {
    }

    public Title(int id, float value, Date vality, String description, SituationTitle situation, TypeTitle type, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.value = value;
        this.vality = vality;
        this.description = description;
        this.situation = situation;
        this.type = type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public int getId() {
        return id;
    }
    public float getvalue(){
        return value;
    }
    public void setValue(float value){
        this.value = value;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){ this.description = description; }
    public Date getVality(){
        return vality;
    }
    public void setVality(Date vality){
        this.vality = vality;
    }
    public SituationTitle getSituation(){
        return situation;
    }
    public void setSituation(SituationTitle situation){
        this.situation = situation;
    }
    public TypeTitle getType(){
        return type;
    }
    public void setType(TypeTitle type){
        this.type = type;
    }
    public Instant getCreateAt() {
        return createdAt;
    }
    public Instant getUpdatedAt() {
        return updatedAt;
    }
}

