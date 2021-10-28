package one.digitalinovation.personapi.service;

import one.digitalinovation.personapi.dto.MessagemResponseDTO;
import one.digitalinovation.personapi.dto.request.PersonDTO;
import one.digitalinovation.personapi.entity.Person;
import one.digitalinovation.personapi.exception.PersonNotFoundException;
import one.digitalinovation.personapi.mapper.PersonMapper;
import one.digitalinovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }



    public MessagemResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);
        Person personSaved = personRepository.save(personToSave);

        return MessagemResponseDTO.builder()
                .message("Created person with Id " + personSaved.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream().map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        //Optional<Person> optionalPerson = personRepository.findById(id);

        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        /*if(optionalPerson.isEmpty()){
            throw new PersonNotFoundException(id);
        }*/
        return personMapper.toDTO(person);
    }
}
