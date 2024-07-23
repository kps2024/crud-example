package com.w3bootstrap.Person.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.jboss.resteasy.reactive.multipart.FileUpload;

import com.w3bootstrap.Person.AppForm.PersonForm;
import com.w3bootstrap.Person.Common.ErrorResponse;
import com.w3bootstrap.Person.Entity.PersonEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class PersonRepository implements PanacheRepositoryBase<PersonEntity, Long> {
    public Response formFileUpload(FileUpload uploadedFile){
        // Retrieve the original filename
        String originalFilename = uploadedFile.fileName();

        // Generate a UUID for the new filename
        String uuid = UUID.randomUUID().toString();
        String newFilename = uuid + "_" + originalFilename;

        // Define the directory where you want to save the file
        String uploadDir = "/tmp"; // Change this to your actual directory
        Path uploadPath = Paths.get(uploadDir);

        // Create the directory if it doesn't exist
        try {
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
        } catch (IOException e) {
            //e.printStackTrace();
            ErrorResponse errorResponse = new ErrorResponse("Failed to upload marksheet: " + e.getMessage(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorResponse).build();
        }

        // Save the file with the new UUID filename
        Path filePath = uploadPath.resolve(newFilename);
        try {
            Files.copy(uploadedFile.uploadedFile().toAbsolutePath(), filePath);
            return Response.status(Response.Status.ACCEPTED).build();
        } catch (IOException e) {
            e.printStackTrace();
            ErrorResponse errorResponse = new ErrorResponse("Failed to upload marksheet: " + e.getMessage(), Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorResponse).build();
        }

        

    }
}
