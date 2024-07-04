package com.example.dao;

import com.example.model.Appointment;
import com.example.model.Doctor;
import com.example.model.Patient;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.NotFoundException;

public class AppointmentDAO {
    private static List<Appointment> appointments = new ArrayList<>();

    
    static {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        String formattedDate = date.format(dateFormatter);
        String formattedTime = time.format(timeFormatter);
        
        //Getting all the doctors and patients information for DAOs'
        List<Patient> allPatients = PatientDAO.getAllPatients();
        List<Doctor> allDoctors = DoctorDAO.getAllDoctors();

        // Creating appointments and add them to the list
        appointments.add(new Appointment(1, formattedDate, formattedTime, allPatients.get(0), allDoctors.get(0)));
        appointments.add(new Appointment(2, formattedDate, formattedTime, allPatients.get(1), allDoctors.get(1)));
        appointments.add(new Appointment(3, formattedDate, formattedTime, allPatients.get(2), allDoctors.get(2)));

        
    }
     public List<Appointment> getAllAppointments() {
        return appointments;
    }
     
         //Getting appointment using appointment id
      public Appointment getAppointmentById(int appointmentId) {
        
        for (Appointment appointment : appointments) {
            if (appointment.getId() == appointmentId) {
                return appointment;
            }
        }
        return null;
    }
    // Adding new appointment
    public void addAppointment(Appointment appointment) {
        int newUserId = getNextAppointmentId();
        appointment.setId(newUserId);
        appointments.add(appointment);
    }

   

    // Updateing the existing appointment using appointment id
    public void updateAppointment(int appointmentId, Appointment updatedAppointment) throws NotFoundException {
        Appointment appointment = getAppointmentById(appointmentId);
        // Updating appointment attributes
        appointment.setDate(updatedAppointment.getDate());
    }
    
      public void updateAppointment(Appointment updatedAppointment) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);
            if (appointment.getId() == updatedAppointment.getId()) {
                appointments.set(i, updatedAppointment);
                System.out.println("Appointment details updated: " + updatedAppointment);
                return;
            }
        }
    }
      
      //deleting existing appointment
    public void deleteAppointment(int appointmentId) throws NotFoundException {
        appointments.removeIf(appoin -> appoin.getId() == appointmentId);
    }
    
    public int getNextAppointmentId() {

        int maxUserId = Integer.MIN_VALUE;

        for (Appointment apointment : appointments) {
            int AppointmentId = apointment.getId();
            if (AppointmentId > maxUserId) {
                maxUserId = AppointmentId;
            }
        }
        return maxUserId + 1;
    }
}
