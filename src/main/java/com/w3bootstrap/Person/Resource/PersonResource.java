package com.w3bootstrap.Person.Resource;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;


import com.w3bootstrap.Person.AppForm.PersonForm;
import com.w3bootstrap.Person.DTO.PersonDTO;
import com.w3bootstrap.Person.Service.PersonService;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@RequestScoped
@ApplicationPath("/api")
@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    PersonService service;

    @GET
    public List<PersonDTO> getAll(){
        return service.getAll();
        
    }

    @POST
    @Transactional
    public Response create(PersonDTO dto) {
        return Response.status(Response.Status.ACCEPTED).entity(service.create(dto)).build();
    }

    @POST
    @Transactional
    @Path("/formentry")
    @RequestBody(content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA, schema = @Schema(implementation = PersonForm.class)))
    public Response formEntry(PersonForm formData) {
        return Response.status(Response.Status.ACCEPTED).entity(service.formEntry(formData)).build();
    }

}
