import java.util.ArrayList;

public class SubscriptionManager extends AdminPerson {
    private ArrayList<Subscription> subscriptions;

    // Constructor
    public SubscriptionManager(int uniqueID, String name, int age, String gender, String address,
                               String phoneNumber, String email, String username, String password, boolean authenticated) {
        super(uniqueID, name, age, gender, address, phoneNumber, email, username, password, authenticated);
        this.subscriptions = new ArrayList<>();
    }
    // Method to add a subscription
    public void addSubscription(Subscription subscription) {
        if (!isAuthenticated()) {
            System.out.println("Access denied. User is not authenticated.");
            return;
        }
        subscriptions.add(subscription);
        System.out.println("Subscription added: " + subscription.getType());
    }

    // Method to remove a subscription by type
    public boolean removeSubscription(String type) {
        if (!isAuthenticated()) {
            System.out.println("Access denied. User is not authenticated.");
            return false;
        }
        for (Subscription subscription : subscriptions) {
            if (subscription.getType().equalsIgnoreCase(type)) {
                subscriptions.remove(subscription);
                System.out.println("Subscription removed: " + type);
                return true;
            }
        }
        System.out.println("Subscription not found: " + type);
        return false;
    }

    public ArrayList<Subscription> getSubscriptions() {
        return subscriptions;
    }

    // Method to display all subscriptions
    public void displaySubscriptions() {
        if (!isAuthenticated()) {
            System.out.println("Access denied. User is not authenticated.");
            return;
        }
        if (subscriptions.isEmpty()) {
            System.out.println("No subscriptions available.");
        } else {
            System.out.println("List of Subscriptions:");
            for (Subscription subscription : subscriptions) {
                subscription.displayInfo();
                System.out.println("----------------------");
            }
        }
    }



    // Overriding AdminPerson's displayInfo() to include subscription management
    @Override
    public void displayInfo() {
        super.displayInfo(); // Display AdminPerson details
        System.out.println("Managing Subscriptions:");
        displaySubscriptions();
    }
}
