package ca.nl.cna.ethan.drover.A1;

/**
 * Parent class for all bank account classes
 */
public class BankAccount {

    private double balance;

    /**
     * Create an account with no initial balance
     */
    public BankAccount() {
        this.balance = 0;
    }

    /**
     * Create an account with an initial balance.
     * If balance is negative the balance is set to 0
     * @param balance initial balance
     */
    public BankAccount(double balance) {
        if (balance < 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    /**
     * Get the balance of the account
     * @return balance of account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deposit money into the account
     * @param amount amount to be deposited to account
     */
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    /**
     * Withdraw money from account
     * @param amount amount to withdraw from account
     */
    public void withdraw(double amount) {
        if (amount >0 && this.balance >= amount) {
            this.balance -= amount;
        }
    }

    /**
     * Transfer to another account
     * @param destination source of the account to send to
     * @param amount amount being sent to the destination
     */
    public void transferTo(BankAccount destination, double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            destination.deposit(amount);
        }
    }

    /**
     * Transfer funds from source bank account to destination
     * @param destination Destination for funds
     * @param source source of funds
     * @param amount amount being transferred
     */
    public static void transfer(BankAccount destination, BankAccount source, double amount) {
        if(amount > 0 && source.balance >= amount) {
            source.withdraw(amount);
            destination.deposit(amount);
        }
    }
}