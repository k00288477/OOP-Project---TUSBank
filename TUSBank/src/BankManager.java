public class BankManager extends Staff{
    //no unique attributes

    //constructor
    protected BankManager(
            String firstName,
            String lastName,
            Address address,
            int staffId,
            Position position,
            double salary
    ) {
        super(firstName, lastName, address, staffId, position, salary);
    }

    //methods
    private static void createBankOfficer(){
        //Create a new Bank Officer Object
    }

    //string Format
    @Override
    public String toString() {
        return super.toString();
    }
}
