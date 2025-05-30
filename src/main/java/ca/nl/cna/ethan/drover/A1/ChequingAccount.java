package ca.nl.cna.ethan.drover.A1;

public class ChequingAccount extends BankAccount {

public static final int FREE_TRANSACTIONS = 3;

public static final double TRANSACTION_FEE = 2.0;

private int transactionCount;

    /**
     * Create an account with a initial balance of 0
     * @param balance The balance of the Chequing Account
     * @throws InvalidAccountActionException if the initial balance entered is negative
     */
    public ChequingAccount(double balance) throws InvalidAccountActionException {
        super(0);
        if (balance < 0) {
            throw new InvalidAccountActionException("Initial balance cannot be negative");
        }
        this.balance = balance;
        this.transactionCount = 0;
    }

    /**
     * Depost an amount to the account
     * @param amount The amount to deposit to the Chequing Account
     */
    @Override
    public void deposit(double amount) {

        if (amount < 0) {
            throw new IllegalArgumentException("Amount being deposited cannot be negative");
        }
        super.deposit(amount);
        transactionCount++;
    }

    /**
     * Withdraw from the Chequing account and add one to the transaction count
     * @param amount amount to withdraw from account
     * @throws IllegalArgumentException if the number is negative or there isn't enough funds
     */
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must positive");
        }

        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient funds, you cannot overdraw the account");
        }
        super.withdraw(amount);
        transactionCount++;
    }

    /**
     * Charge fees method for charging the fees at the end of the period
     */
    public void chargeFees() {
        if(transactionCount > FREE_TRANSACTIONS) {
            this.balance -= TRANSACTION_FEE;
        }
        transactionCount = 0;
    }
}