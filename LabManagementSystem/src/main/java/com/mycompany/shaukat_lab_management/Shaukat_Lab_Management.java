
package com.mycompany.shaukat_lab_management;

import java.util.ArrayList;
import java.util.Scanner;


public class Shaukat_Lab_Management{
    

    
public static void main(String[] args) {
   
    Scanner input = new Scanner(System.in);
    
    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<Test> tests = new ArrayList<>();
    ArrayList<Patient> patients = new ArrayList<>();
    ArrayList<Donations> donations = new ArrayList<>();
    
    Patient pat;
    Employee emp;
    Donations don;
    Test t;
    
        int choiceAtManage;
        int choiceAtSearch;
        int choiceAtPatientMenu;
        int choiceAtEmployeeMenu;
        int choiceAtDonationMenu;
        int choiceAtTestMenu;
        int empChoice;
        int choiceAtGenerate;

    int mainChoice;

    do{
        System.out.println("\n--- Shaukat Khanum Lab Management System ---");
        System.out.println("1. Manage Data");
        System.out.println("2. Search data");
        System.out.println("3. Generate Reports");
        System.out.println("4. Exit Managemenet System");
        
        while (true) {
            try {
                System.out.println("Enter your choice: ");
                input = new Scanner(System.in);
                mainChoice = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input.Try again.");
                input.nextLine();
            }
        }
        
        
        switch(mainChoice){
            case 1:
                    
                do {
                    System.out.println();
                    System.out.println("1. Manage Employees");
                    System.out.println("2. Manage Tests");
                    System.out.println("3. Manage Patients");
                    System.out.println("4. Manage Donations");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice: ");

                    while (true) {
                        try {
                            input = new Scanner(System.in);
                            choiceAtManage = input.nextInt();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid Input.Try again.");
                            input.nextLine();
                        }
                    }

                    switch (choiceAtManage) {
                        case 1: // Employee Management
                            do {
                                System.out.println("\n--- Employee Management ---");
                                System.out.println("1. Add Employee");
                                System.out.println("2. Update Employee");
                                System.out.println("3. Remove Employee");
                                System.out.println("4. Display Employees");
                                System.out.println("5. Back to Main Menu");
                                System.out.print("Enter your choice: ");
                                while (true) {
                                    try {
                                        input = new Scanner(System.in);
                                        choiceAtEmployeeMenu = input.nextInt();
                                        input.nextLine();
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Input.Try again.");
                                        input.nextLine();
                                    }
                                }

                                switch (choiceAtEmployeeMenu) {
                                    case 1: 
                                        while(true){
                                        System.out.println("1. Add Doctor");
                                        System.out.println("2. Add Janitor");
                                        System.out.println("3. Add Lab Assistant");
                                        System.out.print("Enter your choice: ");
                                            while (true) {
                                                try {
                                                    input = new Scanner(System.in);
                                                    empChoice = input.nextInt();
                                                    input.nextLine();
                                                    break;
                                                } catch (Exception e) {
                                                    System.out.println("Invalid Input.Try again.");
                                                    input.nextLine();
                                                }
                                            }

                                        switch (empChoice) {
                                            case 1:
                                                emp = new Doctor();
                                                break;
                                            case 2:
                                                emp = new Janitor();
                                                break;
                                            case 3:
                                                emp = new LabAssistant();
                                                break;
                                            default:
                                                System.out.println("Invalid choice.");
                                                continue;
                                        }
                                        

                                        emp.setter();
                                        employees.add(emp);
                                        System.out.println("Employee added successfully!");
                                        System.out.println();
                                        break;
                                        }
                                        break;


                                    case 2:
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
                                     
                                    case 3:
                                        
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

                                    case 4:
                                        
                                        if(employees != null){
                                        System.out.println("\n--- Employee List ---");
                                        for (Employee employee : employees) {
                                            employee.display();
                                            System.out.println("-----------------------------------");                                            
                                        }
                                        }
                                        
                                        else{
                                            System.out.println("No employee to display");
                                        }
                                        break;

                                    case 5:
                                        System.out.println("Returning to Main Menu...");
                                        System.out.println();
                                        break;

                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                        System.out.println();
                                }
                            } while (choiceAtEmployeeMenu != 5);
                            break;

                        case 2:
                            do {
                                System.out.println("\n--- Test Management ---");
                                System.out.println("1. Add Test");
                                System.out.println("2. Update Test");
                                System.out.println("3. Remove Test");
                                System.out.println("4. Display Tests");
                                System.out.println("5. Back to Main Menu");
                                System.out.print("Enter your choice: ");
                                 while (true) {
                                    try {
                                        input = new Scanner(System.in);
                                        choiceAtTestMenu = input.nextInt();
                                        input.nextLine();
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Input.Try again.");
                                        input.nextLine();
                                    }
                                }

                                switch (choiceAtTestMenu) {
                                    case 1:
                                        t = new Test();
                                        t.setter();
                                        tests.add(t);
                                        System.out.println("Test added successfully!");
                                        System.out.println();
                                        break;
                                    
                                    
                                    case 2:
                                        
                                        System.out.print("Enter Test ID to update: ");
                                        int updateId = input.nextInt();
                                        input.nextLine();
                                        boolean updated = false;

                                        for (Test test : tests) {
                                            if (test.getTestId() == updateId) {
                                                test.update();
                                                System.out.println("Test updated successfully!");
                                                System.out.println();
                                                updated = true;
                                                break;
                                            }
                                        }

                                        if (!updated) {
                                            System.out.println("No test found with ID: " + updateId);
                                            System.out.println();
                                        }
                                        break;   
                                        
                                        
                                    case 3:
                                        System.out.print("Enter Test ID to remove: ");
                                        int removeId = input.nextInt();
                                        input.nextLine();
                                        boolean removed = false;

                                        for (int i = 0; i < tests.size(); i++) {
                                            if (tests.get(i).getTestId() == removeId) {
                                                tests.remove(i);
                                                System.out.println("Test removed successfully!");
                                                System.out.println();
                                                removed = true;
                                                break;
                                            }
                                        }

                                        if (!removed) {
                                            System.out.println("No test found with ID: " + removeId);
                                            System.out.println();
                                        }
                                        break;

                                    case 4:
                                        if(tests != null){
                                        System.out.println("\n--- Test List ---");
                                        for (Test test : tests) {
                                            test.display();
                                            System.out.println("-----------------------------------");
                                        }
                                        }
                                        
                                        else{
                                            System.out.println("No test to display");
                                        }
                                        break;

                                    case 5:
                                        System.out.println("Returning to Main Menu...");
                                        System.out.println();
                                        break;

                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                }
                            } while (choiceAtTestMenu != 5);
                            break;

                        case 3: // Patient Management
                            do {
                                System.out.println("\n--- Patient Management ---");
                                System.out.println("1. Add Patient");
                                System.out.println("2. Update Patient");
                                System.out.println("3. Remove Patient");
                                System.out.println("4. Display Patients");
                                System.out.println("5. Back to Main Menu");
                                System.out.print("Enter your choice: ");
                                while (true) {
                                    try {
                                        input = new Scanner(System.in);
                                        choiceAtPatientMenu = input.nextInt();
                                        input.nextLine();
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Input.Try again.");
                                        input.nextLine();
                                    }
                                }

                                switch (choiceAtPatientMenu) {
                                    case 1: // Add Patient
                                        pat = new Patient();
                                        pat.setter(tests);
                                        patients.add(pat);
                                        System.out.println("Patient added successfully!");
                                        System.out.println();
                                        break;
                                    
                                    case 2: // Update Patient
                                        System.out.print("Enter Patient Invoice Number to update: ");
                                        int updateInvoice = input.nextInt();
                                        input.nextLine();
                                        boolean updated = false;

                                        for (Patient patient : patients) {
                                            if (patient.getInvoiceNum() == updateInvoice) {
                                                patient.update(tests);
                                                System.out.println("Patient updated successfully!");
                                                System.out.println();
                                                updated = true;
                                                break;
                                            }
                                        }

                                        if (!updated) {
                                            System.out.println("No patient found with Invoice Number: " + updateInvoice);
                                            System.out.println();
                                        }
                                        break;            
                                        
                                    case 3: // Remove Patient
                                        System.out.print("Enter Patient Invoice Number to remove: ");
                                        int removeInvoice = input.nextInt();
                                        input.nextLine();
                                        boolean removed = false;

                                        for (int i = 0; i < patients.size(); i++) {
                                            if (patients.get(i).getInvoiceNum() == removeInvoice) {
                                                patients.remove(i);
                                                System.out.println("Patient removed successfully!");
                                                System.out.println();
                                                removed = true;
                                                break;
                                            }
                                        }

                                        if (!removed) {
                                            System.out.println("No patient found with Invoice Number: " + removeInvoice);
                                            System.out.println();
                                        }
                                        break;

                                    case 4: // Display Patients
                                        
                                        if(patients != null){
                                        System.out.println("\n--- Patient List ---");
                                        for (Patient patient : patients) {
                                            patient.display();
                                            System.out.println("-----------------------------------");
                                        }
                                        }
                                        
                                        else {
                                            System.out.println("No Patient to display");
                                        }
                                        break;

                                    case 5:
                                        System.out.println("Returning to Main Menu...");
                                        break;

                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                }
                            } while (choiceAtPatientMenu != 5);
                            break;

                        case 4: // Donations Management
                            do {
                                System.out.println("\n--- Donations Management ---");
                                System.out.println("1. Add Donations");
                                System.out.println("2. Update Donations");
                                System.out.println("3. remove Donations");
                                System.out.println("4. display Donations");
                                System.out.println("5. Back to Main Menu");
                                System.out.print("Enter your choice: ");
                                while (true) {
                                    try {
                                        input = new Scanner(System.in);
                                        choiceAtDonationMenu = input.nextInt();
                                        input.nextLine();
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Input.Try again.");
                                        input.nextLine();
                                    }
                                }

                                switch (choiceAtDonationMenu) {
                                    case 1: // Add Donations
                                        don = new Donations();
                                        don.setter();
                                        donations.add(don);
                                        System.out.println("Patient added successfully!");
                                        System.out.println();
                                        break;

                                    case 2: //Update Donations
                                        System.out.print("Enter Donar Account Number to update: ");
                                        int updateAcc = input.nextInt();
                                        input.nextLine();
                                        boolean updated = false;

                                        for (Donations donationToUpdate : donations) {
                                            if (donationToUpdate.getAccountNo() == updateAcc) {
                                                donationToUpdate.update();
                                                System.out.println("Donar updated successfully!");
                                                System.out.println();
                                                updated = true;
                                                break;
                                            }
                                        }
                                        
                                        if (!updated) {
                                            System.out.println("No Donar found with Account: " + updateAcc);
                                            System.out.println();
                                        }
                                        break;
                                    
                                    case 3: // Remove Donar
                                        System.out.print("Enter Donar Account Number to remove: ");
                                        int removeAcc = input.nextInt();
                                        input.nextLine();
                                        boolean removed = false;

                                        for (int i = 0; i < donations.size(); i++) {
                                            if (donations.get(i).getAccountNo() == removeAcc) {
                                                
                                                Double balance = Donations.getTotalBalance() - donations.get(i).getAmount();

                                                Donations.setTotalBalance(balance);
                                                
                                                donations.remove(i);
                                                System.out.println("Donar removed successfully!");
                                                System.out.println();
                                                removed = true;
                                                break;
                                            }
                                        }

                                        if (!removed) {
                                            System.out.println("No Donar found with Account Number: " + removeAcc);
                                            System.out.println();
                                        }
                                        break;
                                    
                                    case 4: // Display Donation
                                        if(donations != null){
                                        System.out.println("\n--- Donation List ---");
                                        for (Donations donationToDisplay : donations) {
                                            donationToDisplay.display();
                                            System.out.println("-----------------------------------");
                                        }
                                        }
                                        
                                        else {
                                            System.out.println("No donar to display");
                                        }
                                        
                                        break;
               
                                    case 5:
                                        System.out.println("Returning to Main Menu...");
                                        break;

                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                }
                            } while (choiceAtDonationMenu != 5);
                            break;

                        case 5:
                            System.out.println("Exiting Lab Management System. Goodbye!");
                            System.out.println();
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                            System.out.println();
                    }
                } while (choiceAtManage != 5);
                
                break;
            
            case 2:
                do {
                    System.out.println();
                    System.out.println("1. Search Employees");
                    System.out.println("2. Search Tests");
                    System.out.println("3. Search Patients");
                    System.out.println("4. Search Donations");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice: ");

                    while (true) {
                        try {
                            input = new Scanner(System.in);
                            choiceAtSearch = input.nextInt();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid Input.Try again.");
                            input.nextLine();
                        }
                    }
                    
                    switch(choiceAtSearch){
                        
                        case 1:
                            
                            System.out.println("Enter ID number of employee to search: ");
                            int employeeSearch = input.nextInt();
                            boolean found = false;

                            for (Employee employeeToSearch : employees) {
                                if (employeeSearch == employeeToSearch.getEmployeeId()) {
                                    employeeToSearch.display();
                                    System.out.println();
                                    found = true; 
                                    break; 
                                }
                            }

                            if (!found) {
                                System.out.println("Employee with ID " + employeeSearch + " not found.");
                            }
                            break;
                            
                        case 2:
                            
                            System.out.println("Enter ID number of test to search: ");
                            int testSearch = input.nextInt();
                            boolean foundt = false;

                            for (Test testToSearch : tests) {
                                if (testSearch == testToSearch.getTestId()) {
                                    testToSearch.display();
                                    System.out.println();
                                    foundt = true; 
                                    break; 
                                }
                            }

                            if (!foundt) {
                                System.out.println("Test with ID " + testSearch + " not found.");
                            }
                            break;
                            
                        case 3:

                            System.out.println("Enter Invoice number of patient to search: ");
                            int patientSearch = input.nextInt();
                            boolean foundp = false;

                            for (Patient patientToSearch : patients) {
                                if (patientSearch == patientToSearch.getInvoiceNum()) {
                                    patientToSearch.display();
                                    System.out.println();
                                    foundp = true;
                                    break;
                                }
                            }

                            if (!foundp) {
                                System.out.println("Patient with Invoice " + patientSearch + " not found.");
                            }
                            break;
                            
                        case 4:

                            System.out.println("Enter donar account number to search: ");
                            int donarSearch = input.nextInt();
                            boolean foundd = false;

                            for (Donations donationToSearch : donations) {
                                if (donarSearch == donationToSearch.getAccountNo()) {
                                    donationToSearch.display();
                                    System.out.println();
                                    foundd = true;
                                    break;
                                }
                            }

                            if (!foundd) {
                                System.out.println("Donar with Account " + donarSearch + " not found.");
                            }
                            break;
                            
                        case 5:
                            System.out.println("Exiting Lab Searching System. Goodbye!");
                            System.out.println();
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                            System.out.println();
                    }  
                } while (choiceAtSearch != 5);
                break;
                
            case 3:
                
                do {
                    System.out.println();
                    System.out.println("1. Generate Employee Report");
                    System.out.println("2. Generate Test Report");
                    System.out.println("3. Generate Patient Report");
                    System.out.println("4. Generate Donation Report");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice: ");

                    while (true) {
                        try {
                            input = new Scanner(System.in);
                            choiceAtGenerate = input.nextInt();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid Input.Try again.");
                            input.nextLine();
                        }
                    }
                    
                    switch(choiceAtGenerate){
                        
                        case 1:
                            
                            System.out.print("Enter Employee ID to Generate Report: ");
                            int empId = input.nextInt();
                            input.nextLine();
                            boolean report = false;

                            for (Employee employeeDisplay : employees) {
                                if (employeeDisplay.getEmployeeId() == empId) {
                                    employeeDisplay.displaySalary();
                                    System.out.println();
                                    report = true;
                                    break;
                                }
                            }
                            
                            if (!report) {
                                System.out.println("No employee found with ID: " + empId);
                                System.out.println();
                            }
                            
                            break;
                        
                        case 2:
                            Test.generateReport(tests);
                            break;
                            
                        case 3:
                            
                            System.out.print("Enter Patient's Invoice number to Generate Report: ");
                            int patId = input.nextInt();
                            input.nextLine();
                            boolean reportP = false;

                            for (Patient patientDisplay : patients) {
                                if (patientDisplay.getInvoiceNum()== patId) {
                                    patientDisplay.generateReport();
                                    System.out.println();
                                    reportP = true;
                                    break;
                                }
                            }

                            if (!reportP) {
                                System.out.println("No Patient found with Incoice Number: " + patId);
                                System.out.println();
                            }
                            
                            break;
                        
                        case 4:
                            Donations.generateReport(donations);
                            
                            break;
                            
                        case 5:
                            System.out.println("Exiting Lab Reporting System. Goodbye!");
                            System.out.println();
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                            System.out.println();     
                    }
                }while(choiceAtGenerate != 5);
                    
                break;
                
            case 5:
                System.out.println("Exiting Shaukat Khanum Lab Management System. Goodbye!");
                System.out.println();
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                System.out.println();      
        }   
    }while(mainChoice != 4);
}
}