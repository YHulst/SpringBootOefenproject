package com.example.demo.controller;

import com.example.demo.model.Animal;
import com.example.demo.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {
    @Autowired
    AnimalService animalService;

    @GetMapping(path = "/animal", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Animal>> showAll() {
        Iterable<Animal> animals = animalService.giveAll();
        return new ResponseEntity<>(animals, HttpStatus.OK);
    }

}
