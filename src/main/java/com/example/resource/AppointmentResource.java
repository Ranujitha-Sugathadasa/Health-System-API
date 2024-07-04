package com.example.resource;

import com.example.dao.AppointmentDAO;
import com.example.model.Appointment;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/appointments")
public class AppointmentResource {

    private static final Logger LOGGER = Logger.getLogger(AppointmentResource.class.getName());
    private AppointmentDAO appointmentDAO = new AppointmentDAO();

    @GET //Request to get all appointments 
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAppointments() {
        try {
            List<Appointment> appointments = appointmentDAO.getAllAppointments();
            LOGGER.log(Level.INFO, "Retrieved all appointments successfully");
            return Response.ok().entity(appointments).build();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Failed to fetch appointments", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to fetch appointments. Please try again later.").build();
        }
    }

    @GET   //Request to get existing appointment using patient id
    @Path("/{appointmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAppointmentById(@PathParam("appointmentId") int appointmentId) {
        try {
            Appointment appointment = appointmentDAO.getAppointmentById(appointmentId);
            if (appointment != null) {
                LOGGER.log(Level.INFO, "Retrieved appointment with ID: {0} successfully", appointmentId);
                return Response.ok().entity(appointment).build();
            } else {
                LOGGER.log(Level.INFO, "Appointment with ID: {0} not found", appointmentId);
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Appointment with ID: " + appointmentId + " not found").build();
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Failed to fetch appointment with ID: " + appointmentId, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to fetch appointment with ID: " + appointmentId + ". Please try again later.").build();
        }
    }

    @POST  //Request to add a new appointment
    public Response addAppointment(Appointment appointment) {
        try {
            appointmentDAO.addAppointment(appointment);
            LOGGER.log(Level.INFO, "Added new appointment successfully");
            return Response.status(Response.Status.CREATED).entity("Added new appointment successfully").build();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Failed to add appointment", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to add appointment. Please try again later.").build();
        }
    }

    @PUT   //Request to update existing appointment using appointment id
    @Path("/{appointmentId}")
    public Response updateAppointment(@PathParam("appointmentId") int appointmentId, Appointment updatedAppointment) {
          try {
            Appointment existingAppointment = appointmentDAO.getAppointmentById(appointmentId);

            if (existingAppointment != null) {
                updatedAppointment.setAppointmentId(appointmentId);
                appointmentDAO.updateAppointment(updatedAppointment);
                return Response.status(Response.Status.OK).entity("Appoinment updated Successfully").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Appointment not found for ID: " +appointmentId).build();
            }
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred while updating appointment").build();
        }
    }

    @DELETE //Request to delete a appointment using appointment id
    @Path("/{appointmentId}")
    public Response deleteAppointment(@PathParam("appointmentId") int appointmentId) {
        try {
            appointmentDAO.deleteAppointment(appointmentId);
            LOGGER.log(Level.INFO, "Deleted appointment with ID: {0} successfully", appointmentId);
            return Response.ok().entity("Appointment with ID " + appointmentId + " successfully deleted.").build();
        } catch (NotFoundException ex) {
            LOGGER.log(Level.SEVERE, "Failed to delete appointment with ID: " + appointmentId, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to delete appointment with ID: " + appointmentId + ". Please try again later.").build();
        }
    }
}
