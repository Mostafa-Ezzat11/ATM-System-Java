package ATM;

public class Account {

    private String accountNumber;
    private int pin;
    private double balance;

    public Account(String accountNumber, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        try {
            if (amount <= 0) {
                throw new Exception("Amount must be greater than zero");
            }
            balance += amount;
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    public void withdraw(double amount) {
        try {
            if (amount <= 0) {
                throw new Exception("Amount must be greater than zero");
            }
            if (amount > balance) {
                throw new Exception("Insufficient balance");
            }
            balance -= amount;
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
}
