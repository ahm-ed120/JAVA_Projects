import java.util.Scanner;

public class Service {
    private int serviceId;
    private String name;
    private double price;

    Service() {
        serviceId = 0;
        name = null;
        price = 0.0;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setter() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter item id: ");
                serviceId = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid input for item id.");
                input.nextLine();
            }
        }

        System.out.println("Enter name: ");
        name = input.nextLine();

        while (true) {
            try {
                System.out.println("Enter price: ");
                price = input.nextDouble();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number for price.");
                input.nextLine();
            }
        }
    }

    public void update() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter new item id: ");
                serviceId = input.nextInt();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid input for item id.");
                input.nextLine();
            }
        }

        System.out.println("Enter new name: ");
        name = input.nextLine();

        while (true) {
            try {
                System.out.println("Enter new price: ");
                price = input.nextDouble();
                input.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number for price.");
                input.nextLine();
            }
        }
    }

    public void display() {
        System.out.println("Item id: " + serviceId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }

}
