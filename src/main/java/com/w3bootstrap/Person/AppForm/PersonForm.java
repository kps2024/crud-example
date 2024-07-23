package com.w3bootstrap.Person.AppForm;

import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import lombok.Data;

@Data
public class PersonForm {
    
    @RestForm("name")
    private String name;
    
    @RestForm("age")
    private int age;
    
    @RestForm("profile_picture")
    private FileUpload profilePicture;
}
