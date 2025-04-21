import java.util.ArrayList;

public class PackageManager extends AdminPerson {
    private ArrayList<Package> packages;

    // Constructor
    public PackageManager(int uniqueID, String name, int age, String gender, String address,
                          String phoneNumber, String email, String username, String password, boolean authenticated) {
        super(uniqueID, name, age, gender, address, phoneNumber, email, username, password, authenticated);
        this.packages = new ArrayList<>();
    }

    // Method to add a new package
    public void addPackage(Package pack) {
        if (!isAuthenticated()) {
            System.out.println("Access denied. User is not authenticated.");
            return;
        }
        packages.add(pack);
        System.out.println("Package added: " + pack.getName());
    }

    // Method to remove a package by name
    public boolean removePackage(String packageName) {
        if (!isAuthenticated()) {
            System.out.println("Access denied. User is not authenticated.");
            return false;
        }
        for (Package pack : packages) {
            if (pack.getName().equalsIgnoreCase(packageName)) {
                packages.remove(pack);
                System.out.println("Package removed: " + packageName);
                return true;
            }
        }
        System.out.println("Package not found: " + packageName);
        return false;
    }

    // Method to display all packages
    public void displayPackages() {
        if (!isAuthenticated()) {
            System.out.println("Access denied. User is not authenticated.");
            return;
        }
        if (packages.isEmpty()) {
            System.out.println("No packages found.");
        } else {
            System.out.println("List of Packages:");
            for (Package pack : packages) {
                pack.displayInfo();
                System.out.println("----------------------");
            }
        }
    }

    // Method to search for a package by name
    public Package findPackageByName(String packageName) {
        for (Package pack : packages) {
            if (pack.getName().equalsIgnoreCase(packageName)) {
                return pack;
            }
        }
        return null;
    }

    // Overriding AdminPerson's displayInfo() to include package management details
    @Override
    public void displayInfo() {
        super.displayInfo(); // Display AdminPerson details
        System.out.println("Managing Packages:");
        displayPackages();
    }
}
