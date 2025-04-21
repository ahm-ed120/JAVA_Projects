
package com.mycompany.shaukat_lab_management;


import java.util.Scanner;

public class Janitor extends Employee {
    String area;

    public Janitor (){
        super();
        
        area = null;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public void setter(){
        
        super.setter();
        Scanner input = new Scanner(System.in);
        System.out.println("Please specify the area assigned: ");
        area = input.nextLine();
    }

    @Override
    public void update() {
        super.setter();
        Scanner input = new Scanner(System.in);

        System.out.println("Current assigned area: " + this.area);
        System.out.print("Enter new assigned area (or press Enter to keep unchanged): ");
        String newArea = input.nextLine();
        if (!newArea.isEmpty()) {
            this.area = newArea;
        }

        System.out.println("Assigned area updated successfully!");
    }

    @Override
    public void display (){
        
        System.out.println("Employee id: " + getEmployeeId());
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNo);
        System.out.println("Designation: " + getDesignation());
        System.out.println("Work years: " + getYear());
        System.out.println("Area of work: " + area);
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
