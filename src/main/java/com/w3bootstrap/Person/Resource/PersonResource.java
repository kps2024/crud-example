package com.w3bootstrap.Person.Resource;

import java.util.List;

import com.w3bootstrap.Person.DTO.PersonDTO;
import com.w3bootstrap.Person.Service.PersonService;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@ApplicationPath("/api")
@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class PersonResource {

    @Inject
    PersonService service;

    @GET
    public List<PersonDTO> getAll(){
        return service.getAll();
        
    }

    @POST
    public Response createPerson(){
        return Response.status(Response.Status.CREATED).entity(service.createPerson()).build();
    }
}
