// Car Class (Abstract Class)
public abstract class Car implements CarDetails {
    private String model;
    private double pricePerDay;
    private boolean isAvailable;

    public Car(String model, double pricePerDay, boolean isAvailable) {
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.isAvailable = isAvailable;
    }

    public String getModel() {
        return model;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public abstract String getCarType();
}
