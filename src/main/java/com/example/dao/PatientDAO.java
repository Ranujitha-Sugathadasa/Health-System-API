package com.example.dao;

import com.example.model.Patient;
import com.example.model.Person;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.NotFoundException;

public class PatientDAO extends PersonDAO {

    private static List<Patient> patients = new ArrayList<>();
    
    //Initialize the block that runs when class is loaded
     static {
        patients.add(new Patient(1, "Kevin", "071 8003476", "silva road , kollupitiya", "Pneumonia intial stage", "Mild"));
        patients.add(new Patient(2, "Dimitri", "078 4938305", "12/4 , kells scheme", "Diabetics severe stage", "Critical"));
        patients.add(new Patient(3, "Ryan", "072 6745905", "kirulapana , colombo 08", "Dengue critical stage", "Severe"));

    }
    
     //Retrieve all patients
    public static List<Patient> getAllPatients() {
        return patients;
    }
    
     public Patient getPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getID() == id) {
                return patient;
            }
        }
        return null;
    }

    //Adding a new patient
    public void addPatient(Patient patient) {
        int newpatientId = getNextPatientId();
        patient.setID(newpatientId);
        addPerson(patient);
        patients.add(patient);
    }

   
    //Updating a existing patient
    public void updatePatient(Patient updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            if (patient.getID() == updatedPatient.getID()) {
                patients.set(i, updatedPatient);
                System.out.println("Patient updated: " + updatedPatient);
                return;
            }
        }
    }

    // Deleting the existing patient
    public void deletePatient(int id) throws NotFoundException {
        patients.removeIf(patientt -> patientt.getID() == id);
    }
    
     public int getNextPatientId() {
         
        int maxpatientId = Integer.MIN_VALUE;

        for (Patient patient : patients) {
            int userId = patient.getID();
            if (userId > maxpatientId) {
                maxpatientId = userId;
            }
        }

        return maxpatientId + 1;
    }
}
