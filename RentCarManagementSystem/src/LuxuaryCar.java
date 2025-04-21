// LuxuryCar Class
public class LuxuaryCar extends Car {
    public LuxuaryCar(String model, double pricePerDay, boolean isAvailable) {
        super(model, pricePerDay, isAvailable);
    }

    @Override
    public String getCarType() {
        return "Luxury";
    }
}
