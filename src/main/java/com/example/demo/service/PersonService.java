package com.example.demo.service;

import com.example.demo.exception.PersonNotFoundException;
import com.example.demo.model.Animal;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Iterable<Person> geefAllen() {
        return personRepository.findAll();
    }

    public Person getById(Long id) {
        Person p = personRepository.findById(id).orElse(null);
        if (p == null){
            throw new PersonNotFoundException("Person with id " + id + " not found.");
        }
        return p;
    }

    public Person save(Person p) {
        return personRepository.save(p);
    }

    public void deleteById(long id) {
        personRepository.deleteById(id);
    }

    public void addAnimaltoPerson(Animal animal, Person person) {
        person.addAnimal(animal);
    }

}
