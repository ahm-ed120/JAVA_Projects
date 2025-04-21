public class Cafe implements DetailsProvider {
    private String name;
    private String managerContact;
    private String menuHighlights;

    // Constructor
    public Cafe(String name, String managerContact, String menuHighlights) {
        this.name = name;
        this.managerContact = managerContact;
        this.menuHighlights = menuHighlights;
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

    public String getMenuHighlights() {
        return menuHighlights;
    }

    public void setMenuHighlights(String menuHighlights) {
        this.menuHighlights = menuHighlights;
    }

    // Implementing DetailsProvider interface methods
    @Override
    public String getDetails() {
        return "Cafe Name: " + name +
                ", Manager Contact: " + managerContact +
                ", Menu Highlights: " + menuHighlights;
    }

    @Override
    public void displayInfo() {
        System.out.println("Cafe Details:");
        System.out.println(getDetails());
    }
}
