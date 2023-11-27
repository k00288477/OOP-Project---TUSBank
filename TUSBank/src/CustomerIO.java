public class CustomerIO
{
    public static Customer getCustomer(int custNo)
    {
        Customer cust = new Customer();

        if (custNo == 1000){
            cust.setCustId(1000);
            cust.setFirstName("Emma");
            cust.setLastName("Jones");
            cust.setAddress(new Address("10a", "Road Street", "Limerick", "V941123"));
        }
        else if (custNo == 1001){
            cust.setCustId(1001);
            cust.setFirstName("John");
            cust.setLastName("Smith");
            cust.setAddress(new Address("123", "Main Street", "Springfield", "ABC123"));

        }
        else if (custNo == 1002){
            cust.setCustId(1002);
            cust.setFirstName("Alice");
            cust.setLastName("Johnson");
            cust.setAddress(new Address("456", "Oak Avenue", "Willowdale", "XYZ456"));
        }
        else if (custNo == 1003){
            cust.setCustId(1003);
            cust.setFirstName("Michael");
            cust.setLastName("Brown");
            cust.setAddress(new Address("789", "Pine Lane", "Greenfield", "DEF789"));

        }
        else if (custNo == 1004){
            cust.setCustId(1004);
            cust.setFirstName("Paul");
            cust.setLastName("Reid");
            cust.setAddress(new Address("101", "Cedar Road", "Rivertown", "GHI101"));
        }

        return cust;
    }

}
