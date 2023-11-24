import java.time.LocalDate;

public abstract class Account {
    //attributes
    private int accountId;
    private int custId;
    private double balance;
    private LocalDate dateCreated;

    //constructors
    protected Account(
            int accountId,
            int custId,
            double balance,
            LocalDate dateCreated
    ) {
        this.accountId = accountId;
        this.custId = custId;
        this.balance = balance;
        this.dateCreated = dateCreated;
    }

    //getters&setters

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    //String Format


    @Override
    public String toString() {
        return String.format(
                "Account ID: %d," +
                        "\nCustomer ID: %d," +
                        "\nBalance: €%.2f," +
                        "\nDate Created: %s", getAccountId(), getCustId(), getBalance(), getDateCreated()
        );
    }
}
