// Manager Class (Extends Person)
public class Manager extends Person {
    private CarRentalSystem carRentalSystem;

    public Manager(String name, int age, int id, CarRentalSystem carRentalSystem) {
        super(name, age, id);
        this.carRentalSystem = carRentalSystem;
    }

    @Override
    public void displayRole() {
        System.out.println("I am a Manager.");
    }

    public void addCar(Car car) {
        carRentalSystem.addCar(car);
        System.out.println("CAR ADDED SUCCESSFULLY.");
    }

    public void updateCarInfo(String oldModel, String newModel, double newPrice) {
        Car car = carRentalSystem.searchCar(oldModel);
        if (car != null) {
            carRentalSystem.deleteCar(oldModel);
            Car updatedCar = null;
            if (car instanceof LuxuaryCar) {
                updatedCar = new LuxuaryCar(newModel, newPrice, true);
            } else if (car instanceof EconomyCar) {
                updatedCar = new EconomyCar(newModel, newPrice, true);
            } else if (car instanceof SuvCar) {
                updatedCar = new SuvCar(newModel, newPrice, true);
            }
            if (updatedCar != null) {
                carRentalSystem.addCar(updatedCar);
                System.out.println("CAR UPDATED SUCCESSFULLY.");
            }
        } else {
            System.out.println("CAR NOT FOUND.");
        }
    }

    public void deleteCar(String model) {
        carRentalSystem.deleteCar(model);
        System.out.println("CAR DELETED SUCCESSFULLY.");
    }

    public void addCustomer(Customer customer) {
        carRentalSystem.addCustomer(customer);
        System.out.println("CUSTOMER ADDED SUCCESSFULLY.");
    }

    public Customer searchCustomer(int id) {
        return carRentalSystem.getCustomerById(id);
    }

    public void displayAllCustomers() {
        carRentalSystem.displayAllCustomers();
    }

    public void searchCar(String model) {
        Car car = carRentalSystem.searchCar(model);
        if (car != null) {
            System.out.println("CAR MODEL: " + car.getModel() + ", TYPE: " + car.getCarType() + ", PRICE PER DAY: $" + car.getPricePerDay());
        } else {
            System.out.println("CAR NOT FOUND.");
        }
    }
}
