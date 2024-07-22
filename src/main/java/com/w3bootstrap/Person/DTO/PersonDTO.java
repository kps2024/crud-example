package com.w3bootstrap.Person.DTO;

import org.jboss.resteasy.reactive.multipart.FileUpload;
import lombok.Data;

@Data
public class PersonDTO {
    private Long id;
    private String name;
    private FileUpload profilePhoto;
}
