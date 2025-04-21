import java.util.ArrayList;

// CarRentalSystem Class
public class CarRentalSystem {
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void deleteCar(String model) {
        cars.removeIf(car -> car.getModel().equals(model));
    }

    public Car searchCar(String model) {
        for (Car car : cars) {
            if (car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public void displayCar() {
        for (Car car : cars) {
            if (car.isAvailable()) {
                System.out.println("MODEL: " + car.getModel() + ", TYPE: " + car.getCarType() + ", PRICE PER DAY: $" + car.getPricePerDay());
            }
        }
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer getCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public void displayAllCustomers() {
        for (Customer customer : customers) {
            System.out.print("Customer ID: " + customer.getId() + ", Name: " + customer.getName());
            if (customer.getRentedCar() != null) {
                System.out.println(", Rented Car: " + customer.getRentedCar().getModel());
            } else {
                System.out.println(", No car rented.");
            }
        }
    }
}
