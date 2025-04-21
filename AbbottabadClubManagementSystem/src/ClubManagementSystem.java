import java.time.Duration;
import java.util.Scanner;

public class ClubManagementSystem implements ReportGenerator {
    private SubscriptionManager subscriptionManager;
    private EmployeeManager employeeManager;
    private PackageManager packageManager;
    private UserManager userManager;
    private FacilityManager facilityManager;
    private AdminPerson admin;
    private AdminPerson khizer;
    private GenericManager<Person> personManager;
    

    // Constructor
    public ClubManagementSystem() {
        personManager = new GenericManager<>(); // Initialize the GenericManager for Person

        subscriptionManager = new SubscriptionManager(
                1, "Admin Subscriptions", 45, "Male", "123 Admin St.",
                "123-456-7890", "admin@club.com", "subAdmin", "password", true
        );
        employeeManager = new EmployeeManager(
                2, "Admin Employees", 40, "Female", "456 Admin Ave.",
                "987-654-3210", "admin@club.com", "empAdmin", "password", true
        );
        packageManager = new PackageManager(
                3, "Admin Packages", 50, "Other", "789 Admin Blvd.",
                "555-123-4567", "admin@club.com", "pkgAdmin", "password", true
        );
        userManager = new UserManager(
                4, "User Admin", 30, "Female", "123 User St.",
                "123-987-6543", "user@club.com", "userAdmin", "password", true
        );
        facilityManager = new FacilityManager(
                5, "Facility Admin", 35, "Male", "789 Facility Blvd.",
                "555-789-1234", "facility@club.com", "facAdmin", "password", true
        );
        admin = new AdminPerson(
                0,               // Unique ID
                "Admin",         // Name
                35,              // Age
                "Male",          // Gender
                "123 Admin St.", // Address
                "123-456-7890",  // Phone Number
                "admin@Abbottabadclub.com",// Email
                "admin",         // Username
                "password",      // Password
                false            // Authenticated status

        );

        khizer = new AdminPerson(
                0,               // Unique ID
                "khizer",         // Name
                111,              // Age
                "Male",          // Gender
                "123 Admin St.", // Address
                "123-456-7890",  // Phone Number
                "khizer@Abbottabadclub.com",// Email
                "khizer",         // Username
                "123",      // Password
                false            // Authenticated status

        );
    }

    // Main menu for the club management system
    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Abbottabad Club Management System ===");
            System.out.println("1. Manage Subscriptions");
            System.out.println("2. Manage Employees");
            System.out.println("3. Manage Packages");
            System.out.println("4. Manage Users (Club Members)");
            System.out.println("5. Manage Facilities");
            System.out.println("----------------------");
            System.out.println("7. Generate Report");
            System.out.println("8. Display Roles");
            System.out.println("9. Add Person");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> manageSubscriptions();
                case 2 -> manageEmployees();
                case 3 -> managePackages();
                case 4 -> manageUsers();
                case 5 -> manageFacilities();
              //  case 6 -> searchMenu();
                case 7 -> generateReport();
                case 8 -> {
                    System.out.println("Select a role to show details:");
                    System.out.println("1. Admin");
                    System.out.println("2. Employee");
                    System.out.println("3. User");
                    System.out.print("Enter your choice: ");
                    int detailChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (detailChoice) {
                        case 1:
                            displayRoleDetails(admin);
                            break;
                        case 2:
                            displayRoleDetails(new Employee(1, "Khizer", 123, "Male", "123 Employee St.", "123-456-7890", "employee@club.com", "Manager", "Day", "Manage operations",50000,12));
                            break;
                        case 3:
                            displayRoleDetails(new User(2, "Ahmed", 30, "Male", "456 User St.", "987-654-3210", "user@club.com", null, null, null, null, null, null, "Basic"));
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
                case 9 ->  managePersons();
                case 10 -> System.out.println("Exiting system. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 10); // Loop continues until 'Exit' is selected

        scanner.close();
    }
    public void displayRoleDetails(Person person) {
        System.out.println(person.getDetails()); 
    }

   

    private void generateReport() {
        Scanner scanner = new Scanner(System.in);
        int choice;
    
        do {
            System.out.println("\n--- Generate Report ---");
            System.out.println("1. Member Report");
            System.out.println("2. Employee Report");
            System.out.println("3. Subscription Report");
            System.out.println("4. Member Insights Report");
            System.out.println("5. Employee Insights Report");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (choice) {
                case 1 -> generateMemberReport();
                case 2 -> generateEmployeeReport();
                case 3 -> generateSubscriptionReport();
                case 4 -> generateMemberInsightsReport();
                case 5 -> generateEmployeeInsightsReport();
                case 6 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }
    
    public void generateMemberReport() {
        System.out.println("\n--- Member Report ---");
        System.out.println("ID\tName\tMembership Type\tPhone\tEmail");
        System.out.println("--------------------------------------------------");
    
        for (User user : userManager.getUsers()) {
            System.out.printf("%d\t%s\t%s\t%s\t%s%n",
                    user.getUniqueID(), user.getName(), user.getMembershipType(), user.getPhoneNumber(), user.getEmail());
        }
    }
    
    public void generateSubscriptionReport() {
        System.out.println("\n--- Subscription Report ---");
        System.out.println("Type\tPrice\tDuration\tDiscount\tDescription");
        System.out.println("--------------------------------------------------");
    
        for (Subscription subscription : subscriptionManager.getSubscriptions()) {
            System.out.printf("%s\t%.2f\t%d\t%.2f%%\t%s%n",
                    subscription.getType(),
                    subscription.getPrice(),
                    subscription.getDuration(),
                    subscription.getDiscount(),
                    subscription.getDescription());
        }
    }
    
    public void generateEmployeeReport() {
        System.out.println("\n--- Employee Report ---");
        System.out.println("ID\tName\tPosition\tShift\tPhone\tEmail");
        System.out.println("--------------------------------------------------");
    
        for (Employee employee : employeeManager.getEmployees()) {
            System.out.printf("%d\t%s\t%s\t%s\t%s\t%s%n",
                    employee.getUniqueID(),
                    employee.getName(),
                    employee.getPosition(),
                    employee.getShift(),
                    employee.getPhoneNumber(),
                    employee.getEmail());
        }
    }
    


    public void generateMemberInsightsReport() {
        System.out.println("\n--- Member Insights Report ---");
    
        // Count males and females
        int maleCount = 0, femaleCount = 0;
        for (User user : userManager.getUsers()) {
            String gender = user.getGender().trim().toLowerCase();
            if (gender.equals("male") || gender.equals("m")) {
                maleCount++;
            } else if (gender.equals("female") || gender.equals("f")) {
                femaleCount++;
            }
        }
        System.out.printf("Number of Male Members: %d%n", maleCount);
        System.out.printf("Number of Female Members: %d%n", femaleCount);
    
        // List members whose membership duration is less than 6 months
        System.out.println("\nMembers with Membership Duration Less than 6 Months:");
        System.out.println("ID\tName\tPhone\tEmail\tMembership Type");
        System.out.println("--------------------------------------------------");
        for (User user : userManager.getUsers()) {
            if (user.getMembershipDuration() < 6) {
                System.out.printf("%d\t%s\t%s\t%s\t%s%n",
                        user.getUniqueID(), user.getName(), user.getPhoneNumber(), user.getEmail(), user.getMembershipType());
            }
        }
    
        // List members whose membership duration is greater than 24 months
        System.out.println("\nLoyal Members (Membership Duration Greater than 24 Months):");
        System.out.println("ID\tName\tPhone\tEmail\tMembership Type");
        System.out.println("--------------------------------------------------");
        for (User user : userManager.getUsers()) {
            if (user.getMembershipDuration() > 24) {
                System.out.printf("%d\t%s\t%s\t%s\t%s%n",
                        user.getUniqueID(), user.getName(), user.getPhoneNumber(), user.getEmail(), user.getMembershipType());
            }
        }
    }
    
    
    public void generateEmployeeInsightsReport() {
        System.out.println("\n--- Employee Insights Report ---");
    
        // Count male and female employees
        int maleCount = 0, femaleCount = 0;
        for (Employee employee : employeeManager.getEmployees()) {
            String gender = employee.getGender().trim().toLowerCase();
            if (gender.equals("male") || gender.equals("m")) {
                maleCount++;
            } else if (gender.equals("female") || gender.equals("f")) {
                femaleCount++;
            }
        }
        System.out.printf("Number of Male Employees: %d%n", maleCount);
        System.out.printf("Number of Female Employees: %d%n", femaleCount);
    
        // List employees earning more than 50000 PKR
        System.out.println("\nEmployees Earning More than 50000 PKR:");
        System.out.println("ID\tName\tPosition\tSalary\tPhone\tEmail");
        System.out.println("--------------------------------------------------");
        for (Employee employee : employeeManager.getEmployees()) {
            if (employee.getSalary() > 50000) {
                System.out.printf("%d\t%s\t%s\t%.2f\t%s\t%s%n",
                        employee.getUniqueID(),
                        employee.getName(),
                        employee.getPosition(),
                        employee.getSalary(),
                        employee.getPhoneNumber(),
                        employee.getEmail());
            }
        }
    
        // List employees with duration of employment
        System.out.println("\nEmployees and their Employment Duration (in Months):");
        System.out.println("ID\tName\tPosition\tEmployment Duration\tPhone\tEmail");
        System.out.println("--------------------------------------------------");
        for (Employee employee : employeeManager.getEmployees()) {
            System.out.printf("%d\t%s\t%s\t%d\t%s\t%s%n",
                    employee.getUniqueID(),
                    employee.getName(),
                    employee.getPosition(),
                    employee.getEmploymentDuration(),
                    employee.getPhoneNumber(),
                    employee.getEmail());
        }
    }
    




    private void managePersons() {
        if (!authenticateAdmin()) return;
        Scanner scanner = new Scanner(System.in);
        int choice;
    
        do {
            System.out.println("\n--- Manage Persons ---");
            System.out.println("1. Add Person");
            System.out.println("2. Remove Person");
            System.out.println("3. Display All Persons");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter person type (Admin/Employee/User): ");
                    String type = scanner.nextLine();
                    Person person = createPerson(type, scanner);
                    if (person != null) {
                        personManager.addItem(person);
                    }
                }
                case 2 -> {
                    System.out.print("Enter person name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    // Implement a method to find and remove a person by name or another identifier.
                  Person personToRemove = findPersonByName(nameToRemove);
                   if (personToRemove != null) {
                       personManager.removeItem(personToRemove);
                   } else {
                      System.out.println("Person not found.");
                  }
               }
                case 3 -> personManager.displayItems();
                case 4 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
    
    /**
     * Creates a person (Admin, Employee, or User) based on the input type.
     */
    private Person createPerson(String type, Scanner scanner) {
        switch (type.toLowerCase()) {
            case "admin" -> {
                System.out.print("Enter Admin Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Age: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter Gender: ");
                String gender = scanner.nextLine();
                System.out.print("Enter Address: ");
                String address = scanner.nextLine();
                System.out.print("Enter Phone: ");
                String phone = scanner.nextLine();
                System.out.print("Enter Email: ");
                String email = scanner.nextLine();
                System.out.print("Enter Username: ");
                String username = scanner.nextLine();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();
                System.out.print("Is Super Admin (true/false): ");
                boolean isSuperAdmin = scanner.nextBoolean();
                scanner.nextLine(); // Consume newline
    
                return new AdminPerson(0, name, age, gender, address, phone, email, username, password, isSuperAdmin);
            }
            case "employee" -> {
                System.out.print("Enter Employee Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Age: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter Gender: ");
                String gender = scanner.nextLine();
                System.out.print("Enter Address: ");
                String address = scanner.nextLine();
                System.out.print("Enter Phone: ");
                String phone = scanner.nextLine();
                System.out.print("Enter Email: ");
                String email = scanner.nextLine();
                System.out.print("Enter Role: ");
                String role = scanner.nextLine();
                System.out.print("Enter Shift: ");
                String shift = scanner.nextLine();
                System.out.print("Enter Responsibilities: ");
                String responsibilities = scanner.nextLine();
                System.out.print("Enter Salary: ");
                double salary = scanner.nextDouble();
                System.out.print("Enter Tenure (in months): ");
                int tenure = scanner.nextInt();
                scanner.nextLine(); // Consume newline
    
                return new Employee(1, name, age, gender, address, phone, email, role, shift, responsibilities, salary, tenure);
            }
            case "user" -> {
                System.out.print("Enter User Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Age: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter Gender: ");
                String gender = scanner.nextLine();
                System.out.print("Enter Address: ");
                String address = scanner.nextLine();
                System.out.print("Enter Phone: ");
                String phone = scanner.nextLine();
                System.out.print("Enter Email: ");
                String email = scanner.nextLine();
                System.out.print("Enter Membership Type: ");
                String membershipType = scanner.nextLine();
    
                return new User(2, name, age, gender, address, phone, email, null, null, null, null, null, null, membershipType);
            }
            default -> {
                System.out.println("Invalid type. Please try again.");
                return null;
            }
        }
    }

    // Method to find a Person by their name
private Person findPersonByName(String name) {
    // Access the list of persons from the GenericManager
    for (Person person : personManager.getItems()) {
        // Compare the name (ignoring case)
        if (person.getName().equalsIgnoreCase(name)) {
            return person; // Return the matched person
        }
    }
    return null; // Return null if no match is found
}

    
    /**
     * Finds a person by name (or any identifier) in the personManager.
     
    private Person findPersonByName(String name) {
        for (Person person : personManager.getItems()) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }*/

    // Sub-menu for managing subscriptions
    private void manageSubscriptions() {
        
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Manage Subscriptions ---");
            System.out.println("1. Add Subscription");
            System.out.println("2. Remove Subscription");
            System.out.println("3. Display All Subscriptions");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    if (!authenticateAdmin()) return;
                    System.out.print("Enter subscription ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter subscription name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter subscription duration (months): ");
                    int duration = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter subscription type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter subscription price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter discount percentage: ");
                    double discount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter terms and conditions: ");
                    String termsConditions = scanner.nextLine();

                    Subscription subscription = new Subscription(type, price, discount, description, termsConditions, duration);
                    subscriptionManager.addSubscription(subscription);
                }
                case 2 -> {
                    if (!authenticateAdmin()) return;
                    System.out.print("Enter subscription ID to remove: ");
                    String type = scanner.next();
                    scanner.nextLine();
                    subscriptionManager.removeSubscription(type);
                }
                case 3 -> subscriptionManager.displaySubscriptions();
                case 4 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }


    private void manageEmployees() {
        if (!authenticateAdmin()) return;
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Manage Employees ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Display All Employees");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter shift: ");
                    String shift = scanner.nextLine();
                    System.out.print("Enter job description: ");
                    String jobDescription = scanner.nextLine();
                    System.out.println("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    System.out.println("Enter Duration of employement in months: ");
                    int employementDuration = scanner.nextInt();

                    Employee employee = new Employee(id, name, age, gender, address, phone, email, position, shift, jobDescription,salary,employementDuration);
                    employeeManager.addEmployee(employee);
                }
                case 2 -> {
                    System.out.print("Enter employee ID to remove: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    employeeManager.removeEmployee(id);
                }
                case 3 -> employeeManager.displayEmployees();
                case 4 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void managePackages() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Manage Packages ---");
            System.out.println("1. Add Package");
            System.out.println("2. Remove Package");
            System.out.println("3. Display All Packages");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    if (!authenticateAdmin()) return;
                    System.out.print("Enter package name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter package price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter package discount percentage: ");
                    double discount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter package description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter access level (e.g., Basic, Premium): ");
                    String access = scanner.nextLine();

                    Package pack = new Package(name, price, discount, description, access);
                    packageManager.addPackage(pack);
                }
                case 2 -> {
                    if (!authenticateAdmin()) return;
                    System.out.print("Enter package name to remove: ");
                    String name = scanner.nextLine();
                    packageManager.removePackage(name);
                }
                case 3 -> packageManager.displayPackages();
                case 4 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }


    // Sub-menu for managing users
    
    private void manageUsers() {
    if (!authenticateAdmin()) return;
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
        System.out.println("\n--- Manage Club Members ---");
        System.out.println("1. Add User");
        System.out.println("2. Remove User");
        System.out.println("3. Display All Users");
        System.out.println("4. Search User");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1 -> {
                System.out.print("Enter unique ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter age: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter gender: ");
                String gender = scanner.nextLine();
                System.out.print("Enter address: ");
                String address = scanner.nextLine();
                System.out.print("Enter phone number: ");
                String phone = scanner.nextLine();
                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                
                // Select Package
                System.out.println("Available Packages:");
                packageManager.displayPackages(); // Display available packages
                System.out.print("Select Package Name: ");
                String packageName = scanner.nextLine();
                Package selectedPackage = packageManager.findPackageByName(packageName);
                
                // Select Subscription
                System.out.println("Available Subscriptions:");
                subscriptionManager.displaySubscriptions(); // Display available subscriptions
                System.out.print("Select Subscription Type: ");
                String subscriptionType = scanner.nextLine();
                Subscription selectedSubscription = null;
for (Subscription sub : subscriptionManager.getSubscriptions()) {
    if (sub.getType().equalsIgnoreCase(subscriptionType)) {
        selectedSubscription = sub;
        break;  
    }
}

                // Create User
                User user = new User(id, name, age, gender, address, phone, email, selectedPackage, selectedSubscription, null, null, null, null, null);
                userManager.addUser (user);
            }
            case 2 -> {
                System.out.print("Enter user ID to remove: ");
                int userId = scanner.nextInt();
                scanner.nextLine();
                userManager.removeUser (userId);
            }
            case 3 -> userManager.displayUsers();
            case 4 -> {
                System.out.print("Enter user ID to search: ");
                int userId = scanner.nextInt();
                scanner.nextLine();
                User user = userManager.findUserByID(userId);
                if (user != null) {
                    System.out.println("User  Found: " + user.getDetails());
                } else {
                    System.out.println("User  not found.");
                }
            }
            case 5 -> System.out.println("Returning to Main Menu...");
            default -> System.out.println("Invalid choice. Please try again.");
        }
    } while (choice != 5);
}

    private boolean authenticateAdmin() {
        if (admin.isAuthenticated() || khizer.isAuthenticated()) {
            return true;
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter admin username: ");
            String username = scanner.nextLine();
            System.out.print("Enter admin password: ");
            String password = scanner.nextLine();

            if (admin.login(username, password)||khizer.login(username, password)) {
                System.out.println("Authentication successful.");
                return true;
            } else {
                System.out.println("Authentication failed.");
                return false;
            }
        }
    }

    // Sub-menu for managing facilities
    private void manageFacilities() {
        if (!authenticateAdmin()) return;
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Manage Facilities ---");
            System.out.println("1. Add Facility");
            System.out.println("2. Remove Facility");
            System.out.println("3. Display All Facilities");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter facility name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter facility description: ");
                    String description = scanner.nextLine();
                    String managercontact = scanner.nextLine();
                    Facility facility = new Facility(name, description,managercontact);
                    facilityManager.addFacility(facility);
                }
                case 2 -> {
                    System.out.print("Enter facility name to remove: ");
                    String name = scanner.nextLine();
                    facilityManager.removeFacility(name);
                }
                case 3 -> facilityManager.displayFacilities();
                case 4 -> System.out.println("Returning to Main Menu...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    


    // Main method to run the system
    public static void main(String[] args) {
        ClubManagementSystem cms = new ClubManagementSystem();


        cms.mainMenu();
    }
}
