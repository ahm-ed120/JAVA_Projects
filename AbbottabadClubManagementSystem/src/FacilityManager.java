import java.util.ArrayList;

public class FacilityManager extends AdminPerson {
    private ArrayList<Facility> facilities;

    // Constructor
    public FacilityManager(int uniqueID, String name, int age, String gender, String address,
                           String phoneNumber, String email, String username, String password, boolean authenticated) {
        super(uniqueID, name, age, gender, address, phoneNumber, email, username, password, authenticated);
        this.facilities = new ArrayList<>();
    }

    // Method to add a new facility
    public void addFacility(Facility facility) {
        if (!isAuthenticated()) {
            System.out.println("Access denied. User is not authenticated.");
            return;
        }
        facilities.add(facility);
        System.out.println("Facility added: " + facility.getName());
    }

    // Method to remove a facility by name
    public boolean removeFacility(String facilityName) {
        if (!isAuthenticated()) {
            System.out.println("Access denied. User is not authenticated.");
            return false;
        }
        for (Facility facility : facilities) {
            if (facility.getName().equalsIgnoreCase(facilityName)) {
                facilities.remove(facility);
                System.out.println("Facility removed: " + facilityName);
                return true;
            }
        }
        System.out.println("Facility not found: " + facilityName);
        return false;
    }

    // Method to display all facilities
    public void displayFacilities() {
        if (!isAuthenticated()) {
            System.out.println("Access denied. User is not authenticated.");
            return;
        }
        if (facilities.isEmpty()) {
            System.out.println("No facilities found.");
        } else {
            System.out.println("List of Facilities:");
            for (Facility facility : facilities) {
                facility.displayInfo();
                System.out.println("----------------------");
            }
        }
    }

    // Method to search for a facility by name
    public Facility findFacilityByName(String facilityName) {
        for (Facility facility : facilities) {
            if (facility.getName().equalsIgnoreCase(facilityName)) {
                return facility;
            }
        }
        return null;
    }

    // Overriding AdminPerson's displayInfo() to include facility management details
    @Override
    public void displayInfo() {
        super.displayInfo(); // Display AdminPerson details
        System.out.println("Managing Facilities:");
        displayFacilities();
    }
}
