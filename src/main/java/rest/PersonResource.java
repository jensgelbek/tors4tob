/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import dtos.PersonDTO;
import entites.Person;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author PC
 */
@Path("person")
public class PersonResource extends Provider {

    

   
  
    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) {
        PersonDTO personDTO=REPO.getPersonRepository().getPerson(id);
        return Response.ok(GSON.toJson(personDTO)).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public Response putPerson(String content) {
        PersonDTO personDTO=GSON.fromJson(content,PersonDTO.class);
        PersonDTO personDTO2=REPO.getPersonRepository().addPerson(personDTO.getFirstname(),personDTO.getLastName(),personDTO.getPhone());
       
        return Response.ok(GSON.toJson(personDTO2)).build();
    }

}
