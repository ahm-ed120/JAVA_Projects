public class Subscription implements DetailsProvider {
    private String type;
    private double price;
    private double discount;
    private String description;
    private String termsConditions;
    private int duration;

    // Constructor
    public Subscription(String type, double price, double discount, String description, String termsConditions, int duration) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.description = description;
        this.termsConditions = termsConditions;
    }

    // Getters and Setters

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTermsConditions() {
        return termsConditions;
    }

    public void setTermsConditions(String termsConditions) {
        this.termsConditions = termsConditions;
    }

    // Method to calculate the final price after discount
    public double calculateFinalPrice() {
        return price - (price * discount / 100);
    }


    // Implementing the DetailsProvider interface methods
    @Override
    public String getDetails() {
        return "Type: " + type +
                ", Price: " + price +
                ", Discount: " + discount + "%" +
                ", Final Price: " + calculateFinalPrice() +
                ", Description: " + description +
                ", Terms & Conditions: " + termsConditions;
    }

    @Override
    public void displayInfo() {
        System.out.println("Subscription Details:");
        System.out.println(getDetails());
    }
}
