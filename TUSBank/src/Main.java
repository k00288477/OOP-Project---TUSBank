//OOP Project
//TUS Bank Application
//Author: K00288477 Gary O'Connor
//Date Created: 2023-11-08

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //test
        //current acc
        LocalDate x = LocalDate.of(2023, 11, 22);
        CurrentAccount c = new CurrentAccount(1, 1, 20.00, x, 0.5);
        //deposit acc
        LocalDate y = LocalDate.of(2023, 11, 22);
        DepositAccount d = new DepositAccount(2, 1, 20.00, y);
        //cust
        Address a1 = new Address("01", "Avenue Rd", "Galway", "V941234");
        Customer c1 = new Customer(1, "Joe", "Bloggs", a1);
        //bank officer
        BankOfficer b1 = new BankOfficer("Anna" , "Pearse", a1, 123, Position.BANKOFFICER, 400000.00);


        //Welcome Message
        System.out.println("Welcome to the TUS Bank App");
        //initialise accounts array
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(c);
        accounts.add(d);
        ArrayList<Staff> staffMembers = new ArrayList<>();
        staffMembers.add(b1);
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(c1);

        //call the main menu
        mainMenu(accounts, staffMembers, customers);
    }

    private static void mainMenu(ArrayList<Account> accounts, ArrayList<Staff> staffMembers, ArrayList<Customer> customers){

        //new scanner
        Scanner sc = new Scanner(System.in);
            //Main menu
            //display menu options
            System.out.println(
                    "\nMain Menu\n1. Make a Deposit\n2. Make a Withdrawal\n3. Check Account Balance\n4. Staff Menu\n5. Exit"
            );
            //user selects menu item
            int userInput = sc.nextInt();
            if (userInput == 1) {
                depositFunds();
            } else if (userInput == 2) {
                withdrawFunds();
            } else if (userInput == 3) {
                checkBalance(accounts, customers);
            } else if (userInput == 4) {
                staffMenu(accounts, staffMembers, customers);
            } else System.exit(0);

    }

    //Customer checks balance
    private static void checkBalance(ArrayList<Account> accounts, ArrayList<Customer> customers) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Check Balance");
        //ask the user for their account number
        System.out.println("Please Enter your Customer number");
        int custNo = Integer.parseInt(sc.next());
        //search the array list for the account with th corresponding customer number
        for(int i = 0; i < accounts.size(); i++){
            Account acc = accounts.get(i);
            //compare input to the accounts customer number
            if (custNo == acc.getCustId()){
                System.out.println(
                        "\nYour Balance: " + acc.getBalance());
            }
        }

    }

    //Access the staff menu
    private static void staffMenu(ArrayList<Account> accounts, ArrayList<Staff> staffMembers, ArrayList<Customer> customers) {
        System.out.println("Please enter your staff number");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        Staff staff = null;
        //Check staff object exists
        for(int i =0; i < staffMembers.size(); i++){
            if(input == staffMembers.get(i).getStaffId()){
                //display the menu
                staff = staffMembers.get(i);
                System.out.println(
                        "\nStaff Menu\n1. Create new Customer\n2. Create New Current Account\n3. Create New Deposit Account\n4. Change Current Account AIR\n5. Change deposit Account AIR\n6. Change Overdraft\n7. Cancel"
                );
            } else {
                //do not display the menu
            }
        }
        //create the menu
        int staffInput = sc.nextInt();
        if(staffInput == 1){
            staff.createNewCustomer(customers);
        } else if (staffInput == 2) {
            staff.createNewCurrentAccount(accounts);
        } else if (staffInput == 3) {
            staff.createNewDepositAccount(accounts);
        } else if (staffInput == 4) {
            staff.changeCurrentAccAIR();
        } else if (staffInput == 5) {
            staff.changeDepositAccAIR();
        } else if (staffInput == 6) {
            staff.changeOverdraft();
        } else System.exit(0);
    }

    private static void withdrawFunds() {
        System.out.println("Withdraw");
    }

    private static void depositFunds() {
        System.out.println("Deposit");

    }
}