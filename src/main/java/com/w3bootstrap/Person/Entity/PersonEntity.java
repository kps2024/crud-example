package com.w3bootstrap.Person.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name="person")
@Table(name="person")
@Data
public class PersonEntity {

    @Id
    private Long id;

    @Column(name="name" )
    private String name;

    @Column(name = "profile_picture")
    private String profilePicture;
    
}
