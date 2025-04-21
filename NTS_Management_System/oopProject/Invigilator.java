package oopProject;

import java.util.Scanner;

public class Invigilator extends Employee{

        String designation;
        String supervisorName;
        String supervisorPhoneNo;
        Superintendent superintendent;

    public Superintendent getSuperintendent() {
        return superintendent;
    }

    public void setSuperintendent(Superintendent superintendent) {
        this.superintendent = superintendent;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String getSupervisorPhoneNo() {
        return supervisorPhoneNo;
    }

    public void setSupervisorPhoneNo(String supervisorPhoneNo) {
        this.supervisorPhoneNo = supervisorPhoneNo;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


    Invigilator()
        {
            super();
            designation="";
            supervisorName="";
            supervisorPhoneNo =null;
            superintendent=new Superintendent();
        }

        Invigilator(String n,String fn,String id,String phone,int employeeNo,String city,String des,String supervisor,Double invig_allowance,Double spdt_allowance,int interval)
        {
            super(n,fn,id,phone,employeeNo,city,invig_allowance,spdt_allowance);
            this.designation=des;
            this.supervisorName=supervisor;
            superintendent=new Superintendent(n,fn,id,phone,employeeNo,city,invig_allowance,spdt_allowance,interval);

        }

    @Override
    public void setter() {
        super.setter();
        System.out.println("Enter the designation of employee: ");
        Scanner input = new Scanner(System.in);
        designation= input.nextLine();

        System.out.println("Enter the name of the superintendent: ");
        supervisorName=input.nextLine();

        System.out.println("Enter the phone number of superintendent: ");
        supervisorPhoneNo=input.nextLine();
    }

    @Override
    public void update() {

        super.update();
        System.out.println("Enter the new designation of employee: ");
        Scanner input = new Scanner(System.in);
        designation=input.nextLine();

        System.out.println("Enter the name of the new superintendent: ");
        supervisorName=input.nextLine();

        System.out.println("Enter the phone number of new superintendent: ");
        supervisorPhoneNo=input.nextLine();

    }

    @Override
    public void display() {

        super.display();
        System.out.println("IS AN Invigilator");
        System.out.println("Designation: "+designation);
        System.out.println("Superintendent: "+supervisorName);
        System.out.println("Superintendent Phone number: "+supervisorPhoneNo);
        if(super.invig_allowance==0)
        {
            System.out.println("Allowance not determined yet");
        }
        else {
            super.get_Allowance(1);
        }
        System.out.println();
    }
}
