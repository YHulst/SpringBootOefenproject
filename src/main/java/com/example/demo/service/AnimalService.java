package com.example.demo.service;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.Animal;
import com.example.demo.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AnimalService {
    @Autowired
    AnimalRepository animalRepository;

    public Iterable<Animal> giveAll() {
        return animalRepository.findAll();
    }

    public Animal getById(Long id) throws EntityNotFoundException {
        Animal a = animalRepository.findById(id).orElse(null);
        if (a == null){
            throw new EntityNotFoundException("Animal with id " + id + " not found.");
        }
        return a;
    }

    public Animal save(Animal p) {
        return animalRepository.save(p);
    }

    public void deleteById(long id) { animalRepository.deleteById(id); }

}
