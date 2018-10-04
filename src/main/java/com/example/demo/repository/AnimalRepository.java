package com.example.demo.repository;

import com.example.demo.model.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends CrudRepository <Animal, Long> {

}
