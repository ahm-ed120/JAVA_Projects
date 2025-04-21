package com.mycompany.studentfeemanagementsystem;
import java.util.ArrayList;

public class Department {
    private String departmentName;
    private double departmentFee;
    private ArrayList<Instructor> instructors; 
    private ArrayList<Course> courses; 

    public static ArrayList<Department> departmentList = new ArrayList<>();

    public Department(String departmentName, double departmentFee) {
        this.departmentName = departmentName;
        this.departmentFee = departmentFee;
        this.instructors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public double getDepartmentFee() {
        return departmentFee;
    }

    public void setDepartmentFee(double departmentFee) {
        this.departmentFee = departmentFee;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }


    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public static void addDepartment(Department department) {
        departmentList.add(department);
    }

    public String getName() {
        return departmentName;
    }
}
