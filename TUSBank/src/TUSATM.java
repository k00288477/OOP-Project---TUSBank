//OOP Project
//TUS Bank Application
//Author: K00288477 Gary O'Connor
//Date Created: 2023-11-08

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TUSATM {
    public static void main(String[] args) {
        ArrayList<Account> tusAccounts = new ArrayList<>();
        ArrayList<CurrentAccount> currentAccounts = new ArrayList<>();
        ArrayList<DepositAccount> depositAccounts = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Staff> staffMembers = new ArrayList<>();
        ArrayList<BankOfficer> bankOfficers = new ArrayList<>();
        ArrayList<BankManager> bankManagers = new ArrayList<>();
        //initialize array lists
        initializeTestData(tusAccounts, currentAccounts, depositAccounts, customers, bankOfficers, bankManagers, staffMembers);


        //Welcome Message
        System.out.println("Welcome to the TUS Bank App");
        //new scanner
        Scanner sc = new Scanner(System.in);
        //Main menu
        //ask user if staff or customer
        System.out.println("1. Customer Menu\n2. Staff Menu");
        int choice = sc.nextInt();
        //Customer Menu
        if (choice == 1) {
            //ask user for customer number
            System.out.println("Please enter your customer number");
            int customerNumber = sc.nextInt();//pass to all customer methods
            //Check customer object exists
            Customer cust = CustomerIO.getCustomer(customerNumber);
            customers.add(cust);

            //sentinel loop for menu, menu will not close until user specifies
            //will be able to call multiple methods in single session
            String input = "";
            while (!input.equalsIgnoreCase("4")) {
                System.out.println(
                        "\nMain Menu\n1. Make a Deposit\n2. Make a Withdrawal\n3. Check Account Balance\n4. Exit"
                );
                //user selects menu item
                input = sc.next();
                switch (input) {
                    case "1" -> cust.depositFunds(tusAccounts, customerNumber);
                    case "2" -> cust.withdrawFunds(tusAccounts, customerNumber, customers);
                    case "3" -> cust.checkBalance(tusAccounts, customerNumber, customers);
                    case "4" -> {
                        System.out.println("\nGoodbye.");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
            //Staff Menu
        } else if (choice == 2) {
            System.out.println("Please enter your staff number");
            int input = sc.nextInt();

            //Check staff object exists
            for (Staff staff : staffMembers) {
                if (input == staff.getStaffId()) {

                    //sentinel loop for menu, menu will not close until user specifies
                    //will be able to call multiple methods in single session
                    String userInput = "";
                    while (!userInput.equalsIgnoreCase("9")) {
                        //display menu
                        System.out.println(
                                "\nStaff Menu\n1. Create new Customer\n2. Create New Current Account\n3. Create New Deposit Account\n4. Change Current Account AIR\n5. Change deposit Account AIR\n6. Change Overdraft\n7. Print All Accounts\n8. Create new Bank Officer\n9. Cancel"
                        );
                        //user selects menu item
                        userInput = sc.next();
                        switch (userInput) {
                            case "1" -> staff.createNewCustomer(customers);
                            case "2" -> staff.createNewCurrentAccount(tusAccounts);
                            case "3" -> staff.createNewDepositAccount(tusAccounts);
                            case "4" -> staff.changeCurrentAccAIR(tusAccounts);
                            case "5" -> staff.changeDepositAccAIR(tusAccounts);
                            case "6" -> staff.changeOverdraft(tusAccounts);
                            case "7" -> staff.printAllAccounts(tusAccounts);
                            case "8" -> createNewBankOfficer(bankManagers, bankOfficers, staffMembers);
                            case "9" -> {
                                System.out.println("\nGoodbye.");
                                System.exit(0);
                            } //user exits app
                            default -> System.out.println("Invalid option. Please try again.");
                        }

                    }//end of while loop
                }//end of if statement
            }
        }
    }

    private static void createNewBankOfficer(ArrayList<BankManager> bankManagers, ArrayList<BankOfficer> bankOfficers, ArrayList<Staff> staffMembers) {
        Scanner sc = new Scanner(System.in);
        int staffId;

        //ask for bank manager ID
        System.out.println("Enter Staff ID (Note: Only managers may create a New Bank Officer Account)");
        staffId = sc.nextInt();

        //check that staffID is in bank manager list
        //for each loop
        for (BankManager bankManager : bankManagers) {
            //compare staff id
            if (staffId == bankManager.getStaffId()) {
                // call method in bank manager class
                bankManager.createBankOfficer(bankOfficers, staffMembers);
            } else System.out.println("Staff ID invalid");
        }

    }

    private static void initializeTestData(ArrayList<Account> tusAccounts, ArrayList<CurrentAccount> currentAccounts,
                                           ArrayList<DepositAccount> depositAccounts, ArrayList<Customer> customers,
                                           ArrayList<BankOfficer> bankOfficers, ArrayList<BankManager> bankManagers, ArrayList<Staff> staffMembers) {
        LocalDate x = LocalDate.of(2023, 11, 22);
        CurrentAccount c1 = new CurrentAccount(1, 1000, 200.20, x, 0.5);
        currentAccounts.add(c1);

        LocalDate y = LocalDate.of(2023, 11, 22);
        DepositAccount d1 = new DepositAccount(6, 1000, 200000.00, y);
        depositAccounts.add(d1);

        Address a1 = new Address("789", "Pine Lane", "Greenfield", "DEF789");
        BankOfficer b1 = new BankOfficer("Anna", "Pearse", a1, 123, Position.BANKOFFICER, 40000.00);
        bankOfficers.add(b1);

        BankManager bm1 = new BankManager("John", "Boyega", a1, 1234, Position.BANKMANAGER, 50000.00);
        bankManagers.add(bm1);

        tusAccounts.addAll(currentAccounts);
        tusAccounts.addAll(depositAccounts);
        staffMembers.addAll(bankManagers);
        staffMembers.addAll(bankOfficers);

    }
}//end of main

