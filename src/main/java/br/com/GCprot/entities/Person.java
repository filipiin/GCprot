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
@Table(name = "pessoa")

public class Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date data_nascimento; //Long ou int?
    private String name;
    private String email;
    private String password;

    public Person() {
    }

    public Person(int id, String name, String email, String password, Instant createAt, Instant updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
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
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

}
