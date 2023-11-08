public class Customer extends Person{
    //attributes
    //no unique attributes

    //constructors
    protected Customer(
            String firstName,
            String lastName,
            Address address
    ) {
        super(firstName, lastName, address);
    }

    //getters & setters

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
