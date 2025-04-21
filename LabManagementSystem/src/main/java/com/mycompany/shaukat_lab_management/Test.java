package com.mycompany.shaukat_lab_management;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    private int testId;
    private String name;
    private double price;

    Test() {
        testId = 0;
        name = null;
        price = 0.0;
    }

    public int getTestId() {
        return testId;
    }

    public void setItemId(int testId) {
        this.testId = testId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setter() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter test id: ");
                testId = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid input for test id.");
                input.nextLine();
            }
        }

        System.out.println("Enter name: ");
        name = input.nextLine();

        while (true) {
            try {
                System.out.println("Enter price: ");
                price = input.nextDouble();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number for price.");
                input.nextLine();
            }
        }
    }

    public void update() {
        Scanner input = new Scanner(System.in);
        System.out.println("Current test ID: " + this.testId);
        while (true) {
            System.out.print("Enter new test ID (or press Enter to keep unchanged): ");
            String testIdInput = input.nextLine();
            if (testIdInput.isEmpty()) {
                break;
            }
            try {
                this.testId = Integer.parseInt(testIdInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer for test ID.");
            }
        }

        System.out.println("Current Name: " + name);
        System.out.println("Enter new name (or press Enter to keep current):");
        String newName = input.nextLine();
        if (!newName.isEmpty()) {
            name = newName;
        }

        System.out.println("Current price: " + this.price);
        while (true) {
            System.out.print("Enter new price (or press Enter to keep unchanged): ");
            String priceInput = input.nextLine();
            if (priceInput.isEmpty()) {
                break;
            }
            try {
                this.price = Double.parseDouble(priceInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for price.");
            }
        }
    }

    public void display() {
        System.out.println("Test id: " + testId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
    
    public static void generateReport(ArrayList<Test> availTests) {

        if (availTests.isEmpty()) {
            System.out.println("No tests in the inventory.");
            return;
        }

        System.out.println("------- Test Inventory Report -------");
        System.out.println("Test ID | Name           | Price");

        double totalPrice = 0;
        int count = 0;

        for (Test test : availTests) {
            System.out.printf("%-8d | %-15s | %.2f%n", test.getTestId(), test.getName(), test.getPrice());
            totalPrice += test.getPrice();
            count++;
        }

        System.out.println("\n------- Report Summary -------");
        System.out.println("Total number of tests: " + count);
        System.out.println("Total price of tests: " + String.format("%.2f", totalPrice));
    }
    
    
    
}

