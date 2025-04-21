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
public class Recipient extends Person {

    public String medicalHistory;
    public String requiredBloodType;
    public ArrayList<String> bloodRequestHistory;

    public Recipient() {
        super();
        medicalHistory = " ";
        requiredBloodType = " ";
        bloodRequestHistory = new ArrayList<>();
    }

    public Recipient(String id, String name, int age, String gender, String address, String email, String medicalHistory, String requiredBloodType) {
        super(id, name, age, gender, address, email);
        this.medicalHistory = medicalHistory;
        this.requiredBloodType = requiredBloodType;
        this.bloodRequestHistory = new ArrayList<>();
    }

    @Override
    public void setter() {
        super.setter();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter medical history: ");
        medicalHistory = input.nextLine();

        System.out.println("Enter Required Blood Type: ");
        requiredBloodType = input.nextLine();

        System.out.println("Do you want to add blood request history? (yes/no): ");
        String choice = input.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("Enter blood request details (type 'done' to stop):");
            while (true) {
                String request = input.nextLine();
                if (request.equalsIgnoreCase("done")) {
                    break;
                }
                bloodRequestHistory.add(request);
            }
            System.out.println("Blood request history added successfully!");
        }
    }

    public boolean requestBlood(String bloodType, double volume, ArrayList<BloodBag> inventory) {
        if (!bloodType.equalsIgnoreCase(requiredBloodType)) {
            System.out.println("Blood type mismatch. Request denied.");
            return false;
        }

        for (BloodBag bloodBag : inventory) {
            if (bloodBag.bloodType.equalsIgnoreCase(bloodType) && bloodBag.volume >= volume) {
                if (bloodBag.checkExpiry()) {
                    System.out.println("Blood bag has expired. Request denied.");
                    return false;
                }

                bloodBag.volume -= volume;
                if (bloodBag.volume <= 0) {
                    inventory.remove(bloodBag);
                }
                String requestDetail = "Requested " + volume + "ml of " + bloodType + " blood. Expiry Date: " + bloodBag.expiryDate;
                bloodRequestHistory.add(requestDetail);
                System.out.println("Blood request recorded and fulfilled: " + requestDetail);
                return true;
            }
        }

        System.out.println("Requested blood type or volume not available in inventory. Request denied.");
        return false;
    }

    public void viewRequestHistory() {
        if (bloodRequestHistory.isEmpty()) {
            System.out.println("No blood request history available.");
        } else {
            System.out.println("Blood Request History:");
            for (String request : bloodRequestHistory) {
                System.out.println("- " + request);
            }
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Medical History: " + medicalHistory);
        System.out.println("Required Blood Type: " + requiredBloodType);
        System.out.println("Blood Request History:");
        viewRequestHistory();
    }
}
