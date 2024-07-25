package com.w3bootstrap.Person.Service;


import java.util.List;


import org.jboss.resteasy.reactive.multipart.FileUpload;

import com.w3bootstrap.Person.AppForm.PersonForm;

import com.w3bootstrap.Person.Common.FileUploadResponse;
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

    public Boolean formEntry(PersonForm formData){
        // Get the uploaded file
        FileUpload profilePicture = formData.profilePicture;
        FileUpload document = formData.document;

        FileUploadResponse _profilePicture = repository.formFileUpload(profilePicture);
        FileUploadResponse _document = repository.formFileUpload(document);
        
        if(_profilePicture.isSuccess() & _document.isSuccess()) {
            PersonEntity entity = new PersonEntity();
            entity.setName(formData.name);
            entity.setAge(formData.age);
            entity.setProfilePicture(_profilePicture.getFilename());
            entity.setDocument(_document.getFilename());
            repository.persist(entity);
        } else {
            return false;
        }
        return true;
    }

}
