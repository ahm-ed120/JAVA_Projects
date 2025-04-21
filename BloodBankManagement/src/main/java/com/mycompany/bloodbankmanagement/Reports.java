/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bloodbankmanagement;



import java.util.ArrayList;
import java.util.Date;

public class Reports implements ManageReports {
   
    public Date reportDate;

    
    public ArrayList<Donor> donors;
    public ArrayList<Recipient> recipients;
    public Inventory inventory;
    public ArrayList<Payment> payments;

    public Reports(ArrayList<Donor> donors, ArrayList<Recipient> recipients, Inventory inventory, ArrayList<Payment> payments) {
        
        this.reportDate = new Date();
        this.donors = donors;
        this.recipients = recipients;
        this.inventory = inventory;
        this.payments = payments;
    }

    @Override
    public void generateDonorReport() {
        System.out.println("\n--- Donor Report ---");
        if (donors.isEmpty()) {
            System.out.println("No donors available.");
            return;
        }

        for (Donor donor : donors) {
            donor.display();
            donor.viewDonationHistory();
            System.out.println("-------------------");
        }
    }

    @Override
    public void generateRecipientReport() {
        System.out.println("\n--- Recipient Report ---");
        if (recipients.isEmpty()) {
            System.out.println("No recipients available.");
            return;
        }

        for (Recipient recipient : recipients) {
            recipient.display();
            recipient.viewRequestHistory();
            System.out.println("-------------------");
        }
    }

    @Override
    public void generateInventoryReport() {
        System.out.println("\n--- Inventory Report ---");
        inventory.displayInventory();
    }

    @Override
    public void generatePaymentReport() {
        System.out.println("\n--- Payment Report ---");
        if (payments.isEmpty()) {
            System.out.println("No payments available.");
            return;
        }

        double totalRevenue = 0.0;
        for (Payment payment : payments) {
            payment.displayPaymentDetails();
            totalRevenue += payment.amount;
            System.out.println("-------------------");
        }
        System.out.println("Total Revenue: $" + String.format("%.2f", totalRevenue));
    }

    @Override
    public void generateActivityReport() {
        System.out.println("\n--- Activity Report ---");
        System.out.println("Total Donors: " + donors.size());
        System.out.println("Total Recipients: " + recipients.size());
        System.out.println("Total Payments: " + payments.size());
        System.out.println("Blood Inventory Status:");
        inventory.displayInventory();
    }
}
