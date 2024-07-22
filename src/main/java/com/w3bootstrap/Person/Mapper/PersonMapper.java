package com.w3bootstrap.Person.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.w3bootstrap.Person.DTO.PersonDTO;
import com.w3bootstrap.Person.Entity.PersonEntity;

@Mapper
public interface PersonMapper {
    
    @Mapping(source = "id", ignore = true, target = "")
    PersonEntity Entity(PersonDTO personDTO);

    PersonDTO DTO(PersonEntity entity);
}
