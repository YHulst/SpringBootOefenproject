package com.example.demo.controller;

import com.example.demo.model.Animal;
import com.example.demo.model.Person;
import com.example.demo.service.AnimalService;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {
    @Autowired
    AnimalService animalService;

    @Autowired
    PersonService personService;

    @GetMapping(path = "/animal", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Animal>> showAll() {
        Iterable<Animal> animals = animalService.giveAll();
        return new ResponseEntity<>(animals, HttpStatus.OK);
    }

    @GetMapping(path = "/animal/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Animal> showAnimal(@PathVariable Long id) {
        Animal animal = animalService.getById(id);
        return new ResponseEntity<>(animal, HttpStatus.OK);
    }

    @GetMapping(path = "person/{id}/animal", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Animal>>showAllAnimalsOfPerson(@PathVariable Long id){
        Person person = personService.getById(id);
        List<Animal> animals= person.getAnimals();
        return new ResponseEntity<>(animals, HttpStatus.OK);
    }

    @PostMapping(path = "/animal", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> post(@RequestBody Animal a) {
        Animal result = animalService.save(a);
        return new ResponseEntity<String>("POST Response", HttpStatus.OK);
    }

    @DeleteMapping(path = "/animal/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteAnimal(@PathVariable Long id) {
        System.out.println(id);
        animalService.deleteById(id);
        return new ResponseEntity<String>("DELETE Response", HttpStatus.OK);
    }



}
