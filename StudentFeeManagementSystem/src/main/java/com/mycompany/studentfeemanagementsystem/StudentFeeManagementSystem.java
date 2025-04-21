package com.mycompany.studentfeemanagementsystem;

import java.util.Scanner;

public class StudentFeeManagementSystem {
    public static void main(String[] args) {
        schoolName<String> s = new schoolName<String>();
        s.setName("................WELCOME TO STUDENT FEE MANAGEMENT SYSTEM................ ");
        s.display();
        Scanner scanner = new Scanner(System.in);
        FeeManager feeManager = new FeeManager();
        int choice;

        do {
            System.out.println("\n--- Student Fee Management System ---");
            System.out.println("1. Add Department");
            System.out.println("2. Add Instructor");
            System.out.println("3. Add Course");
            System.out.println("4. Add Student");
            System.out.println("5. Generate Fee Slip");
            System.out.println("6. Display All Fee Records");
            System.out.println("7. Calculate Total Remaining Fee");
            System.out.println("8. Search Student by Roll Number");
            System.out.println("9. Update Student");
            System.out.println("10. Delete Student");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                
                    System.out.print("Enter Department Name: ");
                    String deptName = scanner.nextLine();
                    System.out.print("Enter Department Fee: ");
                    double deptFee = scanner.nextDouble();
                    scanner.nextLine();
                    Department department = new Department(deptName, deptFee);
                    Department.addDepartment(department);
                    System.out.println("Department added successfully!");
                    break;

                case 2:
              
                    if (Department.departmentList.isEmpty()) {
                        System.out.println("No departments available! Add a department first.");
                        break;
                    }
                    System.out.print("Enter Instructor Name: ");
                    String instructorName = scanner.nextLine();
                    System.out.print("Enter Instructor Address: ");
                    String instructorAddress = scanner.nextLine();
                    System.out.print("Enter Instructor Cell No: ");
                    String instructorCellNo = scanner.nextLine();
                    System.out.print("Enter Instructor Age: ");
                    int instructorAge = scanner.nextInt();
                    System.out.print("Enter Employee ID: ");
                    int employeeId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Instructor Subject: ");
                    String subject = scanner.nextLine();

                  
                    Department instructorDept = Department.departmentList.get(0);
                    Instructor instructor = new Instructor(instructorName, instructorAddress, instructorCellNo, 
                                                            instructorAge, employeeId, subject, instructorDept);
                    Instructor.addInstructor(instructor);
                    instructorDept.addInstructor(instructor);
                    System.out.println("Instructor added successfully!");
                    break;

                case 3:
                  
                    if (Instructor.instructorList.isEmpty()) {
                        System.out.println("No instructors available! Add an instructor first.");
                        break;
                    }
                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter Course Fee: ");
                    double courseFee = scanner.nextDouble();

               
                    Instructor courseInstructor = Instructor.instructorList.get(0);
                    Department courseDept = Department.departmentList.get(0);

                    Course course = new Course(courseName, courseFee, courseInstructor, courseDept);
                    Course.addCourse(course);
                    courseDept.addCourse(course);
                    System.out.println("Course added successfully!");
                    break;

                case 4:
                  
                    if (Department.departmentList.isEmpty()) {
                        System.out.println("No departments available! Add a department first.");
                        break;
                    }

                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter Student Address: ");
                    String studentAddress = scanner.nextLine();
                    System.out.print("Enter Student Cell No: ");
                    String studentCellNo = scanner.nextLine();
                    System.out.print("Enter Student Age: ");
                    int studentAge = scanner.nextInt();
                    System.out.print("Enter Roll No: ");
                    int rollNo = scanner.nextInt();
                    System.out.print("Enter Fee Paid: ");
                    double feePaid = scanner.nextDouble();
                    scanner.nextLine(); // Clear buffer
                    System.out.print("Enter Semester: ");
                    String semester = scanner.nextLine();
                    System.out.print("Enter CGPA: ");
                    double cgpa = scanner.nextDouble();

                
                    Department studentDept = Department.departmentList.get(0);

                    Student student = new Student(studentName, studentAddress, studentCellNo, studentAge, rollNo, 
                                                  studentDept.getDepartmentFee(), feePaid, studentDept, semester, cgpa);
                    Student.addStudent(student);
                    feeManager.addStudentRecord(student);
                    System.out.println("Student added successfully!");
                    break;

                case 5:
                  
                    System.out.print("Enter Roll Number of Student: ");
                    int rollNumberForSlip = scanner.nextInt();
                    Student studentForSlip = Student.searchStudentByRollNo(rollNumberForSlip);

                    if (studentForSlip == null) {
                        System.out.println("Student not found!");
                    } else {
                        feeManager.generateFeeSlip(studentForSlip);
                    }
                    break;

                case 6:
                  
                    feeManager.displayAllFeeRecords();
                    break;

                case 7:
                    
                    System.out.println("Total Remaining Fee: " + feeManager.calculateTotalRemainingFee());
                    break;

                case 8:
                 
                    System.out.print("Enter Roll Number of Student: ");
                    int rollNoSearch = scanner.nextInt();
                    Student searchedStudent = Student.searchStudentByRollNo(rollNoSearch);

                    if (searchedStudent == null) {
                        System.out.println("Student not found!");
                    } else {
                        System.out.println("\n--- Student Details ---");
                        System.out.println("Name: " + searchedStudent.getName());
                        System.out.println("Roll No: " + searchedStudent.getRollNo());
                        System.out.println("Department: " + searchedStudent.getDepartment().getDepartmentName());
                        System.out.println("Fee Paid: " + searchedStudent.getFeePaid());
                        System.out.println("Remaining Fee: " + searchedStudent.calculateRemainingFee());
                    }
                    break;

                case 9:
                    // Update Student
                    System.out.print("Enter Roll Number of Student to Update: ");
                    int rollNoToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Address: ");
                    String newAddress = scanner.nextLine();
                    System.out.print("Enter New Cell No: ");
                    String newCellNo = scanner.nextLine();
                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();
                    System.out.print("Enter New Fee Paid: ");
                    double newFeePaid = scanner.nextDouble();
                    scanner.nextLine(); // Clear buffer
                    System.out.print("Enter New Semester: ");
                    String newSemester = scanner.nextLine();
                    System.out.print("Enter New CGPA: ");
                    double newCgpa = scanner.nextDouble();

                    boolean updated = Student.updateStudent(rollNoToUpdate, newName, newAddress, newCellNo, 
                                                             newAge, newFeePaid, newSemester, newCgpa);
                    if (updated) {
                        System.out.println("Student updated successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 10:
                    // Delete Student
                    System.out.print("Enter Roll Number of Student to Delete: ");
                    int rollNoToDelete = scanner.nextInt();

                    boolean deleted = Student.deleteStudent(rollNoToDelete);
                    if (deleted) {
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 11:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 11);

        
    }
}
