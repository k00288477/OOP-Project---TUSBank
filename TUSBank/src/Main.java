//OOP Project
//TUS Bank Application
//Author: K00288477 Gary O'Connor
//Date Created: 2023-11-08

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
       //test
        CurrentAccount test1 = new CurrentAccount(
                00001,
                00002,
                234.20,
                LocalDate.now(),
                0.005
        );

        DepositAccount test2 = new DepositAccount(
                00002,
                00003,
                2300.30,
                LocalDate.now()
        );
        Address a1 = new Address("30a Clonile", "Old Cratloe Road", "Limerick", "V94 N411");
        Customer c1 = new Customer(
                "Gary",
                "O'Connor",
                a1
                );

        System.out.println("\nCurrent Account: \n" + test1.toString());

        System.out.println("\nDeposit Account: \n" + test2.toString());

        System.out.println("\nCustomer: \n" + c1.toString());
    }
}