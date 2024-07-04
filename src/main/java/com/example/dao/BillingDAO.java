/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Billing;
import com.example.model.Patient;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.NotFoundException;



public class BillingDAO {
    private static List<Billing> billings = new ArrayList<>();
    
    static {
    List<Patient> allPatients = PatientDAO.getAllPatients();
    
    billings.add(new Billing(1,allPatients.get(0) ,2000, 1800));
    billings.add(new Billing(2,allPatients.get(1) ,1200, 1000));
    billings.add(new Billing(3,allPatients.get(2) ,10000, 8000));
    }
    
    //Getting all the bills
    public List<Billing> getAllBillings() {
        return billings;
    }
    
    //Getting bill using billing no
    public Billing getBilling(int Id) {
        for (Billing billing : billings) {
            if (billing.getNo()== Id) {
                return billing;
            }
        }
        return null;
    }

    // Adding a new bill 
    public void addBilling(Billing billing) {
         int newUserId = getNextBillId();
        billing.setNo(newUserId);
        billings.add(billing);
    }
    
    //Updating existing bill using bill no
     public void updateBilling(Billing updatedBilling) {
        for (int i = 0; i < billings.size(); i++) {
            Billing billing = billings.get(i);
            if (billing.getNo() == updatedBilling.getNo()) {
                billings.set(i, updatedBilling);
                System.out.println("Bill updated: " + updatedBilling);
                return;
            }
        }
    }
    
     //Deleting existing bill using bill no
     public void deleteBills(int No) {
        billings.removeIf(Billing -> Billing.getNo() == No);
    }
     
     public int getNextBillId() {
        
        int maxUserId = Integer.MIN_VALUE;

        for (Billing Bill : billings) {
            int userId = Bill.getNo();
            if (userId > maxUserId) {
                maxUserId = userId;
            }
        }

        return maxUserId + 1;
    }

}
