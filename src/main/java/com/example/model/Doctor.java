/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;


public class Doctor extends Person{
    
    private String specialization;
    
    //Contructors
      public Doctor() {
    }
    
    public Doctor(int id, String name, String contactInformation, String address, String specialization) {
        super(id, name, contactInformation, address);
        this.specialization = specialization;
      
    }
    
    //Getter and setter
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
