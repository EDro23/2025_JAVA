package ca.nl.cna.ethan.drover.A1;

/**
 * Parent class for all bank account classes
 */
public class BankAccount {

    protected double balance;

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
     * @throws InvalidAccountActionException If the balance initially less than 0
     */
    public BankAccount(double balance) throws InvalidAccountActionException {
        if (balance > 0) {
            this.balance = balance;
        } else {
            throw new InvalidAccountActionException("Invalid account balance");
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
     * @throws InvalidAccountActionException if a negative amount is deposited
     */
    public void deposit(double amount) throws InvalidAccountActionException {
        if (amount > 0) {
            this.balance += amount;
        } else {
            throw new InvalidAccountActionException("Cannot deposit negative amount");
        }
    }

    /**
     * Withdraw money from account
     * @param amount amount to withdraw from account
     * @throws InvalidAccountActionException if the withdrawal amount is negative
     */
    public void withdraw(double amount) throws InvalidAccountActionException {
        if (amount >0 && this.balance >= amount) {
            this.balance -= amount;
        } else if (
                this.balance < amount
        )
        {
            throw new InvalidAccountActionException("Cannot deposit more than the bank account amount");
        }
    }

    /**
     * Transfer to another account
     * @param destination source of the account to send to
     * @param amount amount being sent to the destination
     * @throws  InvalidAccountActionException if the transfer amount is negative
     */
    private void transferTo(BankAccount destination, double amount) throws InvalidAccountActionException {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            destination.deposit(amount);
        } else {
            throw new InvalidAccountActionException("Cannot transfer negative amount to another account");
        }
    }

    /**
     * Transfer funds from source bank account to destination
     * @param destination Destination for funds
     * @param amount amount being transferred
     * @throws InvalidAccountActionException if transfer amount is negative
     */
    public void transfer(BankAccount destination, double amount) throws InvalidAccountActionException {
        if(amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            destination.balance += amount;
        } else {
            throw new InvalidAccountActionException("Cannot transfer negative amount");
        }
    }
}