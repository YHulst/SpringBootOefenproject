package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
public class PersonController {
    ArrayList<Person> personen;

    @Autowired
    PersonService personService;


    public PersonController() {
        personen = new ArrayList<Person>();
        personen.add(new Person(1, "Piet", 30, "zwemmen"));
        personen.add(new Person(2, "Anna", 22, "korfbal"));
        personen.add(new Person(3, "Hans", 46, "auto's"));
        personen.add(new Person(4, "Kim", 56, "kaarten"));
        personen.add(new Person(5, "Klaas", 28, "wielrennen"));
        personen.add(new Person(6, "Lieke", 41, "voetbal"));
        personen.add(new Person(7, "Arjan", 35, "tuinieren"));
        personen.add(new Person(8, "Wouter", 47, "vissen"));
        personen.add(new Person(9, "Liza", 23, "zingen"));
        personen.add(new Person(10, "Martha", 81, "klaverjassen"));
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", required = false) String name) {
        if (name != null) {
            return "Hello " + name + "!";
        } else {
            return "Hello!";
        }
    }

    @GetMapping("/doei/{name}")
    public String sayDoei(@PathVariable String name) {
        return "Doei " + name + "!";
    }

    @GetMapping(path = "/objects/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> stuurObject(@PathVariable Integer id) {
        Person pers = null;
        for (Person object : personen) {
            if (object.getId() == id) {
                pers = object;
            }
        }
        return new ResponseEntity<>(pers, HttpStatus.OK);
    }

    @GetMapping(path = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Person>> toonAllen() {
        Iterable<Person> events = personService.geefAllen();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping(path = "/person/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> toonPersoon(@PathVariable Long id) {
        Person pers = personService.getById(id);
        return new ResponseEntity<>(pers, HttpStatus.OK);
    }

    @PostMapping(path = "/person", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> post(@RequestBody Person p) {
        Person result = personService.save(p);
        return new ResponseEntity<String>("POST Response", HttpStatus.OK);
    }

    @DeleteMapping(path = "/person/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        System.out.println(id);
        personService.deleteById(id);
        return new ResponseEntity<String>("DELETE Response", HttpStatus.OK);
    }
}

