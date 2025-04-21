/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bloodbankmanagement;



/**
 *
 * @author MAHNOOR SARDAR
 */

import java.util.Scanner;

public class Technician extends Employee {
    String role;

    public Technician (){
        super();
        
        role = null;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public void setter(){
        
        super.setter();
        Scanner input = new Scanner(System.in);
        System.out.println("Please specify the area assigned: ");
        role = input.nextLine();
    }

    @Override
    public void update() {
        super.setter();
        Scanner input = new Scanner(System.in);

        System.out.println("Current assigned role: " + this.role);
        System.out.print("Enter new assigned role (or press Enter to keep unchanged): ");
        String newRole = input.nextLine();
        if (!newRole.isEmpty()) {
            this.role = newRole;
        }

        System.out.println("Assigned role updated successfully!");
    }

    @Override
    public void display (){
        
        System.out.println("Employee id: " + getEmployeeId());
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Designation: " + getDesignation());
        System.out.println("Work years: " + getYear());
        System.out.println("Role performed: " + role);
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
