package com.w3bootstrap.Person.Repository;

import com.w3bootstrap.Person.Entity.PersonEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonRepository implements PanacheRepositoryBase<PersonEntity, Long> {
    
}
