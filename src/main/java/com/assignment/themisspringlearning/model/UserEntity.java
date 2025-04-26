package com.assignment.themisspringlearning.model;


import jakarta.persistence.*;

@Entity
public class UserEntity {


    String name;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;
    public UserEntity(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public UserEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
