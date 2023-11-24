import java.time.LocalDate;

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

    //String Format

    @Override
    public String toString() {
        return String.format(super.toString() + "\nDeposit Account AIR: %.2f", getDepositAccAIR());
    }
}
