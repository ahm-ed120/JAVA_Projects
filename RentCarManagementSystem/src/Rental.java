// Rental Class
public class Rental {
    private Car car;
    private int rentalDays;
    private Customer customer;

    public Rental(Car car, int rentalDays, Customer customer) {
        this.car = car;
        this.rentalDays = rentalDays;
        this.customer = customer;
    }

    public void rentCar() {
        if (car.isAvailable()) {
            car.setAvailable(false);
            System.out.println("CAR RENTED SUCCESSFULLY.");
        } else {
            System.out.println("CAR IS ALREADY RENTED.");
        }
    }

    public void returnCar() {
        car.setAvailable(true);
        System.out.println("CAR RETURNED SUCCESSFULLY.");
    }

    public void calculateBill() {
        double total = car.getPricePerDay() * rentalDays;
        System.out.println("CUSTOMER ID: " + customer.getId());
        System.out.println("CUSTOMER NAME: " + customer.getName());
        System.out.println("CAR MODEL: " + car.getModel());
        System.out.println("CAR TYPE: " + car.getCarType());
        System.out.println("RENTAL DAYS: " + rentalDays);
        System.out.println("TOTAL BILL: $" + total);
    }
}
