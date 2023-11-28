import java.time.LocalDate;
import java.util.Scanner;

public class DepositAccount extends Account {
    //attributes
    private static double depositAccAIR = 0.02;

    //constructors
    public DepositAccount(
            int accountId,
            int custId,
            double balance,
            LocalDate dateCreated
    ) {
        super(accountId, custId, balance, dateCreated);
    }

    //getters & setters
    public static double getDepositAccAIR() {
        return depositAccAIR;
    }

    public static void setDepositAccAIR(double depositAccAIR) {
        DepositAccount.depositAccAIR = depositAccAIR;
    }

    //methods
    public static void withdrawMoney(Account account){
        Scanner sc = new Scanner(System.in);
        System.out.println("Withdrawing from Deposit Account");

        //ask the user how much to withdraw
        System.out.printf("Your balance is €%.2f.\nHow much would you like to withdraw? (Enter zero to exit)", account.getBalance());
        double amount = sc.nextDouble();


        //validate that the account balance is greater than the amount requested
        //and the amount requested will not leave the account overdrawn
        if (amount > 0 && amount <= account.getBalance()) {
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

        System.out.println("Deposit into Deposit Account");
        //display current balance, ask user how much they want to deposit
        System.out.printf("\nYour balance is €%.2f.\nHow much would you like to deposit? (Enter zero to exit)", account.getBalance());
        //read in amount
        deposit = sc.nextDouble();
        //set new balance
        account.setBalance(account.getBalance() + deposit);
        //display new balance
        System.out.printf("Deposit Successful!\nYour new balance is €%.2f\n", account.getBalance());
    }
    //String Format

    @Override
    public String toString() {
        return String.format(super.toString() + "\nDeposit Account AIR: %.2f", getDepositAccAIR());
    }
}
