import java.util.*;

/**
 * Represents an ATM machine with basic functions.
 */
public class ATM {
    private String acNumber;
    private String pin;
    private double balance;
    private List<Transaction> transactionHistory;

    /**
     * Initializes the ATM machine with an account number, PIN, and initial balance.
     *
     * @param accountNumber the account number
     * @param pin           the PIN
     * @param balance       the initial balance
     */
    public ATM(String accountNumber, String pin, double balance) {
        this.acNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    /**
     * Displays the account balance.
     */
    public void displayBalance() {
        System.out.println("Account Balance: $" + balance);
    }

    /**
     * Withdraws cash from the account.
     *
     * @param amount the amount to withdraw
     */
    public void withdrawCash(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount));
            System.out.println("Withdrawal successful. Remaining balance: $" + balance);
        }
    }

    /**
     * Deposits cash into the account.
     *
     * @param amount the amount to deposit
     */
    public void depositCash(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
        System.out.println("Deposit successful. New balance: $" + balance);
    }

    /**
     * Changes the PIN.
     *
     * @param newPin the new PIN
     */
    public void changePin(String newPin) {
        pin = newPin;
        System.out.println("PIN changed successfully.");
    }

    /**
     * Displays the transaction history.
     */
    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction.getType() + ": $" + transaction.getAmount());
        }
    }

    /**
     * Authenticates the user with the PIN.
     *
     * @param pin the PIN to authenticate
     * @return true if authenticated, false otherwise
     */
    public boolean authenticate(String pin) {
        return this.pin.equals(pin);
    }

    public static void main(String[] args) {
        ATM atm = new ATM("1234567890", "1234", 10000.0);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Account Balance Inquiry");
            System.out.println("2. Cash Withdrawal");
            System.out.println("3. Cash Deposit");
            System.out.println("4. PIN Change");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.displayBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double amount = sc.nextDouble();
                    atm.withdrawCash(amount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    amount = sc.nextDouble();
                    atm.depositCash(amount);
                    break;
                case 4:
                    System.out.print("Enter new PIN: ");
                    String newPin = sc.next();
                    atm.changePin(newPin);
                    break;
                case 5:
                    atm.displayTransactionHistory();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            // sc.close();
        }
    }
}

/**
 * Represents a transaction.
 */
class Transaction {
    private String type;
    private double amount;

    /**
     * Initializes a transaction with a type and amount.
     *
     * @param type   the transaction type
     * @param amount the transaction amount
     */
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    /**
     * Gets the transaction type.
     *
     * @return the transaction type
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the transaction amount.
     *
     * @return the transaction amount
     */
    public double getAmount() {
        return amount;
    }
}