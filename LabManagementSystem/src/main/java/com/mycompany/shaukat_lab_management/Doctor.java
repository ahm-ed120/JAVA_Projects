
package com.mycompany.shaukat_lab_management;

import java.util.Scanner;

public class Doctor extends Employee {
    private String specialization;

    public Doctor() {
        super();
        specialization = null;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        
        this.specialization = specialization;
    }

    @Override
    public void setter() {
        
        super.setter();
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the area of specialization: ");
        specialization = input.nextLine();
    }

    @Override
    public void update() {
        super.update();
        Scanner input = new Scanner(System.in);

        System.out.println("Current area of specialization: " + this.specialization);
        System.out.print("Enter new area of specialization (or press Enter to keep unchanged): ");
        String newSpecialization = input.nextLine();
        if (!newSpecialization.isEmpty()) {
            this.specialization = newSpecialization;
        }

        System.out.println("Specialization updated successfully!");
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
        System.out.println("Specialization: " + specialization);
        System.out.println("Shift: " + getShift());
        System.out.println("Base Salary: " + getSalary());
        System.out.println("Total Salary: " + getTotalSalary());
        

    }

    @Override
    public void displaySalary(){
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
