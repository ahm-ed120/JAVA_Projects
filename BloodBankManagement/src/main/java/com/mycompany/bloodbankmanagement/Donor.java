/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bloodbankmanagement;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MAHNOOR SARDAR
 */
public class Donor extends Person{
    public String bloodType;
    public ArrayList<String> donationHistory;
    
    public Donor()
    {
        super();
        bloodType = "";
        donationHistory = new ArrayList<>();
    }
    
    public Donor(String id, String name, int age,String gender, String address, String email, String bloodType )
    {
        super(id, name, age, gender, address, email); 
        this.bloodType = bloodType;
        this.donationHistory = new ArrayList<>();
    }
    
    public void addDonation(String donationDetail) {
        donationHistory.add(donationDetail);
    }
    
    public void displayDonationHistory() {
        System.out.println("Donation History for " + super.name + ":");
        for (String donation : donationHistory) {
            System.out.println("- " + donation);
        }
    }
    
    @Override
    public void setter() {
    super.setter(); 
    Scanner input = new Scanner(System.in);
    
    
    System.out.println("Enter Blood Type: ");
    bloodType = input.next();
    
    
    System.out.println("Enter a donation detail (or type 'none' to skip): ");
    String donationDetail = input.next();
    if (!donationDetail.equalsIgnoreCase("none")) {
        donationHistory.add(donationDetail);
    }
}
    @Override
    public void display() {
    super.display(); 
    System.out.println("Blood Type: " + bloodType);
    }
    
    public void viewDonationHistory(){
    if (donationHistory.isEmpty()) {
        System.out.println("Donation History: No donations recorded.");
    } else {
        System.out.println("Donation History:");
        for (String donation : donationHistory) {
            System.out.println("- " + donation);
        }
    }
}
    public void donateBlood(BloodBag bloodBag) {
        if (bloodBag == null) {
            System.out.println("Invalid BloodBag. Donation not recorded.");
            return;
        }

        
        String donationDetail = "Donated " + bloodBag.getVolume() + "ml of " + bloodType +
                                " blood on " + bloodBag.getexpiryDate();
        donationHistory.add(donationDetail);
        System.out.println("Donation recorded: " + donationDetail);
    }
    
    
}



