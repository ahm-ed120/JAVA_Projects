public abstract class Person implements DetailsProvider {
    private int uniqueID;
    private String name;
    private int age;
    private String gender;
    private String address;
    private String phoneNumber;
    private String email;

    // Constructor
    public Person(int uniqueID, String name, int age, String gender, String address, String phoneNumber, String email) {
        this.uniqueID = uniqueID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters and Setters
    public int getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Implementation of getDetails method
    @Override
    public String getDetails() {
        return "ID: " + uniqueID + ", Name: " + name + ", Age: " + age + ", Gender: " + gender +
                ", Address: " + address + ", Phone: " + phoneNumber + ", Email: " + email;
    }

    // Implementation of displayInfo method
    @Override
    public void displayInfo() {
        System.out.println(getDetails());
    }
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Address: " + address + ", Phone: " + phoneNumber + ", Email: " + email;
    }
    // Abstract method for specialized behavior in subclasses
    public abstract void performRoleSpecificTask();
}
