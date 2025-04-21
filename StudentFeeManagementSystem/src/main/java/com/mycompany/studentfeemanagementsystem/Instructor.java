package com.mycompany.studentfeemanagementsystem;

import java.util.ArrayList;

public class Instructor extends Person {
    private int employeeId;
    private String subject;
    private ArrayList<Course> courses; 
    private Department department;  

  
    public static ArrayList<Instructor> instructorList = new ArrayList<>();

    public Instructor(String name, String address, String cellNo, int age, int employeeId, String subject, Department department) {
        super(name, address, cellNo, age);
        this.employeeId = employeeId;
        this.subject = subject;
        this.department = department;
        this.courses = new ArrayList<>();
    }

   
    public int getEmployeeId() {
        return employeeId;
    }

    public String getSubject() {
        return subject;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public Department getDepartment() {
        return department;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public static void addInstructor(Instructor instructor) {
        instructorList.add(instructor);
    }

    public void addInstructorToDepartment() {
        if (department != null) {
            department.addInstructor(this);
        }
    }

    @Override
    public void display() {
        System.out.println("Instructor Details:");
        System.out.println("Name: " + getName()); 
        System.out.println("Address: " + getAddress()); 
        System.out.println("Cell No: " + getCellNo()); 
        System.out.println("Age: " + getAge());
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Subject: " + subject);
        System.out.println("Department: " + (department != null ? department.getDepartmentName() : "No Department"));
        System.out.println("Courses Taught:");
        for (Course course : courses) {
            System.out.println("- " + course.getCourseName());
        }
    }
}
