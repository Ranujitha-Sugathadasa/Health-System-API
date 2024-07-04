/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;


public class Prescription {
    
    private Patient patient;
    private Doctor doctor;
    private String medication;
    private int dosage;
    private String instructions;
    private int durationInDays;
    private int prescriptionid;
    
    //Contructors
    public Prescription(){
    
    }

    public Prescription(Patient patient, Doctor doctor, String medication, int dosage, String instructions, int durationInDays,int prescriptionif) {
        this.patient = patient;
        this.doctor = doctor;
        this.medication = medication;
        this.dosage = dosage;
        this.instructions = instructions;
        this.durationInDays = durationInDays;
        this.prescriptionid = prescriptionid;
    }
    
    //getters and setters
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }
    
    public void setPrescriptionid(int id) {
        this.prescriptionid = id;
    }
}
