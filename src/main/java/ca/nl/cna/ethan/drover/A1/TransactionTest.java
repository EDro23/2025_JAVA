package ca.nl.cna.ethan.drover.A1;

import java.util.Random;

public class TransactionTest {

    public static void main(String[] args) {
        System.out.println("Hello again Java!");

        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            double initialBalance = rand.nextDouble();
            BankAccount account = new BankAccount(rand.nextDouble());

            System.out.println("Initial balance: " + initialBalance);
            System.out.println("Initial balance: " + account.getBalance());
        }
    }
}