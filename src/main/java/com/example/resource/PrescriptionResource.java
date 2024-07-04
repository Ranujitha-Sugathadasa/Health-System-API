/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

import com.example.dao.PrescriptionDAO;
import com.example.model.Prescription;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/prescriptions")

public class PrescriptionResource {

    private static final Logger loggers = Logger.getLogger(PrescriptionResource.class.getName());
    
    private PrescriptionDAO prescriptionDAO = new PrescriptionDAO();


    @GET //Request to get all the prescriptions
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prescription> getAllPrescriptions() {
        return prescriptionDAO.getAllPrescriptions();
    }
    
    
    @GET //Request to get the prescription using id
    @Path("/{patientId}")
    @Produces(MediaType.APPLICATION_JSON) 
    public Response getPrescription(@PathParam("patientId") int id) {
        try {
            Prescription prescription = prescriptionDAO.getPrescription(id);
            if (prescription != null) {
                loggers.log(Level.INFO, "Retrieved prescription successfully");
                return Response.ok().entity(prescription).build();
            } else {
                loggers.log(Level.INFO, "No prescription found for patient ID: ");
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No prescription found for patient ID: " + id).build();
            }
        } catch (NotFoundException ex) {
            loggers.log(Level.SEVERE, "Failed to fetch prescription for patient ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to fetch prescription for patient ID: " + id + ". Please try again later.").build();
        }
    }
    
    @POST //Request to add the prescription using id
    @Consumes(MediaType.APPLICATION_JSON)  
    public Response addPrescription(Prescription prescription) {
        try {
            prescriptionDAO.addPrescription(prescription);
            loggers.log(Level.INFO, "Added new prescription successfully");
            return Response.status(Response.Status.CREATED).entity("Added new prescription successfully").build();
        } catch (Exception ex) {
            loggers.log(Level.SEVERE, "Failed to add prescription", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to add prescription. Please try again later.").build();
        }
    }
    
    @PUT         //Request to update the existing prescription using patient id
    @Path("/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePrescription(@PathParam("patientId") int id, Prescription updatedPrescription) {
        try {
            Prescription existingPrescription = prescriptionDAO.getPrescription(id);

            if (existingPrescription != null) {
                updatedPrescription.setPrescriptionid(id);
                prescriptionDAO.updatePrescription(updatedPrescription);
                return Response.status(Response.Status.OK).entity("Prescription updated Successfully").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Prescription not found for ID: " + id).build();
            }
        } catch (NotFoundException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while updating prescription").build();
        }
    }

    @DELETE
    @Path("/{id}")  //Request to delete the prescription using id
    public Response deletePrescription(@PathParam("id") int id) {
        try {
            prescriptionDAO.deletePrescription(id);
            loggers.log(Level.INFO, "Deleted prescription with ID: {0} successfully", id);
            return Response.ok().entity("Deleted prescription with ID: " + id + " successfully").build();
        } catch (NotFoundException ex) {
            loggers.log(Level.SEVERE, "Failed to delete prescription with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to delete prescription with ID: " + id + ". Please try again later.").build();
        }
    }
}

