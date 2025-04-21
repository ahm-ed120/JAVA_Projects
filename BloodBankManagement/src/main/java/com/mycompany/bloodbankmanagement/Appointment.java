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
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Appointment implements ManageAppointment {

    public String appointmentID;
    public Date date;
    public Recipient patient;
    public Doctor doctor;

    public Appointment() {
        this.appointmentID = "";
        this.date = new Date();
        this.patient = null;
        this.doctor = null;
    }

    public Appointment(String appointmentID, Date date, Recipient patient, Doctor doctor) {
        this.appointmentID = appointmentID;
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
    }

    @Override

    public void schedule(ArrayList<Doctor> doctors, Scanner input) {
        System.out.println("\nEnter Appointment ID: ");
        this.appointmentID = input.nextLine();

        System.out.println("Enter Appointment Date (yyyy-MM-dd): ");
        String dateInput = input.nextLine();
        try {
            this.date = new SimpleDateFormat("yyyy-MM-dd").parse(dateInput);
        } catch (ParseException e) {
            System.out.println("Invalid date format! Setting to current date.");
            this.date = new Date();
        }

        System.out.println("Enter Patient Details:");
        this.patient = new Recipient();
        this.patient.setter();

        System.out.println("Available Doctors:");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i).name + " (Specialty: " + doctors.get(i).specialty + ")");
        }

        System.out.print("Select Doctor by Number: ");
        int doctorChoice = input.nextInt();
        input.nextLine();

        if (doctorChoice > 0 && doctorChoice <= doctors.size()) {
            this.doctor = doctors.get(doctorChoice - 1);
        } else {
            System.out.println("Invalid choice. No doctor assigned.");
        }

        System.out.println("Appointment scheduled successfully!");
    }

    @Override
    public void reschedule(Scanner input) {
        System.out.println("Current Appointment Date: " + new SimpleDateFormat("yyyy-MM-dd").format(this.date));
        System.out.println("Enter New Appointment Date (yyyy-MM-dd): ");
        String newDateStr = input.nextLine();
        try {
            this.date = new SimpleDateFormat("yyyy-MM-dd").parse(newDateStr);
            System.out.println("Appointment rescheduled successfully to: " + new SimpleDateFormat("yyyy-MM-dd").format(this.date));
        } catch (ParseException e) {
            System.out.println("Invalid date format. Reschedule failed.");
        }
    }

    @Override
    public void cancelAppointment() {
        this.date = null;
        this.patient = null;
        this.doctor = null;
        System.out.println("Appointment canceled successfully.");
    }

    public void display() {
        System.out.println("Appointment ID: " + appointmentID);
        System.out.print("Appointment Date: ");
        if (date != null) {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
        } else {
            System.out.println("Not Set");
        }

        if (patient != null) {
            System.out.println("Patient Details:");
            patient.display();
        } else {
            System.out.println("Patient Details: Not Assigned");
        }

        if (doctor != null) {
            System.out.println("Doctor Details:");
            doctor.display();
        } else {
            System.out.println("Doctor Details: Not Assigned");
        }
    }
}
