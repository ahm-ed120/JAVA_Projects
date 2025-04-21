package oopProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Test implements TestManagement{

    String testName;
    int testId;
    int marks;
    int charges;
    float passing_percentage;
    TestCentre centre;

    Test(){

        marks=0;
        this.charges =0;
        passing_percentage=0;
        centre = new TestCentre();

    }

    public Test(int marks, String testName, int charges, float passing_percentage,TestCentre centre) {
        this.marks = marks;
        this.testName = testName;
        this.charges = charges;
        this.passing_percentage = passing_percentage;
        this.centre = centre;

    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getCharges() {
        return charges;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }

    public float getPassing_percentage() {
        return passing_percentage;
    }

    public void setPassing_percentage(float passing_percentage) {
        this.passing_percentage = passing_percentage;
    }

    public TestCentre getCentre() {
        return centre;
    }

    public void setCentre(TestCentre centre) {
        this.centre = centre;
    }

    public void update()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the new name of the test: ");
        testName = input.nextLine();

        while (true) {
            try {
                System.out.println("Enter the new ID of the test: ");
                testId = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input.Try again.");
                input.nextLine();
            }
        }


        while (true) {
            try {
                System.out.println("Enter the new total marks of the test: ");
                marks = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input.Try again.");
                input.nextLine();
            }
        }

            while (true) {
                try {
                    System.out.println("Enter the new charges for the test: ");
                    charges = input.nextInt();
                    input.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid Input.Try again.");
                    input.nextLine();
                }

        }

            while (true) {
                try {
                    System.out.println("Enter the new passing percentage for the test: ");
                    passing_percentage = input.nextFloat();
                    input.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid Input.Try again.");
                    input.nextLine();
                }

            }
    }

    public void setter()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the name of the test: ");
        testName = input.nextLine();

        while (true) {
            try {
                System.out.println("Enter the ID of the test: ");
                testId = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input.Try again.");
                input.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("Enter total marks of the test: ");
                marks = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input.Try again.");
                input.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("Enter charges for the test: ");
                charges = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input.Try again.");
                input.nextLine();
            }

        }

        while (true) {
            try {
                System.out.println("Enter passing percentage for the test: ");
                passing_percentage = input.nextFloat();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input.Try again.");
                input.nextLine();
            }

        }
    }

    public void display()
    {
        System.out.println();
        System.out.println("Name of the test: "+testName);
        System.out.println("Total marks of the test: "+marks);
        System.out.println("Passing percentage for the test: "+passing_percentage+"%");
        System.out.println("Charges for the test: "+charges+"RS");
        System.out.println();
    }

    @Override
    public void checkAvailableTests() {

        System.out.println("Enter the name of the test to check: ");
        Scanner sc = new Scanner(System.in);
        String testTocheck = sc.next();

        if(testTocheck.equalsIgnoreCase("NAT"))
        {
            System.out.println();
            System.out.println("Name of the test: NAT");
            System.out.println("Total marks of the test: 90");
            System.out.println("Passing percentage for the test: 60%");
            System.out.println("Charges for the test: 850RS");
            System.out.println();
        }
        else if (testTocheck.equalsIgnoreCase("GAT"))
        {

                System.out.println();
                System.out.println("Name of the test: GAT");
                System.out.println("Total marks of the test: 100");
                System.out.println("Passing percentage for the test: 50%");
                System.out.println("Charges for the test: 1350RS");
                System.out.println();

        } else if (testTocheck.equalsIgnoreCase("TOEIC")) {
            {
                System.out.println();
                System.out.println("Name of the test: TOEIC");
                System.out.println("Total marks of the test: 990Points");
                System.out.println("Passing percentage for the test: 45%");
                System.out.println("Charges for the test: 22000RS");
                System.out.println();
            }

        }
    }
}

