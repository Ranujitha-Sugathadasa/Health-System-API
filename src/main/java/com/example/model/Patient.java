package com.example.model;

public class Patient extends Person {

    private String medicalHistory;
    private String currentHealthStatus;
    
    //Contructors
    public Patient(){
        
    }

    public Patient(int id, String name, String contactInformation, String address, String medicalHistory, String currentHealthStatus) {
        super(id, name, contactInformation, address);
        this.medicalHistory = medicalHistory;
        this.currentHealthStatus = currentHealthStatus;
    }
    
    //getters and setters
    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getCurrentHealthStatus() {
        return currentHealthStatus;
    }

    public void setCurrentHealthStatus(String currentHealthStatus) {
        this.currentHealthStatus = currentHealthStatus;
    }
}
