public class Contact {
    private String name;
    private String phoneNumber;

    // Constructor
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Method to get contact details as a formatted string
    public String getContactDetails() {
        return "Name: " + name + ", Phone Number: " + phoneNumber;
    }

    // Display contact details
    public void displayContactDetails() {
        System.out.println(getContactDetails());
    }
}
