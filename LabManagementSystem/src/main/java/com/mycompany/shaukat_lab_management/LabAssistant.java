package com.mycompany.shaukat_lab_management;

import java.util.ArrayList;
import java.util.Scanner;

public class LabAssistant extends Employee {

    ArrayList<String> testsAssigned;

    public LabAssistant() {
        super();
        testsAssigned = new ArrayList<>();
    }

    public ArrayList<String> getTestsAssigned() {
        return testsAssigned;
    }

    public void setTestsAssigned(ArrayList<String> testsAssigned) {
        this.testsAssigned = testsAssigned;
    }

    @Override
    public void setter() {

        super.setter();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the test names assigned to you (enter '-1' to finish):");

        while (true) {
            String test = input.nextLine();

            if (test.equals("-1")) {
                break;
            }
            testsAssigned.add(test);
        }
    }

    @Override
    public void update() {

        Scanner input = new Scanner(System.in);

        System.out.println("\nUpdating Lab Assistant Details...");

        super.update();

        System.out.println("Current tests assigned:");

        for (int i = 0; i < testsAssigned.size(); i++) {
            System.out.println((i + 1) + ". " + testsAssigned.get(i));
        }

        System.out.println("Do you want to update a specific test? (yes/no):");
        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            while (true) {
                System.out.println("Enter the number of the test to update (or -1 to finish):");
                int index;

                try {
                    index = input.nextInt();
                    input.nextLine();
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    input.nextLine();
                    continue;
                }

                if (index == -1) {
                    break;
                }

                if (index > 0 && index <= testsAssigned.size()) {
                    System.out.println("Enter the updated name for test " + testsAssigned.get(index - 1) + ":");
                    String newTestName = input.nextLine();
                    testsAssigned.set(index - 1, newTestName);
                    System.out.println("Test updated successfully.");
                } else {
                    System.out.println("Invalid test number. Please try again.");
                }
            }
        } else if (choice.equalsIgnoreCase("no")) {
            testsAssigned.clear();
            System.out.println("Enter the updated test names assigned to you (enter '-1' to finish):");

            while (true) {
                String test = input.nextLine();
                if (test.equals("-1")) {
                    break;
                }
                testsAssigned.add(test);
            }

            System.out.println("Lab Assistant tests updated successfully!");
        } else {
            System.out.println("Invalid choice. No changes made to the tests.");
        }
    }

    @Override
    public void display() {
        System.out.println("Employee id: " + getEmployeeId());
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNo);
        System.out.println("Designation: " + getDesignation());
        System.out.println("Work years: " + getYear());
        System.out.println("Assigned Tests: ");

        if (testsAssigned.isEmpty()) {

            System.out.println("  No tests assigned.");
        } else {
            for (String test : testsAssigned) {

                System.out.println("  - " + test);
            }
        }
        System.out.println("Shift: " + getShift());
        System.out.println("Base Salary: " + getSalary());
        System.out.println("Total Salary: " + getTotalSalary());
    }

    @Override
    public void displaySalary() {
        System.out.println("\n---------------------------------------------------------------------");
        System.out.println("Employee ID        : " + getEmployeeId());
        System.out.println("Employee Name      : " + name);
        System.out.println("Employee Type      : " + getDesignation());
        System.out.println("Work years         : " + getYear());
        System.out.println("Base Salary        : $" + String.format("%.2f", getSalary()));
        System.out.println("Bonus              : $" + String.format("%.2f", getBonus()));
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Total Salary       : $" + String.format("%.2f", getTotalSalary()));
        System.out.println("----------------------------------------------------------------------");

    }
}
