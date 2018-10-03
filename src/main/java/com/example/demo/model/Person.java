package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="person")

public class Person {
    private long id;
    private String name;
    private int age;
    private String hobby;

    public Person(int id, String name, int age, String hobby){
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public Person(){}

    @Id
  //  @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    @Column(name="person_id")
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


}