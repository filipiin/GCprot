// Spring Data JPA(Java Persistence API)
// Ao criar classes Java (Ex: Pessoa.java) e as anota com @Entity.
// Isso diz ao JPA: "Esta classe representa uma tabela no banco".
// Você cria interfaces (Ex: PessoaRepository) que estendem JpaRepository
// O Spring Data JPA automaticamente cria os métodos para você (como save(), findById(), findAll(), etc.).

package br.com.GCprot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "person")

public class Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cpf;
    private Date dateOfBith; //Long ou int?
    private String name;
    private String email;
    private Instant createdAt;
    private Instant updatedAt;

    public Person() {
    }

    public Person(int id, int cpf, Date dateOfBith, String name, String email, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.cpf = cpf;
        this.dateOfBith = dateOfBith;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getCpf(){
        return cpf;
    }
    public void setCpf(int cpf){ this.cpf = cpf; }
    public Date getDateOfBith(){
        return dateOfBith;
    }
    public void setDateOfBith(Date dateOfBith){
        this.dateOfBith = dateOfBith;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public Instant getCreateAt() {
        return createdAt;
    }
    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
