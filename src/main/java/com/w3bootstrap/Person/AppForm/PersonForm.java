package com.w3bootstrap.Person.AppForm;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.jboss.logging.annotations.Field;
import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import jakarta.ws.rs.core.MediaType;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data
// @NoArgsConstructor
public class PersonForm {
    
    @RestForm("name")
    public String name;
    
    @RestForm("age")
    public int age;
    
    @RestForm
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    @Schema(type = SchemaType.STRING, format = "binary", description = "Uploaded image file", implementation = String.class)
    public FileUpload profilePicture;
}
