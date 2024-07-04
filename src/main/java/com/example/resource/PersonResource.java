/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

import com.example.dao.PersonDAO;
import com.example.exception.UserNotFoundException;
import com.example.model.Person;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    private static final Logger logger = Logger.getLogger(PersonResource.class.getName());
    private PersonDAO personDAO = new PersonDAO();

    @GET // Request to get all persons
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersons() {
        try {
            logger.log(Level.INFO,"Retrieved all persons successfully");
            return personDAO.getAllPersons();
        } catch (Exception ex) {
            logger.log(Level.INFO,"Failed to fetch persons",ex);
            throw new WebApplicationException("Error occurred while getting all people", ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    
    @POST  //Request add a new person using details
    public Response addPerson(Person person) {
        personDAO.addPerson(person);
        return Response.status(Response.Status.CREATED).entity("Person added successfully").build();
    }

    @GET  //Request to get a person details using person id
    @Path("/{ID}") 
    public Response getPerson(@PathParam("ID") int id) {
        try {
            Person person = personDAO.getPerson(id);
            logger.log(Level.INFO, "Retrieved person with ID {0} successfully", id);
            return Response.ok(person).build();
        } catch (UserNotFoundException e) {
            logger.log(Level.INFO,"Failed to get the person",e);
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @PUT //Request to update person  using person id
    @Path("/{ID}") 
    public Response updatePerson(@PathParam("ID") int id, Person updatedPerson) {
        try {
            personDAO.updatePerson(id, updatedPerson);
            logger.log(Level.INFO,"Person updated successfully");
            return Response.ok().entity("Person updated successfully").build();
        } catch (UserNotFoundException e) {
            logger.log(Level.INFO,"Person not found for ID: ",e);
            return Response.ok().entity("Person not found for ID: " + id).build();
        }
    }

    @DELETE //Request to delete a person using person id 
    @Path("/{ID}") 
    public Response deletePerson(@PathParam("ID") int id) {
        try {
            personDAO.deletePerson(id);
            logger.log(Level.INFO,"person successfully deleted");
            return Response.ok().entity("person with Id "+ id + " successfully deleted").build();
        } catch (UserNotFoundException e) {
            logger.log(Level.INFO,"Person not found for ID: ",e);
            return Response.ok().entity("Person not found for ID: " + id).build();
        }
    }
}

