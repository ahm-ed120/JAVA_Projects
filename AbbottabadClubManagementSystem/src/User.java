import java.util.Calendar;
import java.util.Date;

public class User extends Person {
    private Package userPackage;
    private Subscription subscription;
    private Date subscriptionEndDate;
    private Date membershipStartDate;
    private Contact emergencyContact;
    private String medicalConditions;
    private String preferences;
    private User user;

    // Constructor
    public User(int uniqueID, String name, int age, String gender, String address, String phoneNumber, String email,
                Package userPackage, Subscription subscription, Date subscriptionEndDate, Date membershipStartDate,
                Contact emergencyContact, String medicalConditions, String preferences) {
        super(uniqueID, name, age, gender, address, phoneNumber, email);
        this.userPackage = userPackage;
        this.subscription = subscription;
        this.subscriptionEndDate = subscriptionEndDate;
        this.membershipStartDate = membershipStartDate;
        this.emergencyContact = emergencyContact;
        this.medicalConditions = medicalConditions;
        this.preferences = preferences;
    }

    // Getters and Setters
    public Package getUserPackage() {
        return userPackage;
    }

    // Getter for membership type (derived from Subscription)
    public String getMembershipType() {
        return subscription != null ? subscription.getType() : "None";
    }

    public void setUserPackage(Package userPackage) {
        this.userPackage = userPackage;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Date getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public void setSubscriptionEndDate(Date subscriptionEndDate) {
        this.subscriptionEndDate = subscriptionEndDate;
    }

    public Date getMembershipStartDate() {
        return membershipStartDate;
    }

    public void setMembershipStartDate(Date membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }

    public Contact getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(Contact emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public int getMembershipDuration() {
    if (membershipStartDate == null) {
        return 0; // If no start date is set, return 0 months
    }

    // Get the current date or subscription end date, whichever is earlier
    Date currentDate = new Date();
    Date endDate = subscriptionEndDate != null ? subscriptionEndDate : currentDate;

    // Use Calendar to calculate the difference in months
    Calendar startCalendar = Calendar.getInstance();
    startCalendar.setTime(membershipStartDate);

    Calendar endCalendar = Calendar.getInstance();
    endCalendar.setTime(endDate);

    int yearsDifference = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
    int monthsDifference = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

    // Calculate total months
    return (yearsDifference * 12) + monthsDifference;
}


    // Method to validate email
    public boolean validateEmail() {
        // Simple email validation logic
        return getEmail() != null && getEmail().contains("@") && getEmail().contains(".");
    }

    // Overriding getDetails to include user-specific information
    @Override
    public String getDetails() {
        return super.getDetails() +
                ", Package: " + (userPackage != null ? userPackage.getDetails() : "None") +
                ", Subscription: " + (subscription != null ? subscription.getDetails() : "None") +
                ", Membership Start Date: " + membershipStartDate +
                ", Subscription End Date: " + subscriptionEndDate +
                ", Emergency Contact: " + (emergencyContact != null ? emergencyContact.getContactDetails() : "None") +
                ", Medical Conditions: " + medicalConditions +
                ", Preferences: " + preferences;
    }


    // Overriding performRoleSpecificTask for user-specific tasks
    @Override
    public void performRoleSpecificTask() {
        System.out.println("User-specific task performed.");
    }

    public String toString() {
        return super.toString() + ", Membership Type: " +  "User Package" +userPackage+
        " Subscription " +subscription+
        " Start Date " +subscriptionEndDate+
        " End Date" + membershipStartDate+ " Contact " +emergencyContact+
        " Medical conditions: " + medicalConditions+
        "preferences: " +preferences+
        " User" +user;
    }

    // Method to display membership information
    public void displayMembershipInfo() {
        System.out.println("Membership Info:");
        System.out.println("Start Date: " + membershipStartDate);
        System.out.println("End Date: " + subscriptionEndDate);
        System.out.println("Package: " + (userPackage != null ? userPackage.getDetails() : "None"));
    }
}
