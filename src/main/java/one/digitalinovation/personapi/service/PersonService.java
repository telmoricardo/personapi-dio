package one.digitalinovation.personapi.service;

import one.digitalinovation.personapi.dto.MessagemResponseDTO;
import one.digitalinovation.personapi.entity.Person;
import one.digitalinovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessagemResponseDTO createPerson(Person person){
        Person personSaved = personRepository.save(person);
        return MessagemResponseDTO.builder()
                .message("Created person with Id " + personSaved.getId())
                .build();
    }
}
