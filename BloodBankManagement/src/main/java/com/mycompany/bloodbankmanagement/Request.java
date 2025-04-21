/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bloodbankmanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author MAHNOOR SARDAR
 */
public class Request implements RequestManage{
    public String requestId;
    public Date date;
    public String patientId;
    public String bloodType;
    public String status;
    
    public Request()
    {
        requestId=" ";
        date=new Date();
        patientId=" ";
        bloodType=" ";
        status="Pending";
    }
    
    public Request(String requestId, Date date, String patientId, String bloodType, String status)
    {
        this.requestId=requestId;
        this. date=date;
        this.patientId=patientId;
        this.bloodType=bloodType;
        this.status=status;
    }
    
    @Override
    public void setter()
    {
        Scanner input= new Scanner(System.in);
        System.out.println("Enter request ID: ");
        requestId=input.next();
        System.out.println("Enter date: ('yyyy-MM-dd')");
       String dateInput = input.nextLine();
        try {
            this.date = new SimpleDateFormat("yyyy-MM-dd").parse(dateInput);
        } catch (ParseException e) {
            System.out.println("Invalid date format! Setting to current date.");
            this.date = new Date();
        }
        this.status = "Pending";
        
        System.out.println("Enter patient Id: ");
        patientId= input.next();
        System.out.println("Enter Blood Type: ");
        bloodType=input.next();
    }
    
    @Override
    public boolean processRequest(boolean isBloodAvailable) {
        if (isBloodAvailable) {
            this.status = "Fulfilled"; 
            System.out.println("Request ID: " + requestId + " has been fulfilled.");
            return true;
        } else {
            this.status = "Rejected"; 
            System.out.println("Request ID: " + requestId + " cannot be fulfilled. Blood type not available.");
            return false;
        }
    }
    
    @Override
     public void displayRequestDetails() {
        System.out.println("Request ID: " + requestId);
        System.out.println("Request Date: " + date);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Blood Type: " + bloodType);
        System.out.println("Request Status: " + status);
    }
}
