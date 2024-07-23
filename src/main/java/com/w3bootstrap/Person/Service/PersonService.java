package com.w3bootstrap.Person.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import com.w3bootstrap.Person.AppForm.PersonForm;
import com.w3bootstrap.Person.Common.ErrorResponse;
import com.w3bootstrap.Person.DTO.PersonDTO;
import com.w3bootstrap.Person.Entity.PersonEntity;
import com.w3bootstrap.Person.Mapper.PersonMapper;
import com.w3bootstrap.Person.Repository.PersonRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class PersonService {
    
    @Inject
    PersonRepository repository;

    @Inject
    PersonMapper mapper;    
    
    /** 
     * @return List<PersonDTO>
     */
    public List<PersonDTO> getAll(){
        List<PersonEntity> entities =  repository.listAll();
        return mapper.toPersonDTOList(entities);
    }

    public PersonDTO create(PersonDTO dto) {
        PersonEntity entity = mapper.toEntity(dto);
        repository.persist(entity);       
        return mapper.toDTO(entity);
    }

    public Response formEntry(PersonForm formData) throws IOException {
        // Get the uploaded file
        FileUpload uploadedFile = formData.getProfilePicture();

        repository.formFileUpload(uploadedFile);


    }

}
