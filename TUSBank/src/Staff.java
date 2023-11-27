import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Staff extends Person {
    //attributes
    private int staffId;
    private Position position;
    private double salary;

    //constructors
    protected Staff(
            String firstName,
            String lastName,
            Address address,
            int staffId,
            Position position,
            double salary
    ) {
        super(firstName, lastName, address);
        this.staffId = staffId;
        this.position = position;
        this.salary = salary;
    }

    //getters & setters
    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //methods
    //Note: methods set to protected as they will only be accessed by sub classes
    protected void createNewCustomer(ArrayList<Customer> customers){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the account details");
        // Define the attributes in an array
        String[] attributeNames = {"Customer id", "First Name", "Last Name", "House Number", "Street", "City", "Eircode"};
        String[] attributeValues = new String[attributeNames.length];

        // Use a for loop to ask the user to input values for each attribute
        for (int i = 0; i < attributeNames.length; i++) {
            System.out.println(attributeNames[i] + ":");
            attributeValues[i] = sc.next();
        }

        // Build the objects
        Address a = new Address(attributeValues[3], attributeValues[4], attributeValues[5], attributeValues[6]);
        Customer c = new Customer(Integer.parseInt(attributeValues[0]), attributeValues[1], attributeValues[2], a);

        // Add the created customer to the ArrayList
        customers.add(c);
    }


    protected void createNewCurrentAccount(ArrayList<CurrentAccount> currentAccounts){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the current account details");
        // Define the attributes in an array
        String[] attributeNames = {"Account id", "Customer Id", "Balance", "Year", "Month", "Day", "Overdraft"};
        String[] attributeValues = new String[attributeNames.length];

        // Use a for loop to ask the user to input values for each attribute
        for (int i = 0; i < attributeNames.length; i++) {
            System.out.println(attributeNames[i] + ":");
            attributeValues[i] = sc.next();
        }

        // Build the objects
        LocalDate a = LocalDate.of(Integer.parseInt(attributeValues[3]), Integer.parseInt(attributeValues[4]), Integer.parseInt(attributeValues[5]));
        CurrentAccount c = new CurrentAccount(Integer.parseInt(attributeValues[0]), Integer.parseInt(attributeValues[1]), Double.parseDouble(attributeValues[2]), a, Double.parseDouble(attributeValues[6]));

        // Add the created customer to the ArrayList
        currentAccounts.add(c);

    }

    protected void createNewDepositAccount(ArrayList<DepositAccount> depositAccounts){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the deposit account details");
        // Define the attributes in an array
        String[] attributeNames = {"Account id", "Customer Id", "Balance", "Year", "Month", "Day", "Overdraft"};
        String[] attributeValues = new String[attributeNames.length];

        // Use a for loop to ask the user to input values for each attribute
        for (int i = 0; i < attributeNames.length; i++) {
            System.out.println(attributeNames[i] + ":");
            attributeValues[i] = sc.next();
        }

        // Build the objects
        LocalDate a = LocalDate.of(Integer.parseInt(attributeValues[3]), Integer.parseInt(attributeValues[4]), Integer.parseInt(attributeValues[5]));
        DepositAccount d = new DepositAccount(Integer.parseInt(attributeValues[0]), Integer.parseInt(attributeValues[1]), Double.parseDouble(attributeValues[2]), a);

        // Add the created customer to the ArrayList
        depositAccounts.add(d);
    }

    protected void changeDepositAccAIR(){}

    protected void changeCurrentAccAIR(){}

    protected void changeOverdraft(){}

    //TODO change method to return the Array List of accounts
    protected void printAllAccounts(){}


    //String Format
    @Override
    public String toString() {
        return String.format(
                super.toString() +
                        "\nStaff ID: %d," +
                        "\nPosition: %s," +
                        "\nSalary: %.2f", getStaffId(), getPosition(), getSalary()
        );
    }
}
