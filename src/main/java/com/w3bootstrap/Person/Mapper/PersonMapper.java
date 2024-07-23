package com.w3bootstrap.Person.Mapper;


import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.w3bootstrap.Person.DTO.PersonDTO;
import com.w3bootstrap.Person.Entity.PersonEntity;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PersonMapper {
    
    //@Mapping(target = "id", ignore = true)
    PersonEntity toEntity(PersonDTO personDTO);

    //@Mapping(target = "id", ignore = true)
    PersonDTO toDTO(PersonEntity entity);

    /**
     * @param personDTOList
     * @return
     */
    @Mapping(target = "id", ignore = true)
    List<PersonEntity> toEntityList(List<PersonDTO> personDTOList);

    @Mapping(target = "id", ignore = true)
    List<PersonDTO> toPersonDTOList(List<PersonEntity> personEntityList);
}
