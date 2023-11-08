public class Address {
    //attributes
    private String houseNumber;
    private String street;
    private String city;
    private String eircode;

    //constructors
    public Address(
            String houseNumber,
            String street,
            String city,
            String eircode
    ) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.eircode = eircode;
    }

    //getters & setters

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEircode() {
        return eircode;
    }

    public void setEircode(String eircode) {
        this.eircode = eircode;
    }

    //methods

    //String Format

    @Override
    public String toString() {
        return String.format(
                "House Number: %s, " +
                "Street: %s, " +
                "City: %s, " +
                "Eir Code: %s, ", getHouseNumber(), getStreet(), getCity(), getEircode());
    }
}
