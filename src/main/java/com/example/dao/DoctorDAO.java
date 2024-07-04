package com.example.dao;

import com.example.model.Doctor;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO extends PersonDAO {

    private static List<Doctor> doctors = new ArrayList<>();

    static {
        doctors.add(new Doctor(1, "Mark", "071 3338465", "panadura", "Dentist"));
        doctors.add(new Doctor(2, "Jace", "077 3849382", "wattala", "Cardiology"));
        doctors.add(new Doctor(3, "Finn", "077 9929382", "jaffna", "Neurology"));

    }

    public static List<Doctor> getAllDoctors() {
        return doctors;
    }

    // Getting the doctors details using their id
    public Doctor getDoctorById(int id) throws NotFoundException {
        for (Doctor doctor : doctors) {
            if (doctor.getID() == id) {
                return doctor;
            }
        }
        throw new NotFoundException("Doctor not found with ID: " + id);
    }

        //Adding new doctor to the list
    public void addDoctor(Doctor doctor) {
        int newDoctorId = getNextDoctorId();
        doctor.setID(newDoctorId);
        addPerson(doctor);
        doctors.add(doctor);
    }
    
        //Updating existing doctor details using doctor id
    public void updateDoctor(Doctor updatedDoctor) {
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            if (doctor.getID() == updatedDoctor.getID()) {
                doctors.set(i, updatedDoctor);
                System.out.println("Doctor details updated: " + updatedDoctor);
                return;
            }
        }
    }


    //Deleting existing doctor using doctor id
    public void deleteDoctor(int id) throws NotFoundException {
        doctors.removeIf(doctor1 -> doctor1.getID() == id);
    }
    
     public int getNextDoctorId() {

        int maxDoctorId = Integer.MIN_VALUE;

        for (Doctor doctor : doctors) {
            int userId = doctor.getID();
            if (userId > maxDoctorId) {
                maxDoctorId = userId;
            }
        }
        return maxDoctorId + 1;
    }
     
}
