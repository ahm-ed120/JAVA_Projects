package oopProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Candidate extends Person implements ApplyTest {

    int formNo;
    String candidateEmail;
    String candidatePass;
    Test test;
    Boolean status;
    ArrayList<Candidate> candidates = new ArrayList<>();

    public String getCandidateEmail() {
        return candidateEmail;
    }

    public void setCandidateEmail(String candidateEmail) {
        this.candidateEmail = candidateEmail;
    }

    public String getCandidatePass() {
        return candidatePass;
    }

    public void setCandidatePass(String candidatePass) {
        this.candidatePass = candidatePass;
    }

    public int getFormNo() {
        return formNo;
    }

    public void setFormNo(int formNo) {
        this.formNo = formNo;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public ArrayList<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(ArrayList<Candidate> candidates) {
        this.candidates = candidates;
    }

    Candidate() {
        super();
        formNo = 0;
        candidateEmail = "";
        candidatePass = "";
        test = new Test();
        status=false;
    }

    Candidate(String n, String fn, String id, String phone, int form, String em, String pass, String testname, int total, int charges, float passing, TestCentre centree,Boolean status) {
        super(n, fn, id, phone);
        formNo = form;
        candidateEmail = em;
        candidatePass = pass;
        this.status=status;
        test = new Test(total, testname, charges, passing, centree);
    }

    @Override
    public void setter() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter candidate name:");
        name = input.nextLine();

        System.out.println("Enter father name:");
        fname = input.nextLine();


        System.out.println("Enter CNIC(with dahses): ");
        idCard = input.nextLine();

        System.out.println("Enter phone number: ");
        phoneNo = input.nextLine();

        System.out.println("Enter candidate email ");
        candidateEmail = input.next();


        System.out.println("Enter candidate password ");
        candidatePass = input.next();

        while (true) {
            try {
                System.out.println("Enter form number: ");
                formNo = input.nextInt();
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
        System.out.println("Candidate Name: " + name);
        System.out.println("Father name: " + fname);
        System.out.println("Form number: " + formNo);
        System.out.println("Candidate Email: " + candidateEmail);
        System.out.println("Candidate Password: " + candidatePass);
        System.out.println("CNIC: " + idCard);
        System.out.println("Phone number: " + phoneNo);
        System.out.println();
    }

    @Override
    public void update() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter new candidate name:");
        name = input.nextLine();

        System.out.println("Enter new father name:");
        fname = input.nextLine();


        System.out.println("Enter new CNIC(with dahses): ");
        idCard = input.nextLine();

        System.out.println("Enter new phone number: ");
        phoneNo = input.nextLine();

        System.out.println("Enter new candidate email ");
        candidateEmail = input.next();


        System.out.println("Enter new candidate password ");
        candidatePass = input.next();

        while (true) {
            try {
                System.out.println("Enter new form number: ");
                formNo = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input.Try again.");
                input.nextLine();
            }

        }
    }

    @Override
    public void applyTest() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter your form number: ");
        int formNoToCheck = input.nextInt();

        for (Candidate c : candidates) {
            if (formNoToCheck == c.formNo) {
                test.checkAvailableTests();
                System.out.println();
                test.setter();
                c.status=true;
            }
            else {
                System.out.println("Record does not exist");
            }


        }
    }

    @Override
    public void checkStatus() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter your form number: ");
        int formNoToCheck = input.nextInt();

        for (Candidate c : candidates) {
            if (formNoToCheck==c.formNo) {

                if(status==true)
                {
                    System.out.println("You have successfully applied for the test");
                }
                else {
                    System.out.println("No tests applied currently");
                    System.out.println("Press 1 to apply for test");
                    int booker = input.nextInt();
                    if(booker==1)
                    {
                        this.applyTest();
                    }


                }

            }
        }
    }
}