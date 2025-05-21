package ca.nl.cna.ethan.drover.A1;

public class ChequingAccount extends BankAccount {

public static final int FREE_TRANSACTIONS = 3;

public static final double TRANSACTION_FEE = 2.0;

private int transactionCount;

    /**
     * Create an account with a balance of 0
     */
    public ChequingAccount() {
        super();
        transactionCount = 0;
    }

    /**
     * Create an account with a initial balance of 0
     * @param balance
     */
    public ChequingAccount(double balance) {
        super(balance);
        this.transactionCount = 0;
    }

    /**
     * Depost an amunt to the account
     * @param amount
     */
    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        transactionCount++;
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        transactionCount++;
        if(transactionCount >= FREE_TRANSACTIONS) {
            chargeFees();
        }
    }

    public void chargeFees() {

    }
}
