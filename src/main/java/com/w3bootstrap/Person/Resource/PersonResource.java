package com.w3bootstrap.Person.Resource;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.reactive.MultipartForm;
import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;

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

public class PersonResource {

    @Inject
    PersonService service;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonDTO> getAll(){
        return service.getAll();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(PersonDTO dto) {
        return Response.status(Response.Status.ACCEPTED).entity(service.create(dto)).build();
    }

    @POST
    @Transactional
    @Path("/formentry")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @RequestBody(content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA, schema = @Schema(implementation = PersonForm.class)))
    public String formEntry(PersonForm formData) {
        if(service.formEntry(formData)){
            return "success";
        } else {
            return "failed";
        }

        //return Response.status(service.formEntry(formData) ? Response.Status.ACCEPTED : Response.Status.BAD_GATEWAY).build();
    }
}
