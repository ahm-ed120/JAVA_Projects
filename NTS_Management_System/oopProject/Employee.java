package oopProject;

import javax.xml.transform.Source;
import java.util.Scanner;

public class Employee extends Person implements Allowance_Management{

    int employeeNo;
    String city;
    double invig_allowance=0;
    double spdt_allowance=0;

    Employee()
    {
        super();
        employeeNo=0;
        city=null;
        invig_allowance=0;
        spdt_allowance=0;
    }

    Employee(String n,String fn,String id,String phone,int employeeNo,String city,Double invig_allowance,Double spdt_allowance)
    {
        super(n,fn,id,phone);
        this.employeeNo=employeeNo;
        this.city = city;
        this.invig_allowance=invig_allowance;
        this.spdt_allowance=spdt_allowance;
    }

    public double getInvig_allowance() {
        return invig_allowance;
    }

    public void setInvig_allowance(double invig_allowance) {
        this.invig_allowance = invig_allowance;
    }

    public double getSpdt_allowance() {
        return spdt_allowance;
    }

    public void setSpdt_allowance(double spdt_allowance) {
        this.spdt_allowance = spdt_allowance;
    }

    public int getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void setter() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter employee name:");
        name = input.nextLine();

        System.out.println("Enter father name:");
        fname = input.nextLine();


        System.out.println("Enter CNIC(with dahses): ");
        idCard = input.nextLine();

        System.out.println("Enter phone number: ");
        phoneNo = input.nextLine();

        System.out.println("Enter employee city ");
        city = input.nextLine();

        while (true) {
            try {
                System.out.println("Enter employee number: ");
                employeeNo = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input.Try again.");
                input.nextLine();
            }
        }
    }

    @Override
    public void display() {

        System.out.println();
        System.out.println("Employee Name: " + name);
        System.out.println("Father name: " + fname);
        System.out.println("Form number: " + employeeNo);
        System.out.println("Employee City: "+city);
        System.out.println("CNIC: " + idCard);
        System.out.println("Phone number: " + phoneNo);
        System.out.println();

    }

    @Override
    public void update() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter new employee name:");
        name = input.nextLine();

        System.out.println("Enter new father name:");
        fname = input.nextLine();


        System.out.println("Enter new CNIC(with dahses): ");
        idCard = input.nextLine();

        System.out.println("Enter new phone number: ");
        phoneNo = input.nextLine();

        System.out.println("Enter new employee city ");
        city = input.nextLine();

        while (true) {
            try {
                System.out.println("Enter new employee number: ");
                employeeNo = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input.Try again.");
                input.nextLine();
            }
        }

    }

    @Override
    public void get_Allowance(int choice) {

        if(choice==1)
        {
            System.out.println("Invigilator Allowance: "+invig_allowance);
        } else if (choice==2) {

            System.out.println("Superintendent Allowance: "+spdt_allowance);
        }

    }

    @Override
    public void set_Allowance() {

        Scanner input = new Scanner(System.in);

        while(true) {

            try {
                System.out.println("Enter the new allowance for invigilator: ");
                invig_allowance = input.nextDouble();
                input.nextLine();
                System.out.println("Enter the new allowance for superintendent: ");
                spdt_allowance = input.nextDouble();
                input.nextLine();
                break;
            }
            catch(Exception e)
            {
                System.out.println("Invalid Input.Try Again");
                input.nextLine();
            }


        }
    }
}
