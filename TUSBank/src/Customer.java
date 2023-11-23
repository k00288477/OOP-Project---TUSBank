public class Customer extends Person{
    //attributes
    private int custId;

    //constructors
    protected Customer(
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

    private void withdrawMoney(){}

    private double checkBalance(){
        return 0;
    }

    private void logOut(){}



    //String Format

    @Override
    public String toString() {
        return super.toString();
    }
}
