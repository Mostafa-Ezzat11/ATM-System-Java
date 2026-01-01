package service;

import ATM.Account;

import java.io.*;
import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts = new ArrayList<>();
    private final String FILE_PATH = "src/data/accounts.txt";

    public Bank() {
        loadAccountsFromFile();
    }

    // تحميل الحسابات من الملف
    private void loadAccountsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String accNum = data[0];
                int pin = Integer.parseInt(data[1]);
                double balance = Double.parseDouble(data[2]);

                accounts.add(new Account(accNum, pin, balance));
            }

        } catch (IOException e) {
            System.out.println("Error loading accounts file");
        }
    }

    // حفظ الحسابات في الملف
    private void saveAccountsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {

            for (Account acc : accounts) {
                bw.write(acc.getAccountNumber() + "," +
                         acc.getPin() + "," +
                         acc.getBalance());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving accounts");
        }
    }

    public Account authenticate(String accNum, int pin) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accNum) && acc.getPin() == pin) {
                return acc;
            }
        }
        return null;
    }

    public void createAccount(String acc, int pin, double balance) {
        accounts.add(new Account(acc, pin, balance));
        saveAccountsToFile();
    }

    public void updateAccount(Account acc) {
        saveAccountsToFile();
    }
}
