/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;
import com.example.model.Doctor;
import com.example.model.Patient;
import com.example.model.Prescription;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.NotFoundException;

public class PrescriptionDAO {
    private static List<Prescription> prescriptions = new ArrayList<>();
    
    static {
    List<Patient> allPatients = PatientDAO.getAllPatients();
    List<Doctor> allDoctors = DoctorDAO.getAllDoctors();
    
     prescriptions.add(new Prescription(allPatients.get(0), allDoctors.get(0),"", 2, "Take 1 tablet every 4-6 hours as needed for symptoms and drink plenty of fluids.", 6,1));
     prescriptions.add(new Prescription(allPatients.get(1), allDoctors.get(2),"", 2, "Take 1 tablet every 6-8 hours as needed for cough and avoid driving", 7,2));
     prescriptions.add(new Prescription(allPatients.get(2), allDoctors.get(1),"", 2, "Take all the medicine until finish of the week", 7,3));
    }
    
    //Getting all the prescriptions
    public List<Prescription> getAllPrescriptions() {
        return prescriptions;
    }
    
    
     public Prescription getPrescription(int id) throws NotFoundException {
        for (Prescription prescription : prescriptions) {
            if (prescription.getPatient().getID() == id) {
                return prescription;
            }
        }
        return null;
    }

        //Adding new prescription
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    //Updating a existing prescription
    public void updatePrescription(Prescription updatedPrescription) {
        for (int i = 0; i < prescriptions.size(); i++) {
            Prescription prescription = prescriptions.get(i);
            if (prescription.getPatient().getID() == updatedPrescription.getPatient().getID()) {
                prescriptions.set(i, updatedPrescription);
                System.out.println("Prescription details updated: " + updatedPrescription);
                return;
            }
        }
    }

    //deleting existing prescription
    public void deletePrescription(int id) throws NotFoundException {
        Prescription prescription = getPrescription(id);
        prescriptions.remove(prescription);
    }
}