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

public class Doctor extends Employee {
    public String specialty;

    public Doctor() {
        super();
        specialty = null;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        
        this.specialty = specialty;
    }

    @Override
    public void setter() {
        
        super.setter();
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the area of specialization: ");
        specialty = input.nextLine();
    }

  
    @Override
    public void update() {
        super.update();
        Scanner input = new Scanner(System.in);

        System.out.println("Current area of specialization: " + this.specialty);
        System.out.print("Enter new area of specialization (or press Enter to keep unchanged): ");
        String newSpecialty = input.nextLine();
        if (!newSpecialty.isEmpty()) {
            this.specialty = newSpecialty;
        }

        System.out.println("Specialty updated successfully!");
    }
}