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

public class Nurse extends Employee {
    String department;

    public Nurse (){
        super();
        
        department = null;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void setter(){
        
        super.setter();
        Scanner input = new Scanner(System.in);
        System.out.println("Please specify department: ");
        department = input.nextLine();
    }

    @Override
    public void update() {
        super.setter();
        Scanner input = new Scanner(System.in);

        System.out.println("Current department: " + this.department);
        System.out.print("Enter new department (or press Enter to keep unchanged): ");
        String newDepartment = input.nextLine();
        if (!newDepartment.isEmpty()) {
            this.department = newDepartment;
        }

        System.out.println("Department updated successfully!");
    }

    @Override
    public void display (){
        
        System.out.println("Employee id: " + getEmployeeId());
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Designation: " + getDesignation());
        System.out.println("Work years: " + getYear());
        System.out.println("Department : " + department);
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
