/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.example.dao.MedicalRecordDAO;
import com.example.model.MedicalRecord;
import java.util.logging.Level;
import java.util.logging.Logger;


@Path("/medical")
public class MedicalRecordResource {
    
    private static final Logger logger = Logger.getLogger(MedicalRecordResource.class.getName());
    private MedicalRecordDAO medicalDAO = new MedicalRecordDAO();
    
    //Requesting to get the information of all the Medical Records in the system
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MedicalRecord> getAllMedicals() {
        try {
            logger.log(Level.INFO, "Retrieved all medicals successfully");
            return medicalDAO.getAllMedicals();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Failed to fetch medicals", ex);
            throw new WebApplicationException("Error occurred while getting all medical records", ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    //Requesting to get the information of one specific Medical Record using the Patient Number
    @GET
    @Path("/{patientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicalRecord getMedicalByPatient(@PathParam("patientId") int id) {
        try {
            logger.log(Level.INFO, "Retrieved medical record with ID {0} successfully", id);
            return medicalDAO.getMedicalByPatient(id);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Failed to fetch medicals", ex);
            throw new WebApplicationException("Error occurred while getting medical record for patient with ID: " + id, ex, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    
    // Adding a new Medical to the system
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMedical(MedicalRecord medical) {
        try {
            medicalDAO.addMedical(medical);
            logger.log(Level.INFO, "Added medical record successfully");
            return Response.status(Response.Status.CREATED).entity("Medical added Successfully").build();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Failed to add medicals", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while adding medical record").build();
        }
    }

    
    
    // Removing a medical Record from the system using the patient ID
    @DELETE
    @Path("/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteMedical(@PathParam("patientId") int id) {
        try {
            medicalDAO.deleteMedical(id);
            logger.log(Level.INFO, " medical record deleted successfully");
            return Response.status(Response.Status.CREATED).entity("Medical deleted Successfully").build();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Failed to delete medicals", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while deleting medical record").build();
        }
    }

    //Requesting to get the details of a Medical Record
    @PUT
    @Path("/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMedical(@PathParam("patientId") int id, MedicalRecord updatedMedical) {
        try {
            MedicalRecord existingMedical = medicalDAO.getMedicalByPatient(id);

            if (existingMedical != null) {
                updatedMedical.setPatientNo(id);
                medicalDAO.updateMedical(updatedMedical);
                logger.log(Level.INFO, " medical record added successfully");
                return Response.status(Response.Status.OK).entity("Medical updated Successfully").build();
            } else {
                logger.log(Level.SEVERE, "Failed to update medicals");
                return Response.status(Response.Status.NOT_FOUND).entity("Medical record not found for patient with ID: " + id).build();
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Failed to update medicals", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while updating medical record").build();
        }
    }
    
}

