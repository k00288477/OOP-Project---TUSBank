import java.util.ArrayList;
import java.util.Scanner;

public class BankManager extends Staff{
    //no unique attributes

    //constructor
    protected BankManager(
            String firstName,
            String lastName,
            Address address,
            int staffId,
            Position position,
            double salary
    ) {
        super(firstName, lastName, address, staffId, position, salary);
    }

    //methods
    public void createBankOfficer(ArrayList<BankOfficer> bankOfficers, ArrayList<Staff> staffMembers){
        //Create a new Bank Officer Object
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the Bank Officer's details");
        // Define the attributes in an array
        String[] attributeNames = {"First Name", "Last Name", "House Number", "Street", "City", "Eircode", "Staff ID", "Salary"};
        String[] attributeValues = new String[attributeNames.length];

        // Use a for loop to ask the user to input values for each attribute
        for (int i = 0; i < attributeNames.length; i++) {
            System.out.println(attributeNames[i] + ":");
            attributeValues[i] = sc.next();
        }
        //assign position
        System.out.println("Position (BANKOFFICER, BANKMANAGER):");
        String positionInput = sc.next();
        Position position = Position.valueOf(positionInput.toUpperCase());

        // Build the objects
        Address a = new Address(attributeValues[2], attributeValues[3], attributeValues[4], attributeValues[5]);
        BankOfficer b = new BankOfficer(attributeValues[0], attributeValues[1], a, Integer.parseInt(attributeValues[6]), position, Double.parseDouble(attributeValues[7]));

        // Add to the bankOfficers list
        staffMembers.add(b);
    }

    //string Format
    @Override
    public String toString() {
        return super.toString();
    }
}
