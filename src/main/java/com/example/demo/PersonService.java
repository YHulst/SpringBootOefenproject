package com.example.demo;

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

    public Person save(Person p) {
        return personRepository.save(p);
    }
}