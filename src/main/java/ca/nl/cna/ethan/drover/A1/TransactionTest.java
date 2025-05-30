package ca.nl.cna.ethan.drover.A1;

public class TransactionTest {

    public static void main(String[] args) {
        System.out.println("Bank Account\n");


        // 1. Test: Creating ChequingAccount with negative balance (should throw InvalidAccountActionException)
        System.out.println("Trying to create a account with negative amount");
        try {
            ChequingAccount invalidAccount = new ChequingAccount(-50);
            System.out.println("ERROR: Initial account balance cannot be negative");
        } catch (InvalidAccountActionException error) {
            System.out.println("Exception: " + error.getMessage());
        }

        // Creating a valid Chequing Account
        ChequingAccount droverChequing = null;
        try {
            droverChequing = new ChequingAccount(1000);
            System.out.println("Created a Chequing Account with balance 1000");
        } catch (InvalidAccountActionException e) {
            System.out.println("Unexpected exception creating account: " + e.getMessage());
        }

        // 2. Testing depositing a negative amount to the chequing account
        try {
            System.out.println("\nAttempting to deposit -100");
            droverChequing.deposit(-100);
            System.out.println("ERROR: Deposited negative amount (should NOT happen)");
        } catch (IllegalArgumentException error) {
            System.out.println("Exception: " + error.getMessage());
        }

        // 3. Test: Withdraw zero or negative amount
        try {
            System.out.println("\nAttempting to withdraw 0");
            droverChequing.withdraw(0);
            System.out.println("ERROR: Withdraw zero amount (should NOT happen)");
        } catch (IllegalArgumentException error) {
            System.out.println("Exception: " + error.getMessage());
        }

        try {
            System.out.println("\nAttempting to withdraw -50");
            droverChequing.withdraw(-50);
            System.out.println("ERROR: Withdraw negative amount (should NOT happen)");
        } catch (IllegalArgumentException error) {
            System.out.println("Exception: " + error.getMessage());
        }

        // 4. Test: Withdraw more than balance (insufficient funds)
        try {
            System.out.println("\nAttempting to withdraw 2000 (more than balance)");
            droverChequing.withdraw(2000);
            System.out.println("ERROR: Withdrawn more than balance (should NOT happen)");
        } catch (IllegalArgumentException error) {
            System.out.println("Exception: " + error.getMessage());
        }

        // Normal deposit and withdraw that should work
        System.out.println("\nDepositing 500");
        droverChequing.deposit(500);
        System.out.printf("Balance after deposit: %.2f\n", droverChequing.getBalance());

        System.out.println("\nWithdrawing 300");
        droverChequing.withdraw(300);
        System.out.printf("Balance after withdrawal: %.2f\n", droverChequing.getBalance());

        // Final balance print
        System.out.printf("\nFinal Chequing Balance: %.2f\n", droverChequing.getBalance());
    }
}
