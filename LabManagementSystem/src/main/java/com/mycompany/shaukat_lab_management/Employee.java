
package com.mycompany.shaukat_lab_management;

import java.util.Scanner;

public class Employee extends Person implements EmployeeManagement {
    
    private int employeeId;
    private double salary;
    private int year;
    private double totalSalary;
    private double bonus;
    private String shift;
    private String designation;

    Employee() {
        super();
        employeeId = 0;
        salary = 0.0;
        year = 0;
        totalSalary = 0.0;
        bonus = 0.0;
        shift = null;
        designation = null;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getShift() {
        return shift;
    }

    public String getDesignation() {
        return designation;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    

    @Override
    public void setter() {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter employee id: ");
                employeeId = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for employee id.");
                input.nextLine();
            }
        }

        System.out.println("Enter name:");
        name = input.nextLine();

        while (true) {
            try {
                System.out.println("Enter age: ");
                age = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for age.");
                input.nextLine();
            }
        }

        System.out.println("Enter address: ");
        address = input.nextLine();

        System.out.println("Enter phone number: ");
        phoneNo = input.nextLine();

        while (true) {
            try {
                System.out.println("Enter the number of year you have worked with us: ");
                year = input.nextInt();
                input.nextLine();
                break;
            } 
            catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for number of years.");
                input.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("Enter salary: ");
                salary = input.nextDouble();
                input.nextLine();
                break;
            } 
            catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number for salary.");
                input.nextLine();
            }
        }
        
        System.out.println("Enter Employee Designation: ");
        designation = input.nextLine();
        
        System.out.println("Enter Employee Shift: ");
        shift = input.nextLine();

        bonus = calculateBonus();
        totalSalary = salary + bonus;

    }

    @Override
    public void update() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nUpdating Employee Details...");


        System.out.println("Current Employee ID: " + this.employeeId);
        while (true) {
            System.out.print("Enter new employee ID (or press Enter to keep unchanged): ");
            String idInput = input.nextLine();
            if (idInput.isEmpty()) {
                break;
            }
            try {
                this.employeeId = Integer.parseInt(idInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer for Employee ID.");
            }
        }


        System.out.println("Current Name: " + this.name);
        System.out.print("Enter new name (or press Enter to keep unchanged): ");
        String newName = input.nextLine();
        if (!newName.isEmpty()) {
            this.name = newName;
        }


        System.out.println("Current Age: " + this.age);
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


        System.out.println("Current Address: " + this.address);
        System.out.print("Enter new address (or press Enter to keep unchanged): ");
        String newAddress = input.nextLine();
        if (!newAddress.isEmpty()) {
            this.address = newAddress;
        }


        System.out.println("Current Phone Number: " + this.phoneNo);
        System.out.print("Enter new phone number (or press Enter to keep unchanged): ");
        String newPhoneNo = input.nextLine();
        if (!newPhoneNo.isEmpty()) {
            this.phoneNo = newPhoneNo;
        }


        System.out.println("Years Worked: " + this.year);
        while (true) {
            System.out.print("Enter the number of years worked (or press Enter to keep unchanged): ");
            String yearInput = input.nextLine();
            if (yearInput.isEmpty()) {
                break;
            }
            try {
                this.year = Integer.parseInt(yearInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer for years worked.");
            }
        }

 
        System.out.println("Current Salary: " + this.salary);
        while (true) {
            System.out.print("Enter new salary (or press Enter to keep unchanged): ");
            String salaryInput = input.nextLine();
            if (salaryInput.isEmpty()) {
                break;
            }
            try {
                this.salary = Double.parseDouble(salaryInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for salary.");
            }
        }

        System.out.println("Current Designation: " + this.designation);
        System.out.print("Enter new designation (or press Enter to keep unchanged): ");
        String newDesignation = input.nextLine();
        if (!newDesignation.isEmpty()) {
            this.designation = newDesignation;
        }

        System.out.println("Current Shift: " + this.shift);
        System.out.print("Enter new shift (or press Enter to keep unchanged): ");
        String newShift = input.nextLine();
        if (!newShift.isEmpty()) {
            this.shift = newShift;
        }

        bonus = calculateBonus();
        totalSalary = salary + bonus;
    }


    @Override
    public void display() {
        System.out.println("Employee id: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNo);
        System.out.println("Designation: " + designation);
        System.out.println("Work years: " + year);
        System.out.println("Shift: " + shift);
        System.out.println("Base Salary: " + salary);
        System.out.println("Total Salary: " + totalSalary);
        
    }

    @Override
    public double calculateBonus() {
        double bonusPercentage;

        if (year >= 10) {
            bonusPercentage = 0.20;
        } else if (year >= 5) {
            bonusPercentage = 0.10;
        } else if (year >= 2) {
            bonusPercentage = 0.05;
        } else {
            bonusPercentage = 0.02;
        }
        
        switch (designation.toLowerCase()) {
            
        case "doctor":
            bonusPercentage += 0.10; 
            break;
            
        case "janitor":
            bonusPercentage += 0.02; 
            break;
            
        case "labassistant":
        case "lab assistant":
            bonusPercentage += 0.05; 
            break;
            
        default:
            break;
    }

        return salary * bonusPercentage;

    }

    @Override
    public void displaySalary() {
        System.out.println("\n---------------------------------------------------------------------");
        System.out.println("Employee ID        : " + employeeId);
        System.out.println("Employee Name      : " + name);
        System.out.println("Designation        : " + designation);
        System.out.println("Work years: " + year);
        System.out.println("Base Salary        : $" + String.format("%.2f", salary));
        System.out.println("Bonus              : $" + String.format("%.2f", bonus));
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Total Salary       : $" + String.format("%.2f", totalSalary));
        System.out.println("----------------------------------------------------------------------");

    }

}
