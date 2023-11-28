import java.util.ArrayList;

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


    public void checkBalance(int customerNumber, ArrayList<Account> TUSaccounts) {
        //check the array list for accounts with the corresponding customer number
        for (Account account : TUSaccounts) {
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

    //String Format
    @Override
    public String toString() {
        return super.toString();
    }
}

