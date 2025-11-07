package br.com.GCprot.services; // Corrigido para GCprot

import java.util.List;

import br.com.GCprot.entities.Person;
import br.com.GCprot.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired; // Import necessário
import org.springframework.stereotype.Service; // Import necessário

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(Person newPerson) {
        return personRepository.save(newPerson);
    }

    public Person updatePerson(Person personUpdated) {
        Person personBank = personRepository.findById(personUpdated.getId())
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar usuário para atualizar"));
        personBank.setName(personUpdated.getName());
        personBank.setCpf(personUpdated.getCpf());
        personBank.setDateOfBith(personUpdated.getDateOfBith());
        personBank.setEmail(personUpdated.getEmail());

        return personRepository.save(personBank);
    }

    @Transactional
    public boolean deletePerson(int personId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar usuário para deletar"));
        personRepository.delete(person);
        return true;
    }

    public Person readPerson(int personId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar usuário para ler"));
        return person;
    }

    public List<Person> readPersonAll() {
        return personRepository.findAll();
    }
}
// A chave extra foi removida