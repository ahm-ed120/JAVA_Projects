// EconomyCar Class
public class EconomyCar extends Car {
    public EconomyCar(String model, double pricePerDay, boolean isAvailable) {
        super(model, pricePerDay, isAvailable);
    }

    @Override
    public String getCarType() {
        return "Economy";
    }
}
