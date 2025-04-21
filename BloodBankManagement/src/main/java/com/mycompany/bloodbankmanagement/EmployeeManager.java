/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bloodbankmanagement;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @param <T> The type of Employee (Doctor, Nurse, Technician)
 */
public class EmployeeManager<T extends Employee> {
    private List<T> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public void addEmployee(T employee) {
        employees.add(employee);
    }

    public boolean isEmpty() {
    return employees.isEmpty(); 
}

public List<T> getEmployees() {
    return employees;  
}

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees available.");
        } else {
            System.out.println("\n--- Employee Records ---");
            for (T employee : employees) {
                employee.display();
                System.out.println("-------------------");
            }
        }
    }

    public T searchEmployee(String id) {
        for (T employee : employees) {
            if (employee.id.equals(id)) {
                return employee;
            }
        }
        return null; 
    }

    public boolean removeEmployee(String id) {
        T employee = searchEmployee(id);
        if (employee != null) {
            employees.remove(employee);
            return true;
        }
        return false;
    }
}

