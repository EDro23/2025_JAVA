package ca.nl.cna.ethan.drover.A1;

/**
 * Class for the savings account
 */
public class SavingsAccount extends BankAccount{

    private double interestRate = 0;

    /**
     * Create a savings account with a balance and interest rate
     * @param balance balance of the savings account starting off
     * @param interestRate interest rate of the savings account
     */
    public SavingsAccount(double balance, double interestRate) throws InvalidAccountActionException{
        super(balance);
        this.interestRate = interestRate;

    }

    public SavingsAccount() {
        super();
    }

    /**
     * Get the interest rate from the savings account
     * @return interest rate of savings account
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Deposit into savings account
     * @param amount amount to be deposited to account
     */
    public void deposit(double amount) throws InvalidAccountActionException {
        super.deposit(amount);
    }

    /**
     * Withdraw from savings account
     * @param amount amount to withdraw from account
     */
    public void withdraw(double amount) throws InvalidAccountActionException {
            super.withdraw(amount);
        }

    /**
     * Change the interest rate of the savings account
     * @param amount the new interest rate
     */
    public void changeInterest(double amount) throws InvalidAccountActionException {
        if (amount > 0) {
            interestRate = amount;
        } else {
            throw new InvalidAccountActionException("Interest rate must be positive");
        }
    }

    /**
     * Add interest to the current rate
     * @param amount rate to be added on to the current interest rate
     * @throws InvalidAccountActionException if interest rate is negative
     */
    public void addInterest(double amount) throws InvalidAccountActionException {
        if (amount > 0) {
            double interest = getBalance() * (interestRate / 100);
            deposit(interest);
        } else {
            throw new InvalidAccountActionException("Interest rate must be positive");
        }
    }
}