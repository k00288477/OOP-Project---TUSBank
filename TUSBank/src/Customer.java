import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Person{
    //attributes
    private int custId;

    //constructors
    public Customer(){}

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
    private void depositMoney(){}

    private void withdrawMoney(ArrayList<Account> accounts){
        Scanner sc = new Scanner(System.in);
        System.out.println("Withdraw Funds");
        //ask the user for their account number
        System.out.println("Please Enter your account number");
        int accNo = Integer.parseInt(sc.next());
        double amount = 0.00;

        //find the account
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            if (accNo == acc.getAccountId()) {
                //ask the user how much to withdraw
                System.out.println("Your balance is " + acc.getBalance() + ".\nHow much would you like to withdraw?");
                amount = sc.nextDouble();

                //validate that the account balance is greater than the amount requested
                //and the amount requested will not leave the account overdrawn
                //TODO - implement overdraft
                if (amount > 0 && amount <= acc.getBalance()) {
                    acc.setBalance(acc.getBalance() - amount);
                    System.out.println("Withdrawal successful. Updated balance: " + acc.getBalance());
                } else {
                    System.out.println("Invalid withdrawal amount or insufficient funds.");
                }

            }
        }
        System.out.println("Account not found.");
    }


    public void checkBalance(int custNo, ArrayList<CurrentAccount> currentAccounts, ArrayList<DepositAccount> depositAccounts) {
        //search the account arraylists for the account with the corresponding customer number
        double currentAccBal = 0;
        for(int i = 0; i < currentAccounts.size(); i++){
            CurrentAccount currentAccount = currentAccounts.get(i);
            //compare input to the accounts customer number
            if (custNo == currentAccount.getCustId()){
                currentAccBal = currentAccount.getBalance();
            }
        }
        double depositAccBal = 0;
        for(int i = 0; i < depositAccounts.size(); i++){
            DepositAccount depositAccount = depositAccounts.get(i);
            //compare input to the accounts customer number
            if (custNo == depositAccount.getCustId()){
                depositAccBal = depositAccount.getBalance();
            }
        }

        System.out.printf("Current Account Balance: €%.2f\nDeposit Account Balance: €%.2f\n", currentAccBal, depositAccBal);
    }

    private void logOut(){}



    //String Format
    @Override
    public String toString() {
        return super.toString();
    }
}
