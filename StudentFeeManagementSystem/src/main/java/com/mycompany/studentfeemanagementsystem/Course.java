package com.mycompany.studentfeemanagementsystem;

import java.util.ArrayList;

public class Course {
    private String courseName;
    private double courseFee;
    private Instructor instructor;
    private Department department;

   
    public static ArrayList<Course> courseList = new ArrayList<>();

    public Course(String courseName, double courseFee, Instructor instructor, Department department) {
        this.courseName = courseName;
        this.courseFee = courseFee;
        this.instructor = instructor;
        this.department = department;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public Department getDepartment() {
        return department;
    }

    public static void addCourse(Course course) {
        courseList.add(course);
    }

    public String getDepartmentName() {
        return department != null ? department.getName() : "No Department"; 
    }
}
