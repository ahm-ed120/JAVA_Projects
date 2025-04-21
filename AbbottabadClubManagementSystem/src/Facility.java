public class Facility implements DetailsProvider {
    private String name;
    private String managerContact;
    private String usageRules;

    // Constructor
    public Facility(String name, String managerContact, String usageRules) {
        this.name = name;
        this.managerContact = managerContact;
        this.usageRules = usageRules;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerContact() {
        return managerContact;
    }

    public void setManagerContact(String managerContact) {
        this.managerContact = managerContact;
    }

    public String getUsageRules() {
        return usageRules;
    }

    public void setUsageRules(String usageRules) {
        this.usageRules = usageRules;
    }

    // Implementing DetailsProvider interface methods
    @Override
    public String getDetails() {
        return "Facility Name: " + name +
                ", Manager Contact: " + managerContact +
                ", Usage Rules: " + usageRules;
    }

    @Override
    public void displayInfo() {
        System.out.println("Facility Details:");
        System.out.println(getDetails());
    }
}
