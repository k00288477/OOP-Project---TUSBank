import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CurrentAccount extends Account {
    //attributes
    private static double currentAccAir = 0.005;
    private double overdraft;

    //constructors
    public CurrentAccount(
            int accountId,
            int custId,
            double balance,
            LocalDate dateCreated,
            double overdraft
    ) {
        super(accountId, custId, balance, dateCreated);
        this.overdraft = overdraft;
    }

    //getters & setters
    //inherited from Account
    public static double getCurrentAccAir() {
        return currentAccAir;
    }

    public static void setCurrentAccAir(double currentAccAir) {
        CurrentAccount.currentAccAir = currentAccAir;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    //methods
    public void withdrawMoney(Account account){
        Scanner sc = new Scanner(System.in);
        System.out.println("Withdraw From Current Account");

                //ask the user how much to withdraw
                System.out.printf("Your balance is €%.2f.\nHow much would you like to withdraw? (Enter zero to exit)", account.getBalance());
                double amount = sc.nextDouble();
                double overdraft = getOverdraft();

                //validate that the account balance is greater than the amount requested
                //and the amount requested will not leave the account overdrawn
                if (amount > 0 && (amount <= account.getBalance() + overdraft)) {
                    account.setBalance(account.getBalance() - amount);
                    System.out.printf("\nWithdrawal successful. Updated balance: €%.2f\n",account.getBalance());
                } else {
                    System.out.println("\nInvalid withdrawal amount or insufficient funds.\n");
                    System.exit(0);
                }

    }

    public void depositMoney(Account account){
        Scanner sc = new Scanner(System.in);
        double deposit;

        System.out.println("Deposit into Current Account");
        //display current balance, ask user how much they want to deposit
        System.out.printf("\nYour balance is €%.2f.\nHow much would you like to deposit? (Enter zero to exit)", account.getBalance());
        //read in amount
        deposit = sc.nextDouble();
        //set new balance
        account.setBalance(account.getBalance() + deposit);
        //display new balance
        System.out.printf("Deposit Successful!\nYour new balance is €%.2f\n", account.getBalance());



    }

    //String format

    @Override
    public String toString() {
        return String.format(super.toString() +
                "\nCurrent Account AIR: %.2f" +
                "\nOverdraft: %.2f", getCurrentAccAir(), getOverdraft());
    }
}
