public class Staff extends Person {
    //attributes
    private int staffId;
    private Position position;
    private double salary;

    //constructors
    protected Staff(
            String firstName,
            String lastName,
            Address address,
            int staffId,
            Position position,
            double salary
    ) {
        super(firstName, lastName, address);
        this.staffId = staffId;
        this.position = position;
        this.salary = salary;
    }

    //getters & setters
    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //methods
    //Note: methods set to protected as they will only be accessed by sub classes
    protected void createNewCustomer(){}

    protected void createNewCurrentAccount(){}

    protected void createNewDepositAccount(){}

    protected void changeDepositAccAIR(){}

    protected void changeCurrentAccAIR(){}

    protected void changeOverdraft(){}

    //TODO change method to return the Array List of accounts
    protected void printAllAccounts(){}


    //String Format
    @Override
    public String toString() {
        return String.format(
                super.toString() +
                        "\nStaff ID: %d," +
                        "\nPosition: %s," +
                        "\nSalary: %.2f", getStaffId(), getPosition(), getSalary()
        );
    }
}
