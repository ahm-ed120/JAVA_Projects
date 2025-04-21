/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bloodbankmanagement;


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MAHNOOR SARDAR
 */
public interface ManageAppointment {
   public void schedule(ArrayList<Doctor> doctors, Scanner input);
   public void reschedule(Scanner input);
   public void cancelAppointment();
}