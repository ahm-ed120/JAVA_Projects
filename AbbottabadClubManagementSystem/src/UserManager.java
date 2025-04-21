import java.util.ArrayList;

public class UserManager extends AdminPerson {
    private ArrayList<User> users;

    // Constructor
    public UserManager(int uniqueID, String name, int age, String gender, String address,
                       String phoneNumber, String email, String username, String password, boolean authenticated) {
        super(uniqueID, name, age, gender, address, phoneNumber, email, username, password, authenticated);
        this.users = new ArrayList<>();
    }
    public ArrayList<User> getUsers() {
        return users;
    }
    // Method to add a new user
    public void addUser(User user) {
        if (!isAuthenticated()) {
            System.out.println("Access denied. User is not authenticated.");
            return;
        }
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

    // Method to remove a user by ID
    public boolean removeUser(int uniqueID) {
        if (!isAuthenticated()) {
            System.out.println("Access denied. User is not authenticated.");
            return false;
        }
        for (User user : users) {
            if (user.getUniqueID() == uniqueID) {
                users.remove(user);
                System.out.println("User removed: " + user.getName());
                return true;
            }
        }
        System.out.println("User not found with ID: " + uniqueID);
        return false;
    }

    // Method to display all users
    public void displayUsers() {
        if (!isAuthenticated()) {
            System.out.println("Access denied. User is not authenticated.");
            return;
        }
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("List of Users:");
            for (User user : users) {
                user.displayInfo();
                System.out.println("----------------------");
            }
        }
    }

    // Method to search for a user by ID
    public User findUserByID(int uniqueID) {
        for (User user : users) {
            if (user.getUniqueID() == uniqueID) {
                return user;
            }
        }
        return null;
    }

    // Overriding AdminPerson's displayInfo() to include user management details
    @Override
    public void displayInfo() {
        super.displayInfo(); // Display AdminPerson details
        System.out.println("Managing Users:");
        displayUsers();
    }
}
