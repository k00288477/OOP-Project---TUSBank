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
        ArrayList<Account> TUSaccounts = new ArrayList<>();

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


        TUSaccounts.addAll(currentAccounts);
        TUSaccounts.addAll(depositAccounts);

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
        //ask user if staff or customer
        System.out.println("1. Customer Menu\n2. Staff Menu");
        int choice = sc.nextInt();
        if (choice == 1) {
            //ask user for customer number
            System.out.println("Please enter your customer number");
            int customerNumber = sc.nextInt();//pass to all customer methods
            //display menu options
            String input = "";
            while (!input.equalsIgnoreCase("5")) {
                System.out.println(
                        "\nMain Menu\n1. Make a Deposit\n2. Make a Withdrawal\n3. Check Account Balance\n4. Exit"
                );
                //user selects menu item
                input = sc.next();
                switch (input) {
                    case "1" -> depositFunds(TUSaccounts, customerNumber);
                    case "2" -> withdrawFunds(TUSaccounts, customerNumber, customers);
                    case "3" -> checkBalance(TUSaccounts, customerNumber, customers);
                    case "4" -> System.exit(0);
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
        } else if (choice == 2) {
            staffMenu(TUSaccounts, customers, bankManagers, bankOfficers);
        }
    }

    private static void staffMenu(ArrayList<Account> TUSaccounts, ArrayList<Customer> customers, ArrayList<BankManager> bankManagers, ArrayList<BankOfficer> bankOfficers) {
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
                        case "2" -> staff.createNewCurrentAccount(TUSaccounts);
                        case "3" -> staff.createNewDepositAccount(TUSaccounts);
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


    private static void checkBalance(ArrayList<Account> TUSaccounts, int customerNumber, ArrayList<Customer> customers) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Check Balance");

        //get customer
        Customer cust = CustomerIO.getCustomer(customerNumber);
        customers.add(cust);
        cust.checkBalance(customerNumber, TUSaccounts);
    }


    private static void depositFunds(ArrayList<Account> TUSaccounts, int customerNumber) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Deposit Funds");
        int ans;

        //ask the user which account to deposit into
        System.out.println("\nWhich Account do you wish to deposit into?\n1. Current Account\n2. Deposit Account");
        ans = sc.nextInt();

        //check the array list for accounts with the corresponding customer number
        for (Account account : TUSaccounts) {
            if (account.getCustId() == customerNumber) { //finds the customers accounts
                //check the type of account using instanceof operator
                if (account instanceof CurrentAccount && ans == 1) {
                    //Call the method to deposit money
                    ((CurrentAccount) account).depositMoney(account);
                } else if (account instanceof DepositAccount && ans == 2) {
                    //Call the method to deposit money
                    ((DepositAccount) account).depositMoney(account);
                }
            }
        }

    }

    private static void withdrawFunds(ArrayList<Account> TUSaccounts, int customerNumber, ArrayList<Customer> customers) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Withdraw Funds");
        int ans;

        //ask the user which account to withdraw from
        System.out.println("\nWhich Account do you wish to withdraw from?\n1. Current Account\n2. Deposit Account");
        ans = sc.nextInt();

        //check the array list for accounts with the corresponding customer number
        for (Account account : TUSaccounts) {
            if (account.getCustId() == customerNumber) { //finds the customers accounts
                //check the type of account using instanceof operator & if the user chose this account
                if (account instanceof CurrentAccount && ans == 1) {
                    //Call the method to withdraw money
                    ((CurrentAccount) account).withdrawMoney(account);
                } else if (account instanceof DepositAccount && ans == 2) {
                    //Call the method to withdraw money
                    ((DepositAccount) account).withdrawMoney(account);
                }
            }
        }

    }
}