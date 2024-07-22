package com.w3bootstrap.Person.Service;

import com.w3bootstrap.Person.Repository.PersonRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

public class PersonService {
    
    @Inject
    PersonRepository repository;

    public List<PersonEntity> getAll(){
        return repository.listAll();
    }

}
