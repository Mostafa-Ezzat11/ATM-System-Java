package service;

import ATM.Account;
import java.util.Scanner;

public class ATM_S {

    private Bank bank;

    public ATM_S(Bank bank) {
        this.bank = bank;
    }

    public void start() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== ATM SYSTEM =====");
            System.out.println("1. Login");
            System.out.println("2. Create Account");
            System.out.println("3. Exit");
            System.out.print("Choice: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1 -> login();
                case 2 -> createAccount();
                case 3 -> {
                    System.out.println("Goodbye 👋");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void login() {
        Scanner input = new Scanner(System.in);

        System.out.print("Account Number: ");
        String acc = input.nextLine();

        System.out.print("PIN: ");
        int pin = input.nextInt();

        Account account = bank.authenticate(acc, pin);

        if (account == null) {
            System.out.println("❌ Invalid login");
            return;
        }

        int choice;
        do {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance");
            System.out.println("4. Logout");

            choice = input.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Amount: ");
                    account.deposit(input.nextDouble());
                    bank.updateAccount(account);
                }
                case 2 -> {
                    System.out.print("Amount: ");
                    account.withdraw(input.nextDouble());
                    bank.updateAccount(account);
                }
                case 3 -> System.out.println("Balance = " + account.getBalance());
                case 4 -> System.out.println("Logged out.");
            }

        } while (choice != 4);
    }

    private void createAccount() {
        Scanner input = new Scanner(System.in);

        System.out.print("Account Number: ");
        String acc = input.nextLine();

        System.out.print("PIN: ");
        int pin = input.nextInt();

        System.out.print("Initial Balance: ");
        double balance = input.nextDouble();

        bank.createAccount(acc, pin, balance);
        System.out.println("✅ Account created successfully.");
    }
}
