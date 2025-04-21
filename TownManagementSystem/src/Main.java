import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employee = new ArrayList<>();
        ArrayList<House> house = new ArrayList<>();
        ArrayList<Owner> owner = new ArrayList<>();
        ArrayList<Service> service = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("1.Manage House");
            System.out.println("2.Manage Owner");
            System.out.println("3.Manage Employee");
            System.out.println("4.Manage Service");
            System.out.println("0.Exit");

            int choice = input.nextInt();
            switch (choice) {
                case 1:

                    while (true) {
                        System.out.println("\n****Manage House****\n");
                        System.out.println("1.Add house");
                        System.out.println("2.Update house");
                        System.out.println("3.Delete house");
                        System.out.println("4.Display house");
                        System.out.println("0.Exit");

                        int choice1 = input.nextInt();

                        switch (choice1) {
                            case 1:
                                House h = new House();
                                int x = h.setter(owner, service);
                                if (x == 1) {
                                    house.add(h);
                                    System.out.println("House added successfully");
                                } else {
                                    System.out.println("House not added.");
                                }
                                break;
                            case 2:
                                System.out.println("Enter House no to update");
                                int houseNo = input.nextInt();
                                int found = 0;

                                for (House h1 : house) {
                                    if (h1.getHouseNo() == houseNo) {
                                        int y = h1.update(owner, service);
                                        if (y == 0) {
                                            System.out.println("House not updated.");
                                        }
                                        found = 1;
                                        break;
                                    }
                                }
                                if (found == 0) {
                                    System.out.println("House not found");
                                }

                                break;
                            case 3:
                                System.out.println("Enter house no to remove");
                                houseNo = input.nextInt();
                                found = 0;
                                for (House h2 : house) {
                                    if (h2.getHouseNo() == houseNo) {
                                        house.remove(h2);
                                        System.out.println("House deleted.");
                                        found = 1;
                                        break;
                                    }
                                }
                                if (found == 0) {
                                    System.out.println("House not found.");
                                }
                                break;
                            case 4:
                                for (House h2 : house) {
                                    h2.display();
                                    System.out.println();

                                }
                                break;
                            case 0:
                                System.out.println("Back to main menu");
                                break;
                            default:
                                System.out.println("Invalid input.");
                        }

                        if (choice1 == 0) {
                            break;
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("\n****Manage Owner****\n");
                        System.out.println("1.Add Owner");
                        System.out.println("2.Update Owner");
                        System.out.println("3.Delete Owner");
                        System.out.println("4.Display Owner");
                        System.out.println("5.Generate House bill");
                        System.out.println("Generate Owner Bill");
                        System.out.println("0.Exit");

                        int choice1 = input.nextInt();

                        switch (choice1) {
                            case 1:
                                Owner o = new Owner();
                                o.setter();
                                owner.add(o);
                                break;
                            case 2:
                                System.out.println("Enter Owner id to update");
                                int ownerId = input.nextInt();
                                int found = 0;
                                for (Owner o1 : owner) {
                                    if (o1.getOwnerId() == ownerId) {
                                        o1.update();
                                        found = 1;
                                        break;
                                    }
                                }
                                if (found == 0) {
                                    System.out.println("Owner not found");
                                }
                                break;
                            case 3:
                                System.out.println("Enter owner id to remove");
                                ownerId = input.nextInt();
                                found = 0;
                                for (Owner o2 : owner) {
                                    if (o2.getOwnerId() == ownerId) {
                                        owner.remove(o2);
                                        System.out.println("Owner deleted.");
                                        found = 1;
                                        break;
                                    }
                                }
                                if (found == 0) {
                                    System.out.println("Owner not found.");
                                }
                                break;
                            case 4:
                                for (Owner o2 : owner) {
                                    o2.display();
                                    System.out.println();
                                }
                                break;
                            case 5:
                                System.out.println("Enter owner id to generate house bill: ");
                                ownerId = input.nextInt();
                                Bill b = new Bill();
                                for (Owner o1: owner){
                                    if (o1.getOwnerId() == ownerId){
                                        b.addOwner(o1);
                                        break;
                                    }
                                }
                                
                                b.generatreHouseBill();
                                break;

                            case 6:
                            System.out.println("Enter owner id to generate owner bill: ");
                            ownerId = input.nextInt();
                            Bill b1 = new Bill();
                            for (Owner o1: owner){
                                if (o1.getOwnerId() == ownerId){
                                    b1.addOwner(o1);
                                    break;
                                }
                            }
                            
                            b1.generateOwnerBill();
                            break;
                            case 0:
                                System.out.println("Back to main menu");
                                break;
                            default:
                                System.out.println("Invalid input.");
                        }

                        if (choice1 == 0) {
                            break;
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        System.out.println("\n****Manage Employee****\n");
                        System.out.println("1.Add employee");
                        System.out.println("2.Update employee");
                        System.out.println("3.Delete employee");
                        System.out.println("4.Display employee");
                        System.out.println("0.Exit");

                        int choice1 = input.nextInt();

                        switch (choice1) {
                            case 1:
                                Employee e = new Employee();
                                e.setter();
                                employee.add(e);
                                break;
                            case 2:
                                System.out.println("Enter employee id to update");
                                int employeeId = input.nextInt();
                                int found = 0;
                                for (Employee e1 : employee) {
                                    if (e1.getEmployeeId() == employeeId) {
                                        e1.update();
                                        found = 1;
                                        break;
                                    }
                                }
                                if (found == 0) {
                                    System.out.println("Employee not found");
                                }
                                break;
                            case 3:
                                System.out.println("Enter employee id to remove");
                                employeeId = input.nextInt();
                                found = 0;
                                for (Employee e2 : employee) {
                                    if (e2.getEmployeeId() == employeeId) {
                                        employee.remove(e2);
                                        System.out.println("Employee deleted.");
                                        found = 1;
                                        break;
                                    }
                                }
                                if (found == 0) {
                                    System.out.println("Employee not found.");
                                }
                                break;
                            case 4:
                                for (Employee e2 : employee) {
                                    e2.display();
                                    System.out.println();
                                }
                                break;
                            case 0:
                                System.out.println("Back to main menu");
                                break;
                            default:
                                System.out.println("Invalid input.");
                        }

                        if (choice1 == 0) {
                            break;
                        }
                    }
                    break;
                case 4:
                    while (true) {
                        System.out.println("\n****Manage Service****\n");
                        System.out.println("1.Add service");
                        System.out.println("2.Update service");
                        System.out.println("3.Delete service");
                        System.out.println("4.Display service");
                        System.out.println("0.Exit");

                        int choice1 = input.nextInt();

                        switch (choice1) {
                            case 1:
                                Service s = new Service();
                                s.setter();
                                service.add(s);
                                break;
                            case 2:
                                System.out.println("Enter service id to update");
                                int serviceId = input.nextInt();
                                int found = 0;
                                for (Service s1 : service) {
                                    if (s1.getServiceId() == serviceId) {
                                        s1.update();
                                        found = 1;
                                        break;
                                    }
                                }
                                if (found == 0) {
                                    System.out.println("Employee not found");
                                }
                                break;
                            case 3:
                                System.out.println("Enter service id to remove");
                                serviceId = input.nextInt();
                                found = 0;
                                for (Service s2 : service) {
                                    if (s2.getServiceId() == serviceId) {
                                        service.remove(s2);
                                        System.out.println("Service deleted.");
                                        found = 1;
                                        break;
                                    }
                                }
                                if (found == 0) {
                                    System.out.println("Service not found.");
                                }
                                break;
                            case 4:
                                for (Service s2 : service) {
                                    s2.display();
                                    System.out.println();

                                }
                                break;
                            case 0:
                                System.out.println("Back to main menu");
                                break;
                            default:
                                System.out.println("Invalid input.");
                        }

                        if (choice1 == 0) {
                            break;
                        }
                    }
                    break;
                case 0:
                    System.out.println("Exiting the program");
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
            if (choice == 0) {
                break;
            }
        }

    }

}
