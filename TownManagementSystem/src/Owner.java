import java.util.ArrayList;
import java.util.Scanner;

public class Owner extends Person {
    private int ownerId;
    ArrayList <House> house;

    Owner() {
        super();
        ownerId = 0;
        house = new ArrayList<>();
    }

    public void addHouse(House house){
        this.house.add(house);
    }

    
    public void setter() {

        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter owner id: ");
                ownerId = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for customer id.");
                input.nextLine();
            }
        }

        System.out.println("Enter name:");
        name = input.nextLine();

        while (true) {
            try {
                System.out.println("Enter age: ");
                age = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for age.");
                input.nextLine();
            }
        }

        System.out.println("Enter address: ");
        address = input.nextLine();

        System.out.println("Enter phone number: ");
        phoneNo = input.nextLine();
    }

    public void update() {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter new customer id: ");
                ownerId = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for customer id.");
                input.nextLine();
            }
        }

        System.out.println("Enter new name:");
        name = input.nextLine();

        while (true) {
            try {
                System.out.println("Enter new age: ");
                age = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for age.");
                input.nextLine();
            }
        }

        System.out.println("Enter new address: ");
        address = input.nextLine();

        System.out.println("Enter new phone number: ");
        phoneNo = input.nextLine();
    }

    public void display() {
        System.out.println("Customer id: " + ownerId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNo);
    }


    public int getOwnerId() {
        return ownerId;
    }


    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }


    public ArrayList<House> getHouse() {
        return house;
    }


    public void setHouse(ArrayList<House> house) {
        this.house = house;
    }

    
}
