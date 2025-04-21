
package com.mycompany.shaukat_lab_management;

import java.util.ArrayList;
import java.util.Scanner;


public class Donations {

    private static double totalBalance = 0.0;
    private int accountNo;
    private double amount;
    private String donorName;
    private String donorPhone;

    public Donations() {
        
        this.accountNo = 0;
        this.amount = 0.0;
        this.donorName = null;
        this.donorPhone = null;
    }

    public static double getTotalBalance() {
        return totalBalance;
    }

    public static void setTotalBalance(double totalBalance) {
        Donations.totalBalance = totalBalance;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonorPhone() {
        return donorPhone;
    }

    public void setDonorPhone(String donorPhone) {
        this.donorPhone = donorPhone;
    }
    
    public void setter(){
         Scanner input = new Scanner(System.in);

        System.out.println("Enter donor name:");
        this.donorName = input.nextLine();

        System.out.println("Enter donor phone number:");
        this.donorPhone = input.nextLine();

        while (true) {
            try {
                System.out.println("Enter account number:");
                accountNo = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for account number.");
                input.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("Enter donation amount:");
                amount = input.nextDouble();
                input.nextLine();
                totalBalance += amount;
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number for donation amount.");
                input.nextLine();
            }
        }

        System.out.println("Donation details successfully recorded!");
    }
    
    public void update() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nUpdating donation details...");

        System.out.println("Current donor name: " + this.donorName);
        System.out.print("Enter new donor name (or press Enter to keep unchanged): ");
    
        String newDonorName = input.nextLine();
        
        if (!newDonorName.isEmpty()) {
            this.donorName = newDonorName;
        }

        System.out.println("Current donor phone: " + this.donorPhone);
        System.out.print("Enter new donor phone number (or press Enter to keep unchanged): ");
        String newDonorPhone = input.nextLine();
    
        if (!newDonorPhone.isEmpty()) {
            this.donorPhone = newDonorPhone;
        }
             
        System.out.println("Current account number: " + this.accountNo);
        while (true) {
            System.out.print("Enter new account number (or press Enter to keep unchanged): ");
            String accountInput = input.nextLine();

            if (accountInput.isEmpty()) {
                break; 
            }
            try {
                this.accountNo = Integer.parseInt(accountInput);
                break; 
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer for account number.");
            }
        }
        
        System.out.print("\nDo you want to update this donation's amount? (yes/no): ");
        String choice = input.nextLine();
    
        if (choice.equalsIgnoreCase("yes")) {
            while (true) {
                try {
                    System.out.print("Enter new donation amount: ");
                    double newAmount = input.nextDouble();
                    input.nextLine(); // Clear buffer

                    if (newAmount < 0) {
                        System.out.println("Amount cannot be negative. Please try again.");
                        continue;
                    }

                // Update total balance
                totalBalance = totalBalance - this.amount + newAmount;
                this.amount = newAmount;

                System.out.println("Donation amount updated successfully!");
                break;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    input.nextLine();
                }
            }
        }

        System.out.println("\nDonation details updated successfully!");
    }
    
    public void display() {

        System.out.println("\nDonation Details:");
        System.out.println("Donor Name       : " + this.donorName);
        System.out.println("Donor Phone      : " + this.donorPhone);
        System.out.println("Account Number   : " + this.accountNo);
        System.out.println("Donation Amount  : $" + String.format("%.2f", this.amount));
    }
        
    public static void generateReport(ArrayList<Donations> donationsList) {
        if (donationsList.isEmpty()) {
            System.out.println("No donations to display.");
            return;
        }

    System.out.println("====================================================================================");
    System.out.printf("| %-20s | %-15s | %-15s | %-10s |\n", "Donor Name", "Donor Phone", "Account Number", "Amount");
    System.out.println("====================================================================================");

    for (Donations donation : donationsList) {
        System.out.printf("| %-20s | %-15s | %-15s | %-10.2f |\n", 
                          donation.donorName, 
                          donation.donorPhone, 
                          donation.accountNo, 
                          donation.amount);
    }
    
    Donations.showTotalbalance();

    System.out.println("====================================================================================");
}
    public static void showTotalbalance() {
        System.out.println("Total Balance    : $" + String.format("%.2f", totalBalance));

    }
    
}
