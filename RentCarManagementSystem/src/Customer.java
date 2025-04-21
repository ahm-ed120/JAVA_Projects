// Customer Class (Extends Person)
public class Customer extends Person {
    private Car rentedCar;

    public Customer(String name, int age, int id) {
        super(name, age, id);
    }

    public void rentCar(Car car) {
        this.rentedCar = car;
        car.setAvailable(false); // Mark the car as rented
    }

    public void returnCar() {
        if (rentedCar != null) {
            rentedCar.setAvailable(true); // Mark the car as available
            rentedCar = null;
        }
    }

    public Car getRentedCar() {
        return rentedCar;
    }

    @Override
    public void displayRole() {
        System.out.println("I am a Customer.");
    }
}
