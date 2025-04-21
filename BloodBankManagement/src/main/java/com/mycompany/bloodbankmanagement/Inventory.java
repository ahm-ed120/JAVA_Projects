/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bloodbankmanagement;



/**
 *
 * @author MAHNOOR SARDAR
 */
import java.util.ArrayList;
import java.util.List;

public class Inventory implements InventoryManage{
   
    public ArrayList<BloodBag> bloodBags; 
 
    public Inventory() {
        bloodBags = new ArrayList<>(); 
    }

    
    @Override
    public void addItem(BloodBag bloodBag) {
        if (bloodBag != null) {
            bloodBags.add(bloodBag);
            System.out.println("BloodBag added: " + bloodBag.bloodType + ", Volume: " + bloodBag.volume + "ml, Expiry Date: " + bloodBag.expiryDate);
        } else {
            System.out.println("Cannot add a null BloodBag.");
        }
    }

   
    @Override
    public void removeItem(BloodBag bloodBag) {
        if (bloodBags.contains(bloodBag)) {
            bloodBags.remove(bloodBag);
            System.out.println("BloodBag removed: " + bloodBag.bloodType + ", Volume: " + bloodBag.volume + "ml, Expiry Date: " + bloodBag.expiryDate);
        } else {
            System.out.println("BloodBag not found in the inventory.");
        }
    }

   
    @Override
    public void displayInventory() {
        if (bloodBags.isEmpty()) {
            System.out.println("The inventory is empty.");
        } else {
            System.out.println("Current Inventory:");
            for (BloodBag bloodBag : bloodBags) {
                System.out.println("Blood Type: " + bloodBag.bloodType + ", Volume: " + bloodBag.volume + "ml, Expiry Date: " + bloodBag.expiryDate);
            }
        }
    }

    
    @Override
    public String checkItemCondition() {
    String conditionReport = ""; 

    if (bloodBags.isEmpty()) {
        conditionReport += "The inventory is empty. No blood bags to check.";
    } else {
        List<BloodBag> expiredBags = new ArrayList<>();
        for (BloodBag bloodBag : bloodBags) {
            if (bloodBag.checkExpiry()) {
                conditionReport += "Blood Type: " + bloodBag.bloodType + ", Volume: " + bloodBag.volume + "ml is expired.\n";
                expiredBags.add(bloodBag);
            } else {
                conditionReport += "Blood Type: " + bloodBag.bloodType + ", Volume: " + bloodBag.volume + "ml is still valid.\n";
            }
        }

        for (BloodBag expiredBag : expiredBags) {
            bloodBags.remove(expiredBag);
            System.out.println("Expired BloodBag removed: " + expiredBag.bloodType + ", Volume: " + expiredBag.volume + "ml.");
        }
    }
    return conditionReport;
}

}
