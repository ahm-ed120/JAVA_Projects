public class Package implements DetailsProvider {
    private String name;
    private double price;
    private double discount;
    private String description;
    private String access;

    // Constructor
    public Package(String name, double price, double discount, String description, String access) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.description = description;
        this.access = access;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    // Method to calculate the final price after discount
    public double calculateFinalPrice() {
        return price - (price * discount / 100);
    }

    // Implementing DetailsProvider interface methods
    @Override
    public String getDetails() {
        return "Package Name: " + name +
                ", Price: " + price +
                ", Discount: " + discount + "%" +
                ", Final Price: " + calculateFinalPrice() +
                ", Description: " + description +
                ", Access: " + access;
    }

    @Override
    public void displayInfo() {
        System.out.println("Package Details:");
        System.out.println(getDetails());
    }
}
