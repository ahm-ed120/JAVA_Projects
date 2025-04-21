/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bloodbankmanagement;

/**
 *
 * @author MAHNOOR SARDAR
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Payment implements ManagePayment {

    public String paymentID;
    public double amount;
    public Date date;

    public Payment() {
        this.paymentID = "";
        this.amount = 0.0;
        this.date = new Date();
    }

    public Payment(String paymentID, double amount, Date date) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public void makePayment() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Payment ID: ");
        this.paymentID = input.nextLine();

        System.out.println("Enter Payment Amount: ");
        this.amount = input.nextDouble();
        input.nextLine();

        System.out.println("Enter Payment Date (yyyy-MM-dd): ");
        String dateInput = input.nextLine();
        try {
            this.date = new SimpleDateFormat("yyyy-MM-dd").parse(dateInput);
        } catch (ParseException e) {
            System.out.println("Invalid date format! Setting to current date.");
            this.date = new Date();
        }

        System.out.println("Payment processed successfully!");
    }

    @Override
    public void displayPaymentDetails() {
        System.out.println("Payment ID: " + paymentID);
        System.out.println("Amount: $" + String.format("%.2f", amount));
        System.out.println("Date: " + new SimpleDateFormat("yyyy-MM-dd").format(date));
    }

    @Override
    public void generateReceipt() {
        System.out.println("\n---------- Payment Receipt ----------");
        System.out.println("Payment ID: " + paymentID);
        System.out.println("Amount Paid: $" + String.format("%.2f", amount));
        System.out.println("Payment Date: " + new SimpleDateFormat("yyyy-MM-dd").format(date));
        System.out.println("-------------------------------------");
    }
}
