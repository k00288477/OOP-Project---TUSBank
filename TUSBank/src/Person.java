public abstract class Person {
    //attributes
    private String firstName;
    private String lastName;
    private Address address;

    //constructors
    protected Person(){}

    protected Person(String firstName,
                     String lastName,
                     Address address
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    //getters & setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    //methods

    //String Format
    @Override
    public String toString() {
        return String.format(
                "First Name: %s," +
                        "\nLast Name: %s," +
                        "\nAddress: %s", getFirstName(), getLastName(), getAddress()
        );
    }
}
