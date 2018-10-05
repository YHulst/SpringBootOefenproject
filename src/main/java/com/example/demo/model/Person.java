package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="person")

public class Person {

    @Id
    //  @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    @Column(name="person_id")
    private long id;
    private String name;
    private int age;
    private String hobby;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    @MapKey(name = "animal_id")
    private List<Animal> animals = new ArrayList<>();

    public Person(int id, String name, int age, String hobby){
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public Person(){}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

  //  @Column(name="name")
    public void setName(String name) {
        this.name = name;
    }

 //   @Column(name="age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

 //   @Column(name="hobby")
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
        animal.setPerson(this);
    }
}
