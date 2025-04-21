package com.mycompany.studentfeemanagementsystem;

public class FeeSlip {
    private int feeId;
    private Student student;
    private double totalFee;
    private double feePaid;

    public FeeSlip(int feeId, Student student, double totalFee, double feePaid) {
        this.feeId = feeId;
        this.student = student;
        this.totalFee = totalFee;
        this.feePaid = feePaid;
    }

    // Getters
    public int getFeeId() {
        return feeId;
    }

    public Student getStudent() {
        return student;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public double getFeePaid() {
        return feePaid;
    }

    
    public void displayFeeInfo() {
        System.out.println("Fee Slip Details:");
        System.out.println("Fee ID: " + feeId);
        System.out.println("Student Name: " + student.getName());
        System.out.println("Roll No: " + student.getRollNo());
        System.out.println("Department: " + (student.getDepartment() != null ? student.getDepartment().getDepartmentName() : "No Department"));
        System.out.println("Total Fee: " + totalFee);
        System.out.println("Fee Paid: " + feePaid);
        System.out.println("Remaining Fee: " + (totalFee - feePaid));
    }

    public static void generateFeeSlip(Student student) {
        if (student != null) {
            FeeSlip feeSlip = new FeeSlip(student.getRollNo(), student, student.getTotalFee(), student.getFeePaid());
            feeSlip.displayFeeInfo();
        } else {
            System.out.println("Student not found.");
        }
    }
}
