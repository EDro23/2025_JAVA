package ca.nl.cna.ethan.drover.A1;

public class TransactionTest {

    public static void main(String[] args) {
        System.err.println("Bank Account - ChequingAccount Tests\n");

        // 1. Test creating ChequingAccount with negative balance
        try {
            ChequingAccount badAccount = new ChequingAccount(-100);
            System.err.println("Initial account balance cannot be negative");
        } catch (InvalidAccountActionException e) {
            System.err.println(e.getMessage());
        }

        // 2. Test creating valid ChequingAccount
        ChequingAccount chequing = null;
        try {
            chequing = new ChequingAccount(500);
            System.err.println("Created ChequingAccount with balance 500");
        } catch (InvalidAccountActionException e) {
            System.err.println(e.getMessage());
            return;
        }

        // 3. Test deposit negative amount
        try {
            chequing.deposit(-50);
            System.err.println("Cannot deposit negative amount");
        } catch (InvalidAccountActionException e) {
            System.err.println(e.getMessage());
        }

        // 4. Test withdraw zero amount
        try {
            chequing.withdraw(0);
            System.err.println("Cannot withdraw zero amount");
        } catch (InvalidAccountActionException e) {
            System.err.println(e.getMessage());
        }

        // 5. Test withdraw negative amount
        try {
            chequing.withdraw(-30);
            System.err.println("Cannot withdraw negative amount");
        } catch (InvalidAccountActionException e) {
            System.err.println(e.getMessage());
        }

        // 6. Test withdraw more than balance
        try {
            chequing.withdraw(1000);  // balance is 500, so 1000 is too much
            System.err.println("Cannot withdraw more than balance");
        } catch (InvalidAccountActionException e) {
            System.err.println(e.getMessage());
        }

        // 7. Normal deposit and withdraw (should work)
        try {
            chequing.deposit(200);
            System.err.printf("Balance after deposit: %.2f%n", chequing.getBalance());

            chequing.withdraw(100);
            System.err.printf("Balance after withdrawal: %.2f%n", chequing.getBalance());
        } catch (InvalidAccountActionException e) {
            System.err.println(e.getMessage());
        }
    }
}
