import service.ATM_S;
import service.Bank;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        ATM_S atm = new ATM_S(bank);
        atm.start();
    }
}
