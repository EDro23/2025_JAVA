package ca.nl.cna.ethan.drover.A1;

import java.sql.SQLOutput;

/**
 * Class for testing the Chequing Account and Savings Account
 */
public class TransactionTest {

    public static void main(String[] args) {
        System.out.println("Bank Account");

        SavingsAccount ethanSavings = new SavingsAccount(0,3);

        ChequingAccount droverChequing = new ChequingAccount(0);

        // Starting Balance
        System.out.printf("\nStarting Savings Balance: %.2f",ethanSavings.getBalance());
        System.out.printf("\nSarting Chequing Balance: %.2f",droverChequing.getBalance());
        System.out.println("");

        // Deposit 5000
        ethanSavings.deposit(5000);
        System.out.printf("\nDeposited 5000 into Savings Account \nNew Savings Balance: %.2f",ethanSavings.getBalance());

        // Adding interest
        System.out.println("");
        System.out.println("\nAdding Interest 3% to Savings Account");
        ethanSavings.addInterest(ethanSavings.getInterestRate());
        System.out.printf("New Savings Balance: %.2f",ethanSavings.getBalance());

        // Transferring $1000 into Chequing Account
        System.out.println("");
        System.out.println("\nTransfer $1000 To the Chequing Account from Savings Account");
        ethanSavings.transfer(droverChequing,1000);
        System.out.printf("New Chequing Balance: %.2f",droverChequing.getBalance());

        // Withdraw 200 from Chequing Account
        System.out.println("");
        System.out.println("\nWithdrawing $200 from the Chequing Account");
        droverChequing.withdraw(200);
        System.out.printf("New Chequing Balance: %.2f",droverChequing.getBalance());

        // Withdraw 400 from Cheqing Account
        System.out.println("");
        System.out.println("\nWithdrawing $400 from the Chequing Account");
        droverChequing.withdraw(400);
        System.out.printf("New Chequing Balance: %.2f",droverChequing.getBalance());

        // Withdraw 300 from Chequing Account
        System.out.println("");
        System.out.println("\nWithdrawing $300 from the Chequing Account");
        droverChequing.withdraw(300);
        System.out.printf("New Chequing Balance: %.2f",droverChequing.getBalance());

        // Withdraw 50 from Chequing Account
        System.out.println("");
        System.out.println("\nWithdrawing $50 from the Chequing Account");
        droverChequing.withdraw(50);
        System.out.printf("New Chequing Balance: %.2f",droverChequing.getBalance());

        // Changing interest of Savings Account to 5%
        ethanSavings.changeInterest(5);

        // Adding interest to the savings account with the new interest rate
        System.out.println("");
        ethanSavings.addInterest(ethanSavings.getInterestRate());

        System.out.println("");
        System.out.printf("Final Savings Balance: %.2f",ethanSavings.getBalance());
        System.out.println("");
        System.out.printf("Final Chequing Balance: %.2f",droverChequing.getBalance());
        }
    }