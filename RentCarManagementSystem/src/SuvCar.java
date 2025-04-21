// SUVCar Class
public class SuvCar extends Car {
    public SuvCar(String model, double pricePerDay, boolean isAvailable) {
        super(model, pricePerDay, isAvailable);
    }

    @Override
    public String getCarType() {
        return "SUV";
    }
}
