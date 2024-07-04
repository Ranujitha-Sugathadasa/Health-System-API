/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.MedicalRecord;
import java.util.ArrayList;
import java.util.List;



public class MedicalRecordDAO {
    
    private static List<MedicalRecord> medicalRecords = new ArrayList<>();
    
    static {
        medicalRecords.add(new MedicalRecord(1, "red colout patches", "finished","Null"));        
        medicalRecords.add(new MedicalRecord(2, "fever", "going on","Null"));
        medicalRecords.add(new MedicalRecord(3, "Cough", "didn't start yet","Null"));
    }
    
    //Getting the information of all the Medical Records in the system
    public List<MedicalRecord> getAllMedicals() {
        return medicalRecords;
    }
    
    
    //Getting the information of one specific Medical Record using the Patient Number
    public MedicalRecord getMedicalByPatient(int id) {
        for (MedicalRecord medical : medicalRecords) {
            if (medical.getpatientNo() == id) {
                return medical;
            }
        }
        return null;
    }
    
    
    //Adding a new Medical to the system
    public void addMedical(MedicalRecord medical) {
        medicalRecords.add(medical);
    }
    
    
    //Removing a medical Record from the system using the patient ID
    public void deleteMedical(int id) {
    medicalRecords.removeIf(medical -> medical.getpatientNo() == id);
    }

    
    
    //Updating the details of a Medical Record
    public void updateMedical(MedicalRecord updatedMedical) {
    for (int i = 0; i < medicalRecords.size(); i++) {
        MedicalRecord medical = medicalRecords.get(i);
        if ((updatedMedical.getpatientNo()) == medical.getpatientNo()) {
            medicalRecords.set(i, updatedMedical);
            break; 
        }
    }
}



    
    
}
