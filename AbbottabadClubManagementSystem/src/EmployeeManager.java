import java.util.ArrayList;

public class EmployeeManager extends AdminPerson {
    private ArrayList<Employee> employees;

    // Constructor
    public EmployeeManager(int uniqueID, String name, int age, String gender, String address,
                           String phoneNumber, String email, String username, String password, boolean authenticated) {
        super(uniqueID, name, age, gender, address, phoneNumber, email, username, password, authenticated);
        this.employees = new ArrayList<>();
    }

    // Method to add an employee
    public void addEmployee(Employee employee) {
        if (!isAuthenticated()) {
            System.out.println("Access denied. User is not authenticated.");
            return;
        }
        employees.add(employee);
        System.out.println("Employee added: " + employee.getName());
    }

    // Method to remove an employee by uniqueID
    public boolean removeEmployee(int employeeID) {
        if (!isAuthenticated()) {
            System.out.println("Access denied. User is not authenticated.");
            return false;
        }
        for (Employee employee : employees) {
            if (employee.getUniqueID() == employeeID) {
                employees.remove(employee);
                System.out.println("Employee removed: " + employee.getName());
                return true;
            }
        }
        System.out.println("Employee not found with ID: " + employeeID);
        return false;
    }

    public ArrayList<Employee> getEmployees() {
        return this.employees;
    }

    // Method to display all employees
    public void displayEmployees() {
        if (!isAuthenticated()) {
            System.out.println("Access denied. User is not authenticated.");
            return;
        }
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("List of Employees:");
            for (Employee employee : employees) {
                employee.displayInfo();
                System.out.println("----------------------");
            }
        }
    }

    // Method to search for an employee by uniqueID
    public Employee findEmployeeByID(int employeeID) {
        for (Employee employee : employees) {
            if (employee.getUniqueID() == employeeID) {
                return employee;
            }
        }
        return null;
    }

    // Overriding AdminPerson's displayInfo() to include employee management details
    @Override
    public void displayInfo() {
        super.displayInfo(); // Display AdminPerson details
        System.out.println("Managing Employees:");
        displayEmployees();
    }
}
