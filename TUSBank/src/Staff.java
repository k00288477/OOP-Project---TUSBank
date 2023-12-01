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


    protected void createNewCurrentAccount(ArrayList<Account> accounts){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the current account details");
        // Define the attributes in an array
        String[] attributeNames = {"Account id", "Customer Id", "Balance", "Overdraft"};
        String[] attributeValues = new String[attributeNames.length];

        // Use a for loop to ask the user to input values for each attribute
        for (int i = 0; i < attributeNames.length; i++) {
            System.out.println(attributeNames[i] + ":");
            attributeValues[i] = sc.next();
        }

        // Build the objects
        CurrentAccount c = new CurrentAccount(Integer.parseInt(attributeValues[0]), Integer.parseInt(attributeValues[1]), Double.parseDouble(attributeValues[2]), Double.parseDouble(attributeValues[3]));

        // Add the created customer to the ArrayList
        accounts.add(c);

    }

    protected void createNewDepositAccount(ArrayList<Account> accounts){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the deposit account details");
        // Define the attributes in an array
        String[] attributeNames = {"Account id", "Customer Id", "Balance"};
        String[] attributeValues = new String[attributeNames.length];

        // Use a for loop to ask the user to input values for each attribute
        for (int i = 0; i < attributeNames.length; i++) {
            System.out.println(attributeNames[i] + ":");
            attributeValues[i] = sc.next();
        }

        // Build the objects
        DepositAccount d = new DepositAccount(Integer.parseInt(attributeValues[0]), Integer.parseInt(attributeValues[1]), Double.parseDouble(attributeValues[2]));

        // Add the created customer to the ArrayList
        accounts.add(d);
    }

    protected void changeDepositAccAIR(ArrayList<Account> tusAccounts){
        Scanner sc = new Scanner(System.in);
        double newAIR;

                    //display current AIR
                    System.out.printf("The current Annual Interest Rate (AIR) on Deposit Accounts is: %.3f%%\n", DepositAccount.getDepositAccAIR());
                    //ask for new AIR
                    System.out.println("Please enter the new AIR:");
                    newAIR = sc.nextDouble();
                    //set the new AIR
                    DepositAccount.setDepositAccAIR(newAIR);
                    //display new AIR
                    System.out.printf("The new Annual Interest Rate for Deposit Accounts is: %.3f%%.\n", DepositAccount.getDepositAccAIR());
                }






    protected void changeCurrentAccAIR(ArrayList<Account> tusAccounts){
        Scanner sc = new Scanner(System.in);
        double newAIR;

                    //display current AIR
                    System.out.printf("The current Annual Interest Rate (AIR) on the Current Account is: %.3f%%\n", CurrentAccount.getCurrentAccAir());
                    //ask for new AIR
                    System.out.println("Please enter the new AIR:");
                    newAIR = sc.nextDouble();
                    //set the new AIR
                    CurrentAccount.setCurrentAccAir(newAIR);
                    //display new AIR
                    System.out.printf("The new Annual Interest Rate for Current Accounts is: %.3f%%.\n", CurrentAccount.getCurrentAccAir());
                }

    protected void changeOverdraft(ArrayList<Account> tusAccounts){
        Scanner sc = new Scanner(System.in);
        int customerNumber;
        double overdraft;

        //user enters customer number
        System.out.println("Please enter the customer number:");
        customerNumber = sc.nextInt();
        //find customer Current Account
        for(Account account : tusAccounts){
            if(customerNumber == account.getCustId() && account instanceof CurrentAccount){
                //display overdraft
                System.out.printf("The accounts current overdraft is: %.2f%%\n", ((CurrentAccount) account).getOverdraft());
                //ask for new overdraft value
                System.out.println("Please enter the new Overdraft:");
                overdraft = sc.nextDouble();
                //set new overdraft value
                ((CurrentAccount) account).setOverdraft(overdraft);
                //display the new overdraft
                System.out.printf("The new Overdraft for Customer Number: %d, is %.2f%%\n", customerNumber, ((CurrentAccount) account).getOverdraft());
            }
        }
    }

    protected void printAllAccounts(ArrayList<Account> tusAccounts){
        System.out.println("List of all Accounts");

        //for each loop to iterate through the array
        for(Account account : tusAccounts){
            //sort between current account and deposit
            if (account instanceof CurrentAccount){
                System.out.println("\nAccount type: Current Account\n" + account.toString());
            } else if (account instanceof DepositAccount) {
                System.out.println("\nAccount type: Deposit Account\n" + account.toString());
            }
        }
    }


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
