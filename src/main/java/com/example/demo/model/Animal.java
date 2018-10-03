package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "animal")
public class Animal {
    private long id;
    private String name;
    private int age;
    private String species;


    public Animal() {
    }

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    @Column(name="animal_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}