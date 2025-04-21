import java.util.ArrayList;
import java.util.Scanner;

public class House {
    private int houseNo;
    private double area;
    private double price;
    private double totalCost;
    private Owner owner;
    private ArrayList<Service> service;

    public House() {
        houseNo = 0;
        area = 0.0;
        price = 0.0;
        totalCost = 0.0;
        owner = new Owner();
        service = new ArrayList<>();

    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public int setter(ArrayList<Owner> availableOwner, ArrayList<Service> availableService) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter owner id: ");
        int ownerId = input.nextInt();

        for (Owner o : availableOwner) {
            if (o.getOwnerId() == ownerId) {
                owner = o;
                break;
            } else {
                System.out.println("Owner id not found!");
                return 0;
            }
        }

        System.out.println("Enter house number: ");
        houseNo = input.nextInt();

        System.out.println("Enter total area (in inches): ");
        area = input.nextDouble();

        System.out.println("Enter price of house: ");
        price = input.nextDouble();

        if (availableService == null) {
            System.out.println("Services not available!!");
            return 0;
        }

        System.out.println("*****Services*****");
        for (Service s : availableService) {
            s.display();
        }

        while (true) {
            System.out.println("Enter Service id (or -1 to exit):");
            int serviceId = input.nextInt();

            if (serviceId == -1) {
                if (service == null) {
                    System.out.println("Atleast enter one service");
                    continue;
                } else {
                    break;
                }
            }

            Service selectedService = null;

            for (Service s : availableService) {
                if (s.getServiceId() == serviceId) {
                    selectedService = s;
                    break;
                }

            }

            if (selectedService == null) {
                System.out.println("Id not found!!");
                continue;
            }

            service.add(selectedService);
            totalCost += selectedService.getPrice();
            
        }
        owner.addHouse(this);
        return 1;

    }

    public int update(ArrayList<Owner> availableOwner, ArrayList<Service> availableService) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter owner id: ");
        int ownerId = input.nextInt();

        for (Owner o : availableOwner) {
            if (o.getOwnerId() == ownerId) {
                owner = o;
                break;
            } else {
                System.out.println("Owner id not found!");
                return 0;
            }
        }

        System.out.println("Enter house number: ");
        houseNo = input.nextInt();

        System.out.println("Enter total area (in inches): ");
        area = input.nextDouble();

        System.out.println("Enter price of house: ");
        price = input.nextDouble();

        if (availableService == null) {
            System.out.println("Services not available!!");
            return 0;
        }

        System.out.println("*****Services*****");
        for (Service s : availableService) {
            s.display();
        }

        service.clear();

        while (true) {
            System.out.println("Enter Service id (or -1 to exit):");
            int serviceId = input.nextInt();

            if (serviceId == -1) {
                if (service == null) {
                    System.out.println("Atleast enter one service");
                    continue;
                } else {
                    break;
                }
            }

            Service selectedService = null;

            for (Service s : availableService) {
                if (s.getServiceId() == serviceId) {
                    selectedService = s;
                    break;
                }

            }

            if (selectedService == null) {
                System.out.println("Id not found!!");
                continue;
            }

            service.add(selectedService);
            totalCost += selectedService.getPrice();
            
        }
        return 1;
    }

    public void display(){
        System.out.println("House No: " + houseNo);
        System.out.println("Owner Id: " + owner.getOwnerId());
        System.out.println("Owner name: " + owner.name);
        System.out.println("***Services***");
        for (int i = 0; i < service.size(); i++) {
            Service s = service.get(i);
            System.out.println(s.getName() + " = " + s.getPrice());
        }
        System.out.println("Total bill: " + totalCost);

    
    }

}
