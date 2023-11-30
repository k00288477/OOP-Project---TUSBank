import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Person {
    //attributes
    private int custId;

    //constructors
    public Customer() {
    }

    public Customer(
            int custId,
            String firstName,
            String lastName,
            Address address
    ) {
        super(firstName, lastName, address);
        this.custId = custId;
    }

    //getters & setters


    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    //methods


    public void checkBalance(ArrayList<Account> tusAccounts, int customerNumber,  ArrayList<Customer> customers) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Check Balance");

        //check the array list for accounts with the corresponding customer number
        for (Account account : tusAccounts) {
            if (account.getCustId() == customerNumber) {
                //check the type of account using instanceof operator
                if (account instanceof CurrentAccount) {
                    //Call the method to check balance
                    System.out.println("Your Current account balance is: €" + account.getBalance());
                } else if (account instanceof DepositAccount) {
                    //Call the method to withdraw money
                    System.out.println("Your Deposit account balance is: €" + account.getBalance());
                }
            }
        }
    }

    public void withdrawFunds(ArrayList<Account> tusAccounts, int customerNumber, ArrayList<Customer> customers){
        Scanner sc = new Scanner(System.in);
        System.out.println("Withdraw Funds");
        int ans;

        //ask the user which account to withdraw from
        System.out.println("\nWhich Account do you wish to withdraw from?\n1. Current Account\n2. Deposit Account");
        ans = sc.nextInt();

        //check the array list for accounts with the corresponding customer number
        for (Account account : tusAccounts) {
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



    public void depositFunds(ArrayList<Account> tusAccounts, int customerNumber){
        Scanner sc = new Scanner(System.in);
        System.out.println("Deposit Funds");
        int ans;

        //ask the user which account to deposit into
        System.out.println("\nWhich Account do you wish to deposit into?\n1. Current Account\n2. Deposit Account");
        ans = sc.nextInt();

        //check the array list for accounts with the corresponding customer number
        for (Account account : tusAccounts) {
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

    //String Format
    @Override
    public String toString() {
        return super.toString();
    }
}

