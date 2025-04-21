package com.mycompany.shaukat_lab_management;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Patient implements PatientManagement {

    private static int referenceCounter = 0;
    private String name;
    private int age;
    private String address;
    private String phoneNo;
    private int invoiceNum;
    private String bloodType;
    private double totalPrice;
    private double totalBill;
    private double monthlyIncome;
    private ArrayList<Test> test;
    private Donations donate;
    private double compensation;

    public Patient() {

        invoiceNum = 0;
        bloodType = null;
        totalPrice = 0.0;
        totalBill = 0.0;
        monthlyIncome = 0.0;
        test = new ArrayList<>();
        donate = new Donations();
        compensation = 0.0;
        referenceCounter++;
    }

    public static int getReferenceCounter() {
        return referenceCounter;
    }

    public static void setReferenceCounter(int referenceCounter) {
        Patient.referenceCounter = referenceCounter;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public ArrayList<Test> getTest() {
        return test;
    }

    public void setTest(ArrayList<Test> test) {
        this.test = test;
    }

    public Donations getDonate() {
        return donate;
    }

    public void setDonate(Donations donate) {
        this.donate = donate;
    }

    public double getCompensation() {
        return compensation;
    }

    public void setCompensation(double compensation) {
        this.compensation = compensation;
    }

    public void setter(ArrayList<Test> availableTest) {

        int found = 0;

        Scanner input = new Scanner(System.in);

        this.invoiceNum = referenceCounter;

        System.out.println("Enter  Patient name:");
        name = input.nextLine();

        while (true) {
            try {
                System.out.println("Enter Patient age: ");
                age = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for age.");
                input.nextLine();
            }
        }

        System.out.println("Enter Patient address: ");
        address = input.nextLine();

        System.out.println("Enter Patient phone number: ");
        phoneNo = input.nextLine();

        System.out.println("Please specify the Blood Group of patient: ");
        bloodType = input.nextLine();

        if (availableTest == null) {
            System.out.println("No test is available!!!");
            return;
        }

        System.out.println("***Test Inventory***");
        for (Test t : availableTest) {
            t.display();
        }

        while (true) {

            int testId = 0;

            while (true) {
                try {
                    System.out.println("Enter test id (or -1 to finish):");
                    testId = input.nextInt();
                    input.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for item id.");
                    input.nextLine();
                }
            }

            if (testId == -1) {
                
                if(test ==  null){
                    System.out.println("Enter atleast one test");
                    continue;
                }
                
                else{
                break;
                }
            }

            Test selectedItem = null;

            for (Test t : availableTest) {
                if (testId == t.getTestId()) {
                    selectedItem = t;
                    break;
                }
            }

            if (selectedItem == null) {
                System.out.println("Invalid Test id. Try again.");
                continue;
            }

            test.add(selectedItem);
            totalPrice += selectedItem.getPrice();
        }

        while (true) {
            System.out.println("Do you want to apply for compensation? (y/n)");
            String inputString = input.next().toLowerCase();

            if (inputString.length() == 1) {
                char option = inputString.charAt(0);

                if (option == 'y') {

                    while (true) {
                        try {
                            System.out.println("Enter your monthly income: ");
                            monthlyIncome = input.nextInt();
                            input.nextLine();
                            checkValidity();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid integer for monthly income.");
                            input.nextLine();
                        }
                    }
                    break;
                } else if (option == 'n') {
                    System.out.println("Not applied for compensation.");
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
                }
            } else {
                System.out.println("Error! Please enter a single character ('y' or 'n').");
            }
        }

        if (compensation > 0.0) {

            if (compensation <= Donations.getTotalBalance()) {

                totalBill = totalPrice - compensation;

                double totalBalance = Donations.getTotalBalance() - compensation;

                Donations.setTotalBalance(totalBalance);
                System.out.println("Compensation of $" + String.format("%.2f", compensation) + " applied successfully.");
            } else {
                System.out.println("Not enough funds in the donation account to cover the compensation.");
                totalBill = totalPrice;
            }
        } else {
            totalBill = totalPrice;
        }
    }

    public void update(ArrayList<Test> availableTest) {

        double retransmitt = Donations.getTotalBalance() + compensation;

        Donations.setTotalBalance(retransmitt);

        Scanner input = new Scanner(System.in);

        System.out.println("Updating patient details...");

        System.out.println("Current Name: " + name);
        System.out.println("Enter new name (or press Enter to keep current):");
        String newName = input.nextLine();
        if (!newName.isEmpty()) {
            name = newName;
        }

        System.out.println("Current age: " + this.age);
        while (true) {
            System.out.print("Enter new age (or press Enter to keep unchanged): ");
            String ageInput = input.nextLine();
            if (ageInput.isEmpty()) {
                break;
            }
            try {
                this.age = Integer.parseInt(ageInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer for age.");
            }
        }

        System.out.println("Current Address: " + address);
        System.out.println("Enter new address (or press Enter to keep current):");
        String newAddress = input.nextLine();
        if (!newAddress.isEmpty()) {
            address = newAddress;
        }

        System.out.println("Current Phone Number: " + phoneNo);
        System.out.println("Enter new phone number (or press Enter to keep current):");
        String newPhoneNo = input.nextLine();
        if (!newPhoneNo.isEmpty()) {
            phoneNo = newPhoneNo;
        }

        System.out.println("Updating tests...");
        test.clear();
        totalPrice = 0.0;

        while (true) {

            int testId = 0;

            while (true) {
                try {
                    System.out.println("Enter test id (or -1 to finish):");
                    testId = input.nextInt();
                    input.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for item id.");
                    input.nextLine();
                }
            }
            if (testId == -1) {
                if (test == null) {
                    System.out.println("Enter atleast one test");
                    continue;
                } else {
                    break;
                }
            }

            Test selectedItem = null;
            for (Test t : availableTest) {
                if (testId == t.getTestId()) {
                    selectedItem = t;
                    break;
                }
            }

            if (selectedItem == null) {
                System.out.println("Invalid Test id. Try again.");
                continue;
            }
            test.add(selectedItem);
            totalPrice += selectedItem.getPrice();
        }

        while (true) {
            System.out.println("Do you want to apply for compensation? (y/n)");
            String inputString = input.next().toLowerCase();

            if (inputString.length() == 1) {
                char option = inputString.charAt(0);

                if (option == 'y') {

                    while (true) {
                        try {
                            System.out.println("Enter your monthly income: ");
                            monthlyIncome = input.nextInt();
                            input.nextLine();
                            checkValidity();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid integer for monthly income.");
                            input.nextLine();
                        }
                    }
                    break;
                } else if (option == 'n') {
                    System.out.println("Not applied for compensation.");
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
                }
            } else {
                System.out.println("Error! Please enter a single character ('y' or 'n').");
            }
        }

        if (compensation > 0.0) {

            if (compensation <= Donations.getTotalBalance()) {

                totalBill = totalPrice - compensation;

                double totalBalance = Donations.getTotalBalance() - compensation;

                Donations.setTotalBalance(totalBalance);
                System.out.println("Compensation of $" + String.format("%.2f", compensation) + " applied successfully.");
            } else {
                System.out.println("Not enough funds in the donation account to cover the compensation.");
                totalBill = totalPrice;
            }
        } else {
            totalBill = totalPrice;
        }
        System.out.println("Patient details updated successfully.");
    }

    public void checkValidity() {

        if (monthlyIncome <= 40000) {
            compensation = totalPrice * 0.50;
        }
    }

    @Override
    public void generateReport() {

        System.out.println("Patient Report");
        System.out.println("---------------");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNo);
        System.out.println("Blood Type: " + bloodType);
        System.out.println("Total Tests: " + test.size());
        System.out.println("Tests:");
        for (Test t : test) {
            System.out.println("  - " + t.getName() + " ($" + String.format("%.2f", t.getPrice()) + ")");
        }
        System.out.println("Total Price: $" + String.format("%.2f", totalPrice));
        System.out.println("Compensation: $" + String.format("%.2f", compensation));
        System.out.println("Total Bill: $" + String.format("%.2f", totalBill));
        System.out.println("---------------");
    }

    public void display(){
        System.out.println("--------- Patient Details ---------");
        System.out.println("Invoice Number: " + invoiceNum);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNo);
        System.out.println("Blood Type: " + bloodType);
        System.out.println("Total Tests: " + test.size());
        System.out.println("Total Bill: $" + String.format("%.2f", totalBill));
        System.out.println("-----------------------------------");
    }
    
}


