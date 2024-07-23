package com.w3bootstrap.Person.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name="person")
@Table(name="person")
@Data
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id")
    private Long id;

    @Column(name="name" )
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "profile_picture")
    private String profilePicture;
    
    public void setAge(int age){
        if(age >=0 ) {
            this.age=age;
        } else {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
}
