package com.mycompany.studentfeemanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class FeeManager {
    private List<Student> studentRecords;

    public FeeManager() {
        studentRecords = new ArrayList<>();
    }


    public void addStudentRecord(Student student) {
        studentRecords.add(student);
        System.out.println("Student record added successfully!");
    }

    public void generateFeeSlip(Student student) {
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        FeeSlip.generateFeeSlip(student);
    }

    public void displayAllFeeRecords() {
        if (studentRecords.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("\n--- All Student Fee Records ---");
        for (Student student : studentRecords) {
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println("Name: " + student.getName() + " | Roll No: " + student.getRollNo() + 
                " | Department: " + student.getDepartment().getDepartmentName() + 
                " | Fee Paid: " + student.getFeePaid() + " | Remaining Fee: " + student.calculateRemainingFee());
            System.out.println("--------------------------------------------------------------------------------------------------------");
        }
    }

    public double calculateTotalRemainingFee() {
        double totalRemainingFee = 0;
        for (Student student : studentRecords) {
            totalRemainingFee += student.calculateRemainingFee();
        }
        return totalRemainingFee;
    }
}
