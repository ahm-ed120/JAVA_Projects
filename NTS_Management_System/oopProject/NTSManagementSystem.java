package oopProject;

import java.util.ArrayList;
import java.util.Scanner;

public class NTSManagementSystem {

    public static void main(String[] args) {

        int choiceAtMainMenu=1;
        int choiceAtCandidateMenu;
        int choiceAtEmployeeMenu;
        int choiceAtCentresMenu;
        int choiceAtTestMenu;

        ArrayList<Candidate> candidates = new ArrayList<Candidate>();
        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<TestCentre> testCentres = new ArrayList<>();
        ArrayList<Test> tests = new ArrayList<>();

        Candidate candidate = new Candidate();
        Employee employee = new Employee();
        TestCentre testCentre = new TestCentre();
        Test test = new Test();

        while (choiceAtMainMenu!=0) {
            System.out.println();
            System.out.println("\t\t\tWELCOME TO THE NTS MANAGEMENT SYSTEM");
            System.out.println();
            System.out.println("1.CANDIDATE PORTAL");
            System.out.println("2.EMPLOYEE PORTAL");
            System.out.println("3.TEST CENTRES PORTAL");
            System.out.println("4.TESTS PORTAL");
            System.out.println("0.EXIT");

            while (true) {
                Scanner input = new Scanner(System.in);
                try {
                    System.out.println("Enter your choice: ");
                    input = new Scanner(System.in);
                    choiceAtMainMenu = input.nextInt();
                    input.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid Input.Try again.");
                    input.nextLine();
                }
            }

            switch (choiceAtMainMenu) {

                case 1: {

                    System.out.println();
                    System.out.println("\t\t\tWELCOME TO THE NTS CANDIDATE PORTAL");
                    System.out.println();
                    System.out.println("1.ADD CANDIDATE DATA");
                    System.out.println("2.SEARCH CANDIDATE DATA");
                    System.out.println("3.UPDATE CANDIDATE DATA");
                    System.out.println("4.DISPLAY CANDIDATE DATA");
                    System.out.println("5.DELETE CANDIDATE DATA");
                    System.out.println("6.APPLY FOR TEST");
                    System.out.println("7.SHOW APPLICATION STATUS");
                    System.out.println("8.EXIT");

                    while (true) {
                        Scanner input = new Scanner(System.in);
                        try {
                            System.out.println("Enter your choice: ");
                            input = new Scanner(System.in);
                            choiceAtCandidateMenu = input.nextInt();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid Input.Try again.");
                            input.nextLine();
                        }
                    }

                    switch (choiceAtCandidateMenu) {
                        case 1: {
                            candidate.setter();
                            candidates.add(candidate);
                            System.out.println("ADDED SUCCESSFULLY");
                            System.out.println();
                        }
                        break;

                        case 2: {
                            System.out.println("Enter form number of candidate to search: ");
                            Scanner input = new Scanner(System.in);
                            int candidateSearch = input.nextInt();

                            for (Candidate candidateToSearch : candidates) {
                                if (candidateSearch == candidateToSearch.formNo) {
                                    candidateToSearch.display();
                                    System.out.println();
                                }
                            }
                        }
                        break;

                        case 3: {

                            System.out.println("Enter form number of candidate to Update: ");
                            Scanner input = new Scanner(System.in);
                            int candidateUpdate = input.nextInt();

                            for (Candidate candidateToUpdate : candidates) {
                                if (candidateUpdate == candidateToUpdate.formNo) {
                                    candidateToUpdate.update();
                                }
                            }

                        }
                        break;

                        case 4: {
                            for (Candidate CandidatesToDisplay : candidates) {
                                if (candidates.isEmpty()) {
                                    System.out.println("NO RECORDS AVAILABLE");
                                } else {
                                    System.out.printf("CANDIDATE %d", (candidates.indexOf(CandidatesToDisplay) + 1));
                                    CandidatesToDisplay.display();
                                    System.out.println();
                                }
                            }
                        }
                        break;

                        case 5: {
                            System.out.println("Enter form number of candidate to Delete: ");
                            Scanner input = new Scanner(System.in);
                            int candidateDelete = input.nextInt();
                            boolean candidateFound = false;

                            for (Candidate candidateToDelete : candidates) {
                                if (candidateDelete == candidateToDelete.formNo) {
                                    candidates.remove(candidateToDelete);
                                    System.out.println("Record removed successfully");
                                    candidateFound = true;
                                    System.out.println();
                                    break;
                                }

                            }
                            if (candidateFound == false) {
                                System.out.println("Record Not Found");
                            }

                        }
                        break;

                        case 6: {
                            Scanner input = new Scanner(System.in);
                            System.out.println("Enter your form number: ");
                            int formNoToCheck = input.nextInt();

                            for (Candidate c : candidates) {
                                if (formNoToCheck == c.formNo) {
                                    test.checkAvailableTests();
                                    System.out.println();
                                    test.setter();
                                    System.out.println("TEST APPLIED SUCCESSFULLY");
                                    c.status = true;
                                } else {
                                    System.out.println("Record does not exist");
                                }
                            }

                        }
                        break;

                        case 7: {
                            Scanner input = new Scanner(System.in);
                            System.out.println("Enter your form number: ");
                            int formNoToCheck = input.nextInt();

                            for (Candidate c : candidates) {
                                if (formNoToCheck == c.formNo) {

                                    if (c.status == true) {
                                        System.out.println("You have successfully applied for the test");
                                    } else {
                                        System.out.println("No tests applied currently");
                                        System.out.println("Press 1 to apply for test");
                                        int booker = input.nextInt();
                                        if (booker == 1) {
                                            c.applyTest();
                                        }


                                    }
                                }
                            }
                        }
                        break;

                        case 8:
                            break;

                        default:
                            System.out.println("Inavlid choice");
                    }


                }
                break;

                case 2: {

                    System.out.println();
                    System.out.println("\t\t\tWELCOME TO THE NTS EMPLOYEE PORTAL");
                    System.out.println();
                    System.out.println("1.ADD EMPLOYEE DATA");
                    System.out.println("2.SEARCH EMPLOYEE DATA");
                    System.out.println("3.UPDATE EMPLOYEE DATA");
                    System.out.println("4.DISPLAY EMPLOYEE DATA");
                    System.out.println("5.DELETE EMPLOYEE DATA");
                    System.out.println("6.ALLOWANCE MANAGEMENT");
                    System.out.println("7.EXIT");

                    while (true) {
                        Scanner input = new Scanner(System.in);
                        try {
                            System.out.println("Enter your choice: ");
                            input = new Scanner(System.in);
                            choiceAtEmployeeMenu = input.nextInt();
                            input.nextLine();
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid Input.Try again.");
                            input.nextLine();
                        }
                    }

                    switch (choiceAtEmployeeMenu) {
                        case 1: {
                            employee.setter();
                            employees.add(employee);
                            System.out.println("ADDED SUCCESSFULLY");
                            System.out.println();
                        }
                        break;

                        case 2: {
                            System.out.println("Enter ID number of employee to search: ");
                            Scanner input = new Scanner(System.in);
                            int employeeSearch = input.nextInt();

                            for (Employee employeeToSearch : employees) {
                                if (employeeSearch == employeeToSearch.employeeNo) {
                                    employeeToSearch.display();
                                    System.out.println();
                                }
                            }
                        }
                        break;

                        case 3: {
                            System.out.println("Enter ID number of employee to Update: ");
                            Scanner input = new Scanner(System.in);
                            int employeeUpdate = input.nextInt();

                            for (Employee employeeToUpdate : employees) {
                                if (employeeUpdate == employeeToUpdate.employeeNo) {
                                    employeeToUpdate.update();
                                }
                            }
                        }
                        break;

                        case 4: {
                            for (Employee EmployeesToDisplay : employees) {
                                if (employees.isEmpty()) {
                                    System.out.println("NO RECORDS AVAILABLE");
                                } else {
                                    System.out.printf("EMPLOYEE %d", (employees.indexOf(EmployeesToDisplay) + 1));
                                    EmployeesToDisplay.display();
                                    System.out.println();
                                }
                            }
                        }
                        break;

                        case 5: {
                            System.out.println("Enter ID of employee to Delete: ");
                            Scanner input = new Scanner(System.in);
                            int employeeDelete = input.nextInt();
                            boolean employeeFound = false;

                            for (Employee employeeToDelete : employees) {
                                if (employeeDelete == employeeToDelete.employeeNo) {
                                    employees.remove(employeeToDelete);
                                    System.out.println("Record removed successfully");
                                    employeeFound = true;
                                    System.out.println();
                                    break;
                                }

                            }
                            if (employeeFound == false) {
                                System.out.println("Record Not Found");
                            }
                        }
                        break;

                        case 6: {
                            System.out.println();
                            System.out.println("1.Show Allowance details");
                            System.out.println("2.Update Allowance details");
                            Scanner sc = new Scanner(System.in);
                            int allowanceOptions = sc.nextInt();

                            while (true) {

                                if (allowanceOptions == 1) {
                                    employee.get_Allowance(1);
                                    employee.get_Allowance(2);
                                    break;
                                } else if (allowanceOptions == 2) {
                                    employee.set_Allowance();
                                    break;
                                } else {
                                    System.out.println("Invalid option.");
                                }
                            }
                        }
                        break;

                        case 7:
                            break;

                        default:
                            System.out.println("INVALID CHOICE");

                    }
                    break;
                }
                case 3: {

                    System.out.println();
                    System.out.println("\t\t\tWELCOME TO THE NTS TEST CENTRE PORTAL");
                    System.out.println();
                    System.out.println("1.ADD TEST CENTRE DATA");
                    System.out.println("2.SEARCH TEST CENTRE DATA");
                    System.out.println("3.UPDATE TEST CENTRE DATA");
                    System.out.println("4.DISPLAY TEST CENTRE DATA");
                    System.out.println("5.DELETE TEST CENTRE DATA");
                    System.out.println("6.ADD DUTY TEAM");
                    System.out.println("7.SHOW SUPERVISOR DETAILS");
                    System.out.println("8.EXIT");
                }

                while (true) {
                    Scanner input = new Scanner(System.in);
                    try {
                        System.out.println("Enter your choice: ");
                        input = new Scanner(System.in);
                        choiceAtCentresMenu = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid Input.Try again.");
                        input.nextLine();
                    }
                }

                switch (choiceAtCentresMenu) {
                    case 1: {
                        testCentre.setter();
                        testCentres.add(testCentre);
                        System.out.println("ADDED SUCCESSFULLY");
                        System.out.println();
                    }
                    break;

                    case 2: {
                        System.out.println("Enter number of testCentre to search: ");
                        Scanner input = new Scanner(System.in);
                        int testCentreSearch = input.nextInt();

                        for (TestCentre testCentreToSearch : testCentres) {
                            if (testCentreSearch == testCentreToSearch.testCentreNo) {
                                testCentreToSearch.display();
                                System.out.println();
                            }
                        }
                    }
                    break;

                    case 3: {
                        System.out.println("Enter number of testCentre to Update: ");
                        Scanner input = new Scanner(System.in);
                        int testCentreUpdate = input.nextInt();

                        for (TestCentre testCentreToUpdate : testCentres) {
                            if (testCentreUpdate == testCentreToUpdate.testCentreNo) {
                                testCentreToUpdate.update();
                            }
                        }
                    }
                    break;

                    case 4: {
                        for (TestCentre TestCentresToDisplay : testCentres) {
                            if (testCentres.isEmpty()) {
                                System.out.println("NO RECORDS AVAILABLE");
                            } else {
                                System.out.printf("TEST CENTRE %d", (testCentres.indexOf(TestCentresToDisplay) + 1));
                                TestCentresToDisplay.display();
                                System.out.println();
                            }
                        }
                    }
                    break;

                    case 5: {
                        System.out.println("Enter ID of testCentre to Delete: ");
                        Scanner input = new Scanner(System.in);
                        int testCentreDelete = input.nextInt();
                        boolean testCentreFound = false;

                        for (TestCentre testCentreToDelete : testCentres) {
                            if (testCentreDelete == testCentreToDelete.testCentreNo) {
                                testCentres.remove(testCentreToDelete);
                                System.out.println("Record removed successfully");
                                testCentreFound = true;
                                System.out.println();
                                break;
                            }

                        }
                        if (testCentreFound == false) {

                            System.out.println("Record Not Found");
                        }
                    }
                    break;

                    case 6: {
                        Scanner input = new Scanner(System.in);
                        System.out.println("YOU CAN ADD\n1.INVIGILATORS\n2.SUPERINTENDENT");
                        System.out.println("Enter your choice: ");
                        int choiceAtDutyTeam = input.nextInt();

                        while (true) {
                            if (choiceAtDutyTeam == 1) {
                                testCentre.addInvigilators();
                                break;
                            } else if (choiceAtDutyTeam == 2) {
                                testCentre.addSupervisor();
                                break;
                            } else {
                                System.out.println("Invalid Input");
                            }
                        }
                    }
                    break;


                    case 7: {
                        testCentre.showSupervisorDetails();
                    }
                    break;

                    case 8:
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
                break;

                case 4: {

                    System.out.println();
                    System.out.println("\t\t\tWELCOME TO THE NTS TEST PORTAL");
                    System.out.println();
                    System.out.println("1.ADD TEST DATA");
                    System.out.println("2.SEARCH TEST DATA");
                    System.out.println("3.UPDATE TEST DATA");
                    System.out.println("4.DISPLAY TEST DATA");
                    System.out.println("5.DELETE TEST DATA");
                    System.out.println("6.SHOW TEST DETAILS");
                    System.out.println("7.EXIT");
                }

                while (true) {
                    Scanner input = new Scanner(System.in);
                    try {
                        System.out.println("Enter your choice: ");
                        input = new Scanner(System.in);
                        choiceAtTestMenu = input.nextInt();
                        input.nextLine();
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid Input.Try again.");
                        input.nextLine();
                    }
                }

                switch (choiceAtTestMenu) {
                    case 1: {
                        test.setter();
                        tests.add(test);
                        System.out.println("ADDED SUCCESSFULLY");
                        System.out.println();
                    }
                    break;

                    case 2: {
                        System.out.println("Enter ID of test to search: ");
                        Scanner input = new Scanner(System.in);
                        int testSearch = input.nextInt();

                        for (Test testToSearch : tests) {
                            if (testSearch == testToSearch.testId) {
                                testToSearch.display();
                                System.out.println();
                            }
                        }
                    }
                    break;

                    case 3: {
                        System.out.println("Enter ID of test to Update: ");
                        Scanner input = new Scanner(System.in);
                        int testUpdate = input.nextInt();

                        for (Test testToUpdate : tests) {
                            if (testUpdate == testToUpdate.testId) {
                                testToUpdate.update();
                            }
                        }
                    }
                    break;

                    case 4: {
                        for (Test TestsToDisplay : tests) {
                            if (tests.isEmpty()) {
                                System.out.println("NO RECORDS AVAILABLE");
                            } else {
                                System.out.printf("TEST %d", (tests.indexOf(TestsToDisplay) + 1));
                                TestsToDisplay.display();
                                System.out.println();
                            }
                        }
                    }
                    break;

                    case 5: {
                        System.out.println("Enter ID of test to Delete: ");
                        Scanner input = new Scanner(System.in);
                        int testDelete = input.nextInt();
                        boolean testFound = false;

                        for (Test testToDelete : tests) {
                            if (testDelete == testToDelete.testId) {
                                tests.remove(testToDelete);
                                System.out.println("Record removed successfully");
                                testFound = true;
                                System.out.println();
                                break;
                            }

                        }
                        if (testFound == false) {
                            System.out.println("Record Not Found");
                        }
                    }
                    break;

                    case 6: {
                        test.checkAvailableTests();
                    }
                    break;

                    case 7:
                        break;

                    default:
                        System.out.println("INVALID CHOICE");

                }
                break;

                case 0:
                    System.out.println("EXITING THE PORTAL");
                    break;


                default:
                    System.out.println("Invalid choice");
            }

        }

    }

}
