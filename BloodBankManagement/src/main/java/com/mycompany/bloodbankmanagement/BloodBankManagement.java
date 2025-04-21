/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.bloodbankmanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BloodBankManagement {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Donor> donors = new ArrayList<>();
        ArrayList<Recipient> recipients = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Doctor> doctors = new ArrayList<>();
        ArrayList<Appointment> appointments = new ArrayList<>();
        ArrayList<Payment> payments = new ArrayList<>();
        Inventory inventory = new Inventory();
        Reports reports = new Reports(donors, recipients, inventory, payments);

        Employee employee;

        int mainChoice;
        do {
            System.out.println("\n--- Blood Bank Management System ---");
            System.out.println("1. Donor Management");
            System.out.println("2. Recipient Management");
            System.out.println("3. Inventory Management");
            System.out.println("4. Appointment Management");
            System.out.println("5. Employee Management");
            System.out.println("6. Payment Management");
            System.out.println("7. Reports");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            mainChoice = input.nextInt();
            input.nextLine();

            switch (mainChoice) {
                case 1: {
                    int donorChoice;
                    do {
                        System.out.println("\n--- Donor Management ---");
                        System.out.println("1. Add Donor");
                        System.out.println("2. Update Donor");
                        System.out.println("3. Remove Donor");
                        System.out.println("4. Search Donor");
                        System.out.println("5. Display All Donors");
                        System.out.println("6. Donate Blood");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        donorChoice = input.nextInt();
                        input.nextLine();

                        switch (donorChoice) {
                            case 1:
                                Donor donor = new Donor();
                                donor.setter();
                                donors.add(donor);
                                System.out.println("Donor added successfully!");
                                break;

                            case 2:
                                System.out.print("Enter Donor ID to update: ");
                                String donorUpdateId = input.nextLine();
                                boolean donorFound = false;
                                for (Donor d : donors) {
                                    if (d.id.equals(donorUpdateId)) {
                                        d.setter();
                                        donorFound = true;
                                        break;
                                    }
                                }
                                if (!donorFound) {
                                    System.out.println("Donor not found.");
                                }
                                break;

                            case 3:
                                System.out.print("Enter Donor ID to remove: ");
                                String donorRemoveId = input.nextLine();
                                donorFound = false;
                                for (int i = 0; i < donors.size(); i++) {
                                    if (donors.get(i).id.equals(donorRemoveId)) {
                                        donors.remove(i);
                                        donorFound = true;
                                        System.out.println("Donor removed successfully!");
                                        break;
                                    }
                                }
                                if (!donorFound) {
                                    System.out.println("Donor not found.");
                                }
                                break;

                            case 4:
                                System.out.print("Enter Donor ID to search: ");
                                String donorSearchId = input.nextLine();
                                donorFound = false;
                                for (Donor d : donors) {
                                    if (d.id.equals(donorSearchId)) {
                                        d.display();
                                        donorFound = true;
                                    }
                                }
                                if (!donorFound) {
                                    System.out.println("Donor not found.");
                                }
                                break;

                            case 5:
                                if (donors.isEmpty()) {
                                    System.out.println("No donors available.");
                                } else {
                                    for (Donor d : donors) {
                                        d.display();
                                        System.out.println();
                                    }
                                }
                                break;

                            case 6:
                                System.out.print("Enter Donor ID to donate blood: ");
                                String donorDonateId = input.nextLine();
                                donorFound = false;
                                for (Donor d : donors) {
                                    if (d.id.equals(donorDonateId)) {
                                        System.out.print("Enter Blood Volume (in ml): ");
                                        double volume = input.nextDouble();
                                        input.nextLine();
                                        System.out.print("Enter Expiry Date (yyyy-MM-dd): ");
                                        String expiryDateStr = input.nextLine();
                                        try {
                                            Date expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse(expiryDateStr);
                                            BloodBag bloodBag = new BloodBag(d.bloodType, volume, expiryDate);
                                            inventory.addItem(bloodBag);
                                            d.donateBlood(bloodBag);
                                            System.out.println("Blood donation recorded and added to inventory!");
                                        } catch (ParseException e) {
                                            System.out.println("Invalid date format.");
                                        }
                                        donorFound = true;
                                        break;
                                    }
                                }
                                if (!donorFound) {
                                    System.out.println("Donor not found.");
                                }
                                break;

                            case 0:
                                System.out.println("Returning to main menu.");
                                break;

                            default:
                                System.out.println("Invalid choice. Try again.");
                        }
                    } while (donorChoice != 0);
                    break;
                }

                case 2: {
                    int recipientChoice;
                    do {
                        System.out.println("\n--- Recipient Management ---");
                        System.out.println("1. Add Recipient");
                        System.out.println("2. Update Recipient");
                        System.out.println("3. Remove Recipient");
                        System.out.println("4. Search Recipient");
                        System.out.println("5. Display All Recipients");
                        System.out.println("6. Request Blood");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        recipientChoice = input.nextInt();
                        input.nextLine();

                        switch (recipientChoice) {
                            case 1: // Add Recipient
                                Recipient recipient = new Recipient();
                                recipient.setter();
                                recipients.add(recipient);
                                System.out.println("Recipient added successfully!");
                                break;

                            case 2: // Update Recipient
                                System.out.print("Enter Recipient ID to update: ");
                                String recipientUpdateId = input.nextLine();
                                boolean recipientFound = false;
                                for (Recipient r : recipients) {
                                    if (r.id.equals(recipientUpdateId)) {
                                        r.setter();
                                        recipientFound = true;
                                        System.out.println("Recipient updated successfully!");
                                        break;
                                    }
                                }
                                if (!recipientFound) {
                                    System.out.println("Recipient not found.");
                                }
                                break;

                            case 3: // Remove Recipient
                                System.out.print("Enter Recipient ID to remove: ");
                                String recipientRemoveId = input.nextLine();
                                recipientFound = false;
                                for (int i = 0; i < recipients.size(); i++) {
                                    if (recipients.get(i).id.equals(recipientRemoveId)) {
                                        recipients.remove(i);
                                        recipientFound = true;
                                        System.out.println("Recipient removed successfully!");
                                        break;
                                    }
                                }
                                if (!recipientFound) {
                                    System.out.println("Recipient not found.");
                                }
                                break;

                            case 4: // Search Recipient
                                System.out.print("Enter Recipient ID to search: ");
                                String recipientSearchId = input.nextLine();
                                recipientFound = false;
                                for (Recipient r : recipients) {
                                    if (r.id.equals(recipientSearchId)) {
                                        r.display();
                                        recipientFound = true;
                                    }
                                }
                                if (!recipientFound) {
                                    System.out.println("Recipient not found.");
                                }
                                break;

                            case 5: // Display All Recipients
                                if (recipients.isEmpty()) {
                                    System.out.println("No recipients available.");
                                } else {
                                    for (Recipient r : recipients) {
                                        r.display();
                                        System.out.println();
                                    }
                                }
                                break;

                            case 6: // Request Blood
                                System.out.print("Enter Recipient ID requesting blood: ");
                                String requesterId = input.nextLine();
                                recipientFound = false;
                                for (Recipient r : recipients) {
                                    if (r.id.equals(requesterId)) {
                                        System.out.print("Enter Blood Type needed: ");
                                        String requestedBloodType = input.nextLine();
                                        System.out.print("Enter Volume needed (in ml): ");
                                        double requestedVolume = input.nextDouble();
                                        input.nextLine();

                                        boolean success = r.requestBlood(requestedBloodType, requestedVolume, inventory.bloodBags);
                                        if (success) {
                                            System.out.println("Request fulfilled successfully!");
                                        } else {
                                            System.out.println("Request could not be fulfilled.");
                                        }
                                        recipientFound = true;
                                        break;
                                    }
                                }
                                if (!recipientFound) {
                                    System.out.println("Recipient not found.");
                                }
                                break;

                            case 0: // Back to Main Menu
                                System.out.println("Returning to main menu.");
                                break;

                            default:
                                System.out.println("Invalid choice. Try again.");
                        }
                    } while (recipientChoice != 0);
                    break;
                }

                case 3: {
                    int inventoryChoice;
                    do {
                        System.out.println("\n--- Inventory Management ---");
                        System.out.println("1. Add Blood Bag");
                        System.out.println("2. Remove Blood Bag");
                        System.out.println("3. Display Inventory");
                        System.out.println("4. Check Blood Bag Conditions");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        inventoryChoice = input.nextInt();
                        input.nextLine();

                        switch (inventoryChoice) {
                            case 1: // Add Blood Bag
                                System.out.print("Enter Blood Type: ");
                                String bloodType = input.nextLine();
                                System.out.print("Enter Volume (in ml): ");
                                double volume = input.nextDouble();
                                input.nextLine();
                                System.out.print("Enter Expiry Date (yyyy-MM-dd): ");
                                String expiryDateStr = input.nextLine();
                                try {
                                    Date expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse(expiryDateStr);
                                    inventory.addItem(new BloodBag(bloodType, volume, expiryDate));
                                    System.out.println("Blood Bag added successfully!");
                                } catch (ParseException e) {
                                    System.out.println("Invalid date format.");
                                }
                                break;

                            case 2: // Remove Blood Bag
                                System.out.print("Enter Blood Type to remove: ");
                                String removeType = input.nextLine();
                                boolean removed = false;
                                for (BloodBag b : inventory.bloodBags) {
                                    if (b.bloodType.equalsIgnoreCase(removeType)) {
                                        inventory.removeItem(b);
                                        removed = true;
                                        System.out.println("Blood Bag removed successfully!");
                                        break;
                                    }
                                }
                                if (!removed) {
                                    System.out.println("No matching blood bag found.");
                                }
                                break;

                            case 3: // Display Inventory
                                inventory.displayInventory();
                                break;

                            case 4: // Check Blood Bag Conditions
                                System.out.println(inventory.checkItemCondition());
                                break;

                            case 0: // Back to Main Menu
                                System.out.println("Returning to main menu.");
                                break;

                            default:
                                System.out.println("Invalid choice. Try again.");
                        }
                    } while (inventoryChoice != 0);
                    break;
                }

                case 4: {
                    int appointmentChoice;
                    do {
                        System.out.println("\n--- Appointment Management ---");
                        System.out.println("1. Schedule Appointment");
                        System.out.println("2. Reschedule Appointment");
                        System.out.println("3. Cancel Appointment");
                        System.out.println("4. Display All Appointments");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        appointmentChoice = input.nextInt();
                        input.nextLine();

                        switch (appointmentChoice) {
                            case 1:
                                if (doctors.isEmpty()) {
                                    System.out.println("No doctors available. Please add doctors first.");
                                } else {
                                    Appointment appointment = new Appointment();
                                    appointment.schedule(doctors, input);
                                    appointments.add(appointment);
                                    System.out.println("Appointment scheduled successfully!");
                                }
                                break;

                            case 2:
                                System.out.print("Enter Appointment ID to reschedule: ");
                                String rescheduleId = input.nextLine();
                                boolean found = false;
                                for (Appointment app : appointments) {
                                    if (app.appointmentID.equals(rescheduleId)) {
                                        app.reschedule(input);
                                        found = true;
                                        break;
                                    }
                                }
                                if (!found) {
                                    System.out.println("Appointment not found.");
                                }
                                break;

                            case 3:
                                System.out.print("Enter Appointment ID to cancel: ");
                                String cancelId = input.nextLine();
                                found = false;
                                for (int i = 0; i < appointments.size(); i++) {
                                    if (appointments.get(i).appointmentID.equals(cancelId)) {
                                        appointments.get(i).cancelAppointment();
                                        appointments.remove(i);
                                        found = true;
                                        break;
                                    }
                                }
                                if (!found) {
                                    System.out.println("Appointment not found.");
                                }
                                break;

                            case 4:
                                if (appointments.isEmpty()) {
                                    System.out.println("No appointments available.");
                                } else {
                                    for (Appointment app : appointments) {
                                        app.display();
                                        System.out.println("----------------------");
                                    }
                                }
                                break;

                            case 0:
                                System.out.println("Returning to main menu.");
                                break;

                            default:
                                System.out.println("Invalid choice. Try again.");
                        }
                    } while (appointmentChoice != 0);
                    break;
                }

                case 5: // Employee Management
                    int employeeChoice;
                    do {
                        System.out.println("\n--- Employee Management ---");
                        System.out.println("1. Add Employee");
                        System.out.println("2. Update Employee");
                        System.out.println("3. Search Employee");
                        System.out.println("4. Remove Employee");
                        System.out.println("5. Display All Employees");
                        System.out.println("6. Calculate Bonus for an Employee");
                        System.out.println("7. Display Salary for an Employee");
                        System.out.println("8. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        employeeChoice = input.nextInt();
                        input.nextLine();

                        switch (employeeChoice) {
                            case 1: // Add Employee
                                while (true) {
                                    System.out.println("1. Add Doctor");
                                    System.out.println("2. Add Nurse");
                                    System.out.println("3. Add Technician");
                                    System.out.print("Enter your choice: ");
                                    while (true) {
                                        try {
                                            input = new Scanner(System.in);
                                            employeeChoice = input.nextInt();
                                            input.nextLine();
                                            break;
                                        } catch (Exception e) {
                                            System.out.println("Invalid Input.Try again.");
                                            input.nextLine();
                                        }
                                    }

                                    switch (employeeChoice) {
                                        case 1:
                                            employee = new Doctor(); // Polymorphic behavior
                                            employee.setter();
                                            employees.add(employee);
                                            doctors.add((Doctor) employee); // Ensure it's stored in doctors list too
                                            System.out.println("Doctor added successfully!");

                                            break;
                                        case 2:
                                            employee = new Nurse();
                                            employee.setter();
                                            employees.add(employee);
                                            System.out.println("Nurse added successfully!");
                                            break;
                                        case 3:
                                            employee = new Technician();
                                            employee.setter();
                                            employees.add(employee);
                                            System.out.println("Technician added successfully!");
                                            break;
                                        default:
                                            System.out.println("Invalid choice.");
                                            continue;
                                    }
                                    break;
                                }
                                break;

                            case 2: // Update Employee
                                System.out.print("Enter Employee ID to update: ");
                                int updateId = input.nextInt();
                                input.nextLine();
                                boolean updated = false;

                                for (Employee employeeToUpdate : employees) {
                                    if (employeeToUpdate.getEmployeeId() == updateId) {
                                        employeeToUpdate.update();
                                        System.out.println("Employee updated successfully!");
                                        System.out.println();
                                        updated = true;
                                        break;
                                    }
                                }

                                if (!updated) {
                                    System.out.println("No employee found with ID: " + updateId);
                                    System.out.println();
                                }
                                break;

                            case 3: // Search Employee
                                System.out.print("Enter Employee ID to search: ");
                                int searchId = input.nextInt();
                                input.nextLine();
                                boolean found = false;
                                for (Employee emp : employees) {
                                    if (emp.getEmployeeId() == searchId) {
                                        emp.display();
                                        found = true;
                                        break;
                                    }
                                }
                                if (!found) {
                                    System.out.println("Employee not found.");
                                }
                                break;

                            case 4: // Remove Employee
                                System.out.print("Enter Employee ID to remove: ");
                                int removeId = input.nextInt();
                                input.nextLine();
                                boolean removed = false;

                                for (int i = 0; i < employees.size(); i++) {
                                    if (employees.get(i).getEmployeeId() == removeId) {
                                        employees.remove(i);
                                        System.out.println("Employee removed successfully!");
                                        System.out.println();
                                        removed = true;
                                        break;
                                    }
                                }

                                if (!removed) {
                                    System.out.println("No employee found with ID: " + removeId);
                                    System.out.println();
                                }
                                break;

                            case 5: // Display All Employees
                                if (employees.isEmpty()) {
                                    System.out.println("No employees available.");
                                } else {
                                    for (Employee emp : employees) {
                                        emp.display();
                                        System.out.println("----------------------");
                                    }
                                }
                                break;

                            case 6: // Calculate Bonus
                                System.out.print("Enter Employee ID to calculate bonus: ");
                                int bonusId = input.nextInt();
                                input.nextLine();
                                found = false;
                                for (Employee emp : employees) {
                                    if (emp.getEmployeeId() == bonusId) {
                                        double bonus = emp.calculateBonus();
                                        System.out.println("Bonus for Employee ID " + emp.getEmployeeId() + ": $" + String.format("%.2f", bonus));
                                        found = true;
                                        break;
                                    }
                                }
                                if (!found) {
                                    System.out.println("Employee not found.");
                                }
                                break;

                            case 7: // Display Salary
                                System.out.print("Enter Employee ID to display salary: ");
                                int salaryId = input.nextInt();
                                input.nextLine();
                                found = false;
                                for (Employee emp : employees) {
                                    if (emp.getEmployeeId() == salaryId) {
                                        emp.displaySalary();
                                        found = true;
                                        break;
                                    }
                                }
                                if (!found) {
                                    System.out.println("Employee not found.");
                                }
                                break;
                            case 8:
                                System.out.println("Returning to Main Menu...");
                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } while (employeeChoice != 8);

                case 6:
                    int paymentChoice;
                    do {
                        System.out.println("\n--- Payment Management ---");
                        System.out.println("1. Make Payment");
                        System.out.println("2. Display All Payments");
                        System.out.println("3. Search Payment by ID");
                        System.out.println("4. Generate Receipt");
                        System.out.println("5. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        paymentChoice = input.nextInt();
                        input.nextLine();

                        switch (paymentChoice) {
                            case 1:
                                Payment payment = new Payment();
                                payment.makePayment();
                                payments.add(payment);
                                System.out.println("Payment processed successfully!");
                                break;

                            case 2:
                                if (payments.isEmpty()) {
                                    System.out.println("No payments available.");
                                } else {
                                    System.out.println("\n--- Payment Records ---");
                                    for (Payment p : payments) {
                                        p.displayPaymentDetails();
                                        System.out.println("-------------------");
                                    }
                                }
                                break;

                            case 3:
                                System.out.print("Enter Payment ID to search: ");
                                String searchId = input.nextLine();
                                boolean found = false;
                                for (Payment p : payments) {
                                    if (p.paymentID.equals(searchId)) {
                                        p.displayPaymentDetails();
                                        found = true;
                                        break;
                                    }
                                }
                                if (!found) {
                                    System.out.println("Payment not found.");
                                }
                                break;

                            case 4: // Generate Receipt
                                System.out.print("Enter Payment ID to generate receipt: ");
                                String receiptId = input.nextLine();
                                found = false;
                                for (Payment p : payments) {
                                    if (p.paymentID.equals(receiptId)) {
                                        p.generateReceipt();
                                        found = true;
                                        break;
                                    }
                                }
                                if (!found) {
                                    System.out.println("Payment not found.");
                                }
                                break;

                            case 5:
                                System.out.println("Returning to Main Menu...");
                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } while (paymentChoice != 5);
                    break;

                case 7: {
                    int reportChoice;
                    do {
                        System.out.println("\n--- Reports ---");
                        System.out.println("1. Donor Report");
                        System.out.println("2. Recipient Report");
                        System.out.println("3. Inventory Report");
                        System.out.println("4. Payment Report");
                        System.out.println("5. Activity Report");
                        System.out.println("0. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        reportChoice = input.nextInt();
                        input.nextLine();

                        switch (reportChoice) {
                            case 1:
                                reports.generateDonorReport();
                                break;

                            case 2:
                                reports.generateRecipientReport();
                                break;

                            case 3:
                                reports.generateInventoryReport();
                                break;

                            case 4:
                                reports.generatePaymentReport();
                                break;

                            case 5:
                                reports.generateActivityReport();
                                break;

                            case 0:
                                System.out.println("Returning to main menu.");
                                break;

                            default:
                                System.out.println("Invalid choice. Try again.");
                        }
                    } while (reportChoice != 0);
                    break;
                }

                case 0:
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (mainChoice != 0);

        input.close();
    }
}
