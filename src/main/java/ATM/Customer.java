
package ATM;

import java.util.ArrayList;

public class Customer {

    private String nationalId;
    private String name;
    private String phone;
    private ArrayList<Account> accounts;

    public Customer(String nationalId, String name, String phone) {
        this.nationalId = nationalId;
        this.name = name;
        this.phone = phone;
        this.accounts = new ArrayList<>();
    }

    public String getNationalId() {
        return nationalId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }
}
