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
        LocalDate x = LocalDate.of(2023, 11, 22);
        CurrentAccount c = new CurrentAccount(1, 1, 20.00, x, 0.5);
        LocalDate y = LocalDate.of(2023, 11, 22);
        DepositAccount d = new DepositAccount(2, 1, 20.00, y);


        //Welcome Message
        System.out.println("Welcome to the TUS Bank App");
        //initialise accounts array
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(c);
        accounts.add(d);

        //call the main menu
        mainMenu(accounts);
    }

    private static void mainMenu(ArrayList<Account> accounts){

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
                checkBalance(accounts);
            } else if (userInput == 4) {
                staffMenu(accounts);
            } else System.exit(0);

    }

    //Customer checks balance
    private static void checkBalance(ArrayList<Account> accounts) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Check Balance");
        //ask the user for their account number
        System.out.println("Please Enter your customer number");
        int accNo = Integer.parseInt(sc.next());
        //search the array list for the account
        for(int i = 0; i < accounts.size(); i++){
            Account current = accounts.get(i);
            //compare input to the accounts customer number
            if (accNo == current.getAcountId()){
                System.out.println(
                        "\nYour Balance: " + current.getBalance());
            }
        }
        //return to main menu
        mainMenu(accounts);
    }

    //Access the staff menu
    private static void staffMenu(ArrayList<Account> accounts) {
        System.out.println("Staff Menu");
        Scanner sc = new Scanner(System.in);

        //Staff Menu


    }

    private static void withdrawFunds() {
        System.out.println("Withdraw");
    }

    private static void depositFunds() {
        System.out.println("Deposit");

    }
}