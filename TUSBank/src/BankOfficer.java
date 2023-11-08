public class BankOfficer extends Staff{
    //no unique attributes

    //constructor
    protected BankOfficer(
            String firstName,
            String lastName,
            Address address,
            int staffId,
            Position position,
            double salary
    ) {
        super(firstName, lastName, address, staffId, position, salary);
    }

    //String format
    @Override
    public String toString() {
        return super.toString();
    }
}
