import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CarRentalSystem carRentalSystem = new CarRentalSystem();
        Car luxuryCar = new LuxuaryCar("ABC999", 100.5, true);
        Car economyCar = new EconomyCar("ABC900", 75.5, true);
        Car suvCar = new SuvCar("ABC123", 50.5, true);
        Manager manager = new Manager("ALI", 22, 101, carRentalSystem);

        carRentalSystem.addCar(luxuryCar);
        carRentalSystem.addCar(economyCar);
        carRentalSystem.addCar(suvCar);

        int choice;
        do {
            System.out.println("\t\t\t\t CAR RENTAL SYSTEM");
            System.out.println("**********************************************************************************");
            System.out.println("1. CUSTOMER");
            System.out.println("2. MANAGER");
            System.out.println("3. EXIT");
            System.out.println("ENTER YOUR CHOICE OF ROLE ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    int customerChoice;
                    do {
                        System.out.println("\t\t\t\t CUSTOMER ");
                        System.out.println("1. DO CAR RENTING");
                        System.out.println("2. DO CAR RETURNING");
                        System.out.println("3. GO BACK");
                        System.out.println("ENTER YOUR CHOICE");
                        customerChoice = input.nextInt();

                        switch (customerChoice) {
                            case 1:
                                System.out.println("\t\t\t\tCAR RENTING");
                                System.out.println("ENTER YOUR CUSTOMER ID: ");
                                int customerId = input.nextInt();
                                Customer customer = carRentalSystem.getCustomerById(customerId);

                                if (customer == null) {
                                    System.out.println("CUSTOMER NOT FOUND. DO YOU WANT TO REGISTER? (YES=1 / NO=0)");
                                    int registerChoice = input.nextInt();
                                    if (registerChoice == 1) {
                                        input.nextLine();
                                        System.out.println("ENTER YOUR NAME: ");
                                        String name = input.nextLine();
                                        System.out.println("ENTER YOUR AGE: ");
                                        int age = input.nextInt();
                                        customer = new Customer(name, age, customerId);
                                        carRentalSystem.addCustomer(customer);
                                        System.out.println("CUSTOMER REGISTERED SUCCESSFULLY!");
                                    } else {
                                        System.out.println("YOU CANNOT RENT A CAR WITHOUT REGISTRATION.");
                                        continue;
                                    }
                                }

                                System.out.println("AVAILABLE CARS");
                                carRentalSystem.displayCar();
                                System.out.println("ENTER THE MODEL NUMBER OF CAR YOU WANT TO RENT: ");
                                input.nextLine();
                                String model = input.nextLine();
                                System.out.println("ENTER THE NUMBER OF DAYS YOU WANT TO RENT A CAR: ");
                                int days = input.nextInt();
                                Car carToRent = carRentalSystem.searchCar(model);

                                if (carToRent != null && carToRent.isAvailable()) {
                                    Rental rental = new Rental(carToRent, days, customer);
                                    rental.rentCar();
                                    System.out.println("\t\t\t\tYOUR TOTAL BILL:");
                                    rental.calculateBill();
                                } else {
                                    System.out.println("CAR IS NOT AVAILABLE");
                                }
                                break;

                            case 2:
                                System.out.println("\t\t\t\tRETURNING CAR");
                                System.out.println("ENTER THE MODEL NUMBER OF CAR: ");
                                input.nextLine();
                                String returnModel = input.nextLine();
                                Car carToReturn = carRentalSystem.searchCar(returnModel);
                                if (carToReturn != null && !carToReturn.isAvailable()) {
                                    Rental rental = new Rental(carToReturn, 0, null);
                                    rental.returnCar();
                                } else {
                                    System.out.println("CAR IS NOT AVAILABLE FOR RETURNING");
                                }
                                break;

                            case 3:
                                System.out.println("GOING BACK");
                                break;

                            default:
                                System.out.println("INVALID CHOICE");
                        }
                    } while (customerChoice != 3);
                    break;

                case 2:
                    int managerChoice;
                    do {
                        System.out.println("\t\t\t\t MANAGER ");
                        System.out.println("1. ADD CAR ");
                        System.out.println("2. UPDATE CAR ");
                        System.out.println("3. DELETE CAR ");
                        System.out.println("4. SEARCH CAR ");
                        System.out.println("5. ADD CUSTOMER ");
                        System.out.println("6. SEARCH CUSTOMER ");
                        System.out.println("7. DISPLAY ALL CUSTOMERS ");
                        System.out.println("8. GO BACK ");
                        System.out.println("ENTER YOUR CHOICE");
                        managerChoice = input.nextInt();

                        switch (managerChoice) {
                            case 1:
                                System.out.println("ADDING CARS ");
                                input.nextLine();
                                System.out.println("ENTER THE MODEL OF CAR YOU WANT TO ADD: ");
                                String carModel = input.nextLine();
                                System.out.println("ENTER THE PRICE PER DAY OF CAR: ");
                                double price = input.nextDouble();
                                System.out.println("1. LUXURY CAR ");
                                System.out.println("2. ECONOMY CAR ");
                                System.out.println("3. SUV CAR ");
                                System.out.println("CHOOSE CAR TYPE: ");
                                int carType = input.nextInt();
                                Car newCar = null;
                                if (carType == 1) {
                                    newCar = new LuxuaryCar(carModel, price, true);
                                } else if (carType == 2) {
                                    newCar = new EconomyCar(carModel, price, true);
                                } else if (carType == 3) {
                                    newCar = new SuvCar(carModel, price, true);
                                }

                                if (newCar != null) {
                                    manager.addCar(newCar);
                                } else {
                                    System.out.println("INVALID CAR TYPE");
                                }
                                break;

                            case 2:
                                System.out.println("UPDATING CARS ");
                                input.nextLine();
                                System.out.println("ENTER THE OLD MODEL NUMBER OF CAR: ");
                                String oldModel = input.nextLine();
                                System.out.println("ENTER THE NEW MODEL NUMBER OF CAR: ");
                                String newModel = input.nextLine();
                                System.out.println("ENTER THE NEW PRICE OF CAR: ");
                                double newPrice = input.nextDouble();
                                manager.updateCarInfo(oldModel, newModel, newPrice);
                                break;

                            case 3:
                                System.out.println("DELETING CAR ");
                                input.nextLine();
                                System.out.println("ENTER THE MODEL NUMBER OF CAR YOU WANT TO DELETE: ");
                                String deleteModel = input.nextLine();
                                manager.deleteCar(deleteModel);
                                break;

                            case 4:
                                System.out.println("SEARCHING CAR ");
                                input.nextLine();
                                System.out.println("ENTER THE CAR MODEL TO SEARCH: ");
                                String searchModel = input.nextLine();
                                manager.searchCar(searchModel);
                                break;

                            case 5:
                                System.out.println("ADDING CUSTOMER ");
                                input.nextLine();
                                System.out.println("ENTER CUSTOMER ID: ");
                                int customerId = input.nextInt();
                                input.nextLine();
                                System.out.println("ENTER CUSTOMER NAME: ");
                                String customerName = input.nextLine();
                                System.out.println("ENTER CUSTOMER AGE: ");
                                int customerAge = input.nextInt();
                                Customer customer = new Customer(customerName, customerAge, customerId);
                                manager.addCustomer(customer);
                                break;

                            case 6:
                                System.out.println("SEARCHING CUSTOMER ");
                                System.out.println("ENTER CUSTOMER ID TO SEARCH: ");
                                int searchCustomerId = input.nextInt();
                                Customer searchedCustomer = manager.searchCustomer(searchCustomerId);
                                if (searchedCustomer != null) {
                                    System.out.println("CUSTOMER ID: " + searchedCustomer.getId());
                                    System.out.println("CUSTOMER NAME: " + searchedCustomer.getName());
                                    if (searchedCustomer.getRentedCar() != null) {
                                        System.out.println("RENTED CAR: " + searchedCustomer.getRentedCar().getModel());
                                    } else {
                                        System.out.println("NO CAR RENTED");
                                    }
                                } else {
                                    System.out.println("CUSTOMER NOT FOUND.");
                                }
                                break;

                            case 7:
                                System.out.println("DISPLAYING ALL CUSTOMERS ");
                                manager.displayAllCustomers();
                                break;

                            case 8:
                                System.out.println("GOING BACK");
                                break;

                            default:
                                System.out.println("INVALID CHOICE");
                        }
                    } while (managerChoice != 8);
                    break;

                case 3:
                    System.out.println("EXITING SYSTEM");
                    break;

                default:
                    System.out.println("INVALID CHOICE");
            }
        } while (choice != 3);

        input.close();
    }
}
