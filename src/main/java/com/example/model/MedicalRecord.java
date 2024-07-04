/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

public class MedicalRecord {
    
    private int patientNo;
    private String diagnoses;
    private String treatments;
    private String otherData;
    
    //Contructors
    public MedicalRecord(){
        
    }
  
    
    public MedicalRecord(int patientNo, String diagnoses, String treatments , String otherData) {
        this.patientNo = patientNo;
        this.diagnoses = diagnoses;
        this.treatments = treatments;
        this.otherData = otherData;
    }

     //Getters and setters      
    public int getpatientNo() {
        return patientNo;
    }
    
    public void setPatientNo(int patientNo) {
        this.patientNo = patientNo;
    }
    
    public String getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public String getTreatments() {
        return treatments;
    }

    public void setTreatments(String treatments) {
        this.treatments = treatments;
    }
    
    public String getOtherData() {
        return otherData;
    }

    public void setOtherData(String otherData) {
        this.otherData = otherData;
    }
    
    

}

