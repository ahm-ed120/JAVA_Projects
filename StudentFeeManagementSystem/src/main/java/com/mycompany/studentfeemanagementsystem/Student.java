package com.mycompany.studentfeemanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements FeeDetails {

    
    private static List<Student> studentList = new ArrayList<>();

    private int rollNo; 
    private double totalFee;
    private double feePaid; 
    private Department department; 
    private String semester; 
    private double cgpa;

    // Constructor
    public Student(String name, String address, String cellNo, int age, int rollNo, double totalFee, 
                   double feePaid, Department department, String semester, double cgpa) {
        super(name, address, cellNo, age);
        this.rollNo = rollNo;
        this.totalFee = totalFee;
        this.feePaid = feePaid;
        this.department = department;
        this.semester = semester;
        this.cgpa = cgpa;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public double getFeePaid() {
        return feePaid;
    }

    public void setFeePaid(double feePaid) {
        this.feePaid = feePaid;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public double calculateRemainingFee() {
        return totalFee - feePaid;
    }

    @Override
    public void display() {
        System.out.println("Student Details:");
        System.out.println("Name: " + getName()); 
        System.out.println("Address: " + getAddress()); 
        System.out.println("Cell No: " + getCellNo()); 
        System.out.println("Age: " + getAge()); 
        System.out.println("Roll No: " + rollNo);
        System.out.println("Department: " + (department != null ? department.getDepartmentName() : "No Department"));
        System.out.println("Semester: " + semester);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Total Fee: " + totalFee);
        System.out.println("Fee Paid: " + feePaid);
        System.out.println("Remaining Fee: " + calculateRemainingFee());
    }

    @Override
    public void generateFeeSlip() {
        System.out.println("Generating Fee Slip for Student " + getName());
        System.out.println("Roll No: " + rollNo);
        System.out.println("Department: " + (department != null ? department.getDepartmentName() : "No Department"));
        System.out.println("Total Fee: " + totalFee);
        System.out.println("Fee Paid: " + feePaid);
        System.out.println("Remaining Fee: " + calculateRemainingFee());
    }

    public static void addStudent(Student student) {
        studentList.add(student);
    }

    public static Student searchStudentByRollNo(int rollNo) {
        for (Student student : studentList) {
            if (student.getRollNo() == rollNo) {
                return student;
            }
        }
        return null; 
    }

    public static boolean updateStudent(int rollNo, String name, String address, String cellNo, int age,
                                         double feePaid, String semester, double cgpa) {
        Student student = searchStudentByRollNo(rollNo);
        if (student != null) {
            student.setName(name);
            student.setAddress(address);
            student.setCellNo(cellNo);
            student.setAge(age);
            student.setFeePaid(feePaid);
            student.setSemester(semester);
            student.setCgpa(cgpa);
            return true;
        }
        return false;
    }
    public static boolean deleteStudent(int rollNo) {
        Student student = searchStudentByRollNo(rollNo);
        if (student != null) {
            studentList.remove(student);
            return true; 
        }
        return false; 
    }

    public void setName(String name) {
    this.name = name; 
}

 public void setAddress(String address) {
    this.address = address; 
}
   
    private void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    private void setAge(int age) {
        this.age = age;
    }
}
