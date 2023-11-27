//OOP Project
//TUS Bank Application
//Author: K00288477 Gary O'Connor
//Date Created: 2023-11-08

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //current accs
        LocalDate x = LocalDate.of(2023, 11, 22);
        CurrentAccount c1 = new CurrentAccount(1, 1000, 200.20, x, 0.5);
        CurrentAccount c2 = new CurrentAccount(2, 1001, 2348.99, x, 0.5);
        CurrentAccount c3 = new CurrentAccount(3, 1002, 3542.70, x, 0.5);
        CurrentAccount c4 = new CurrentAccount(4, 1003, 1234.55, x, 0.5);
        CurrentAccount c5 = new CurrentAccount(5, 1004, 12987.99, x, 0.5);

        //deposit accs
        LocalDate y = LocalDate.of(2023, 11, 22);
        DepositAccount d1 = new DepositAccount(6, 1000, 200000.00, y);
        DepositAccount d2 = new DepositAccount(7, 1001, 20000.00, y);
        DepositAccount d3 = new DepositAccount(8, 1002, 123560.00, y);
        DepositAccount d4 = new DepositAccount(9, 1003, 23020.00, y);
        DepositAccount d5 = new DepositAccount(10, 1004, 450000.00, y);

        Address a1 = new Address("789", "Pine Lane", "Greenfield", "DEF789");
        //bank officer
        BankOfficer b1 = new BankOfficer("Anna", "Pearse", a1, 123, Position.BANKOFFICER, 40000.00);
        //bank manager
        BankManager bm1 = new BankManager("John", "Boyega", a1, 1234, Position.BANKMANAGER, 50000.00);

        //initialise array lists
        ArrayList<CurrentAccount> currentAccounts = new ArrayList<>();
        currentAccounts.add(c1);
        currentAccounts.add(c2);
        currentAccounts.add(c3);
        currentAccounts.add(c4);
        currentAccounts.add(c5);
        ArrayList<DepositAccount> depositAccounts = new ArrayList<>();
        depositAccounts.add(d1);
        depositAccounts.add(d2);
        depositAccounts.add(d3);
        depositAccounts.add(d4);
        depositAccounts.add(d5);

        ArrayList<BankOfficer> bankOfficers = new ArrayList<>();
        bankOfficers.add(b1);

        ArrayList<Customer> customers = new ArrayList<>();

        ArrayList<BankManager> bankManagers = new ArrayList<>();
        bankManagers.add(bm1);


        //Welcome Message
        System.out.println("Welcome to the TUS Bank App");
        //new scanner
        Scanner sc = new Scanner(System.in);
        //Main menu
        //display menu options
        String input = "";
        while (!input.equalsIgnoreCase("5")) {
            System.out.println(
                    "\nMain Menu\n1. Make a Deposit\n2. Make a Withdrawal\n3. Check Account Balance\n4. Staff Menu\n5. Exit"
            );
            //user selects menu item
            input = sc.next();
            switch (input) {
                case "1" -> depositFunds();
                case "2" -> withdrawFunds();
                case "3" -> checkBalance(currentAccounts, depositAccounts, customers);
                case "4" -> staffMenu(currentAccounts, depositAccounts, customers, bankManagers, bankOfficers);
                case "5" -> System.exit(0);
                default -> System.out.println("Invalid option. Please try again.");
            }

        }

    }

    private static void withdrawFunds() {
    }

    private static void depositFunds() {

    }

    //Customer checks balance
    private static void checkBalance(ArrayList<CurrentAccount> currentAccounts, ArrayList<DepositAccount> depositAccounts, ArrayList<Customer> customers) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Check Balance");

        //ask the user for their account number
        System.out.println("Please Enter your Customer number");
        int custNo = Integer.parseInt(sc.next());
        //get customer
        Customer cust = CustomerIO.getCustomer(custNo);
        customers.add(cust);
        cust.checkBalance(custNo, currentAccounts, depositAccounts);

    }

    // Access the staff menu
    private static void staffMenu(ArrayList<CurrentAccount> currentAccounts, ArrayList<DepositAccount> depositAccounts, ArrayList<Customer> customers, ArrayList<BankManager> bankManagers, ArrayList<BankOfficer> bankOfficers) {
        System.out.println("Please enter your staff number");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        Staff staff = null;
        //Check staff object exists
        for (int i = 0; i < bankOfficers.size(); i++) {
            if (input == bankOfficers.get(i).getStaffId()) {
                //display the menu
                staff = bankOfficers.get(i);

                String userInput = "";
                while (!userInput.equalsIgnoreCase("7")) {
                    System.out.println(
                            "\nStaff Menu\n1. Create new Customer\n2. Create New Current Account\n3. Create New Deposit Account\n4. Change Current Account AIR\n5. Change deposit Account AIR\n6. Change Overdraft\n7. Cancel"
                    );
                    //user selects menu item
                    userInput = sc.next();
                    switch (userInput) {
                        case "1" -> staff.createNewCustomer(customers);
                        case "2" -> staff.createNewCurrentAccount(currentAccounts);
                        case "3" -> staff.createNewDepositAccount(depositAccounts);
                        case "4" -> staff.changeCurrentAccAIR();
                        case "5" -> staff.changeDepositAccAIR();
                        case "6" -> staff.changeOverdraft();
                        case "7" -> System.exit(0);
                        default -> System.out.println("Invalid option. Please try again.");
                    }

                }//end of while loop
            }//end of if statement
        }//end of for loop

    }//end of method
}