public class AdminPerson extends Person {
    private String username;
    private String password;
    private boolean authenticated;

    // Constructor
    // Constructor
    public AdminPerson(int uniqueID, String name, int age, String gender, String address, String phoneNumber,
                       String email, String username, String password, boolean authenticated) {
        super(uniqueID, name, age, gender, address, phoneNumber, email); // Pass to Person
        this.username = username;
        this.password = password;
        this.authenticated = authenticated;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    // Method to log in
    public boolean login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            this.authenticated = true;
            return true;
        }
        this.authenticated = false;
        return false;
    }

    // Overridden getDetails method
    @Override
    public String getDetails() {
        return super.getDetails() +
                ", Username: " + username +
                ", Authenticated: " + authenticated;
    }

    // Overridden displayInfo method
    @Override
    public void displayInfo() {
        System.out.println("Admin Details:");
        System.out.println(getDetails());
    }

    // Overridden performRoleSpecificTask for admin-specific tasks
    @Override
    public void performRoleSpecificTask() {
        if (authenticated) {
            System.out.println("Performing administrative tasks...");
        } else {
            System.out.println("Access denied. Please log in first.");
        }
    }

    public String toString() {
        return super.toString() + ", Username: " + username + ", Super Admin: " + authenticated;
    }
}
