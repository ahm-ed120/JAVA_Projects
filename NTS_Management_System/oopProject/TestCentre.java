package oopProject;

import java.util.ArrayList;
import java.util.Scanner;

public class TestCentre implements TestCentreTeamManagement {

    int testCentreNo;
    String testCentreCity;
    String buildingType;
    String allocationDate;
   public ArrayList<Invigilator> invigilators = new ArrayList<>();
   public Invigilator invigilator;
   public Superintendent spd;
   public ArrayList<Superintendent> superintendents = new ArrayList<>();

    public String getTestCentreCity() {
        return testCentreCity;
    }

    public void setTestCentreCity(String testCentreCity) {
        this.testCentreCity = testCentreCity;
    }

    public Superintendent getSpd() {
        return spd;
    }

    public void setSpd(Superintendent spd) {
        this.spd = spd;
    }

    public ArrayList<Invigilator> getInvigilators() {
        return invigilators;
    }

    public void setInvigilators(ArrayList<Invigilator> invigilators) {
        this.invigilators = invigilators;
    }

    TestCentre() {
        testCentreNo = 0;
        buildingType = "";
        allocationDate = "";
        invigilators = new ArrayList<>();
        invigilator = new Invigilator();
        spd = new Superintendent();
    }

    public TestCentre(int testCentreNo, String buildingType, String allocationDate, String n, String fn, String id, String phone, int employeeNo, String city, String des, String supervisor, Double invig_allowance, Double spdt_allowance, int interval,Invigilator[] invs) {
        this.testCentreNo = testCentreNo;
        this.buildingType = buildingType;
        this.allocationDate = allocationDate;
        invigilators = new ArrayList<>();
        spd = new Superintendent(n, fn, id, phone, employeeNo, city, invig_allowance, spdt_allowance, interval);

    }

    public Invigilator getInvigilator() {
        return invigilator;
    }

    public void setInvigilator(Invigilator invigilator) {
        this.invigilator = invigilator;
    }

    public int getTestCentreNo() {
        return testCentreNo;
    }

    public void setTestCentreNo(int testCentreNo) {
        this.testCentreNo = testCentreNo;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public String getAllocationDate() {
        return allocationDate;
    }

    public void setAllocationDate(String allocationDate) {
        this.allocationDate = allocationDate;
    }

    public void setter() {

        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter the test Centre no: ");
                testCentreNo = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input.Try again.");
                input.nextLine();
            }

        }
        System.out.println("Enter the test Centre building : ");
        buildingType = input.nextLine();
        System.out.println("Enter the test centre city: ");
        testCentreCity = input.nextLine();
        System.out.println("Enter the date of allocation: ");
        allocationDate = input.nextLine();

    }

    public void display() {
        System.out.println();
        System.out.println("Test Centre no: " + testCentreNo);
        System.out.println("Test Centre building : " + buildingType);
        System.out.println("Test centre city: " + testCentreCity);
        System.out.println("Date of allocation: " + allocationDate);
        System.out.println();
    }

    public void update() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter the new test Centre no: ");
                testCentreNo = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input.Try again.");
                input.nextLine();
            }

        }
        System.out.println("Enter the new test Centre building : ");
        buildingType = input.nextLine();
        System.out.println("Enter the new test centre city: ");
        testCentreCity = input.nextLine();
        System.out.println("Enter the new date of allocation: ");
        allocationDate = input.nextLine();
    }

    @Override
    public void showSupervisorDetails() {

        System.out.println("Supervisor Name: " + spd.name);
        System.out.println("Father name: " + spd.fname);
        System.out.println("CNIC: " + spd.idCard);
        System.out.println("Phone No: " + spd.phoneNo);
    }

    @Override
    public void addSupervisor() {

        System.out.println("Input supervisor data");
        spd.setter();
        superintendents.add(spd);
    }

    @Override
    public void addInvigilators() {

        int amountToAdd=0;

        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter the no of invigilators to add: ");
                amountToAdd = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input.Try again.");
                input.nextLine();
            }

        }

        for(int i=0;i<amountToAdd;i++)
        {
            System.out.println("Enter details for invigilator number "+(i+1));
            invigilators.add(invigilator);
        }
    }
}