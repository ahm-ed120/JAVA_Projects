public class Employee extends Person {
    private String position;
    private String shift;
    private String jobDescription;
    private double salary; 
    private int employementDuration;

    // Constructor
    public Employee(int uniqueID, String name, int age, String gender, String address, String phoneNumber, String email,
                    String position, String shift, String jobDescription,double salary,int employementDuration) {
        super(uniqueID, name, age, gender, address, phoneNumber, email);
        this.position = position;
        this.shift = shift;
        this.jobDescription = jobDescription;
        this.salary=salary;
        this.employementDuration=employementDuration;
    }

    // Getters and Setters
    public String getPosition() {
        return position;
    }

    public int getEmploymentDuration(){
        return employementDuration;
    }
    public double getSalary(){
        return salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    // Overridden getDetails method
    @Override
    public String getDetails() {
        return super.getDetails() +
                ", Position: " + position +
                ", Shift: " + shift +
                ", Job Description: " + jobDescription;
    }

    // Overridden displayInfo method
    @Override
    public void displayInfo() {
        System.out.println("Employee Details:");
        System.out.println(getDetails());
    }

    public String toString() {
        return super.toString() + ", Role: " + position + ", Shift: " + shift + ", Responsibilities: " + jobDescription + ", Salary: " + salary + ", Tenure: " + employementDuration;
    }

    // Overridden performRoleSpecificTask for employee-specific tasks
    @Override
    public void performRoleSpecificTask() {
        System.out.println("Performing tasks related to the employee's job...");
    }
}
