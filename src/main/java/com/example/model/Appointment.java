package com.example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Appointment {

    private int id;     
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;
    
    //contructors
    public Appointment(){ 
    }

    public Appointment(int id, String date, String time, Patient patient, Doctor doctor) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    //Getters and setters 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
     public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setAppointmentId(int id) {
        this.id = id;
    }
}
