import java.time.LocalDate;

public class CurrentAccount extends Account {
    //attributes
    private static double currentAccAir = 0.005;
    private double overdraft;

    //constructors
    public CurrentAccount(
            int acountId,
            int custId,
            double balance,
            LocalDate dateCreated,
            double overdraft
    ) {
        super(acountId, custId, balance, dateCreated);
        this.overdraft = overdraft;
    }

    //getters & setters

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

    //String format

    @Override
    public String toString() {
        return String.format(super.toString() +
                "\nCurrent Account AIR: %.2f" +
                "\nOverdraft: %.2f", getCurrentAccAir(), getOverdraft());
    }
}
