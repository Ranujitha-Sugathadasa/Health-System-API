/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;


public class Billing {
    
    private int InvoiceNo;
    private Patient patient;
    private double payment;
    private double Total;
    private double Balance;
    
    //Contructors
    public Billing(){
    
    }
    
    public Billing(int InvoiceNo, Patient patient,double payment,double Total  ){
        this.InvoiceNo = InvoiceNo;
        this.patient = patient;
        this.Total = Total;
        this.payment = payment;
        this.Balance = payment - Total;
    }
    
    //Getters and setters
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public int getNo() {
        return InvoiceNo;
    }

    public void setNo(int No) {
        this.InvoiceNo = No;
    }
    
    public double getPayment() {
        return payment;
    }

    public void setPayment(double Payment) {
        this.payment = Payment;
    }
    
    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }
    
    public double getBalance() {
        return Balance;
    }
    
    public void setBalance(double balance) {
        this.Balance = balance;
    }
}
