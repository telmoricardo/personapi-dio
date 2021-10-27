package one.digitalinovation.personapi.controller;

import one.digitalinovation.personapi.dto.MessagemResponseDTO;
import one.digitalinovation.personapi.entity.Person;
import one.digitalinovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {


    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessagemResponseDTO createPerson(@RequestBody Person person){
        Person personSaved = personRepository.save(person);
        return MessagemResponseDTO.builder()
                .message("Created person with Id " + personSaved.getId())
                .build();
    }
}
