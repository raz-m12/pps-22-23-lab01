package lab01.example.model;

/**
 * This class represents an instance of a BankAccount.
 * In particular, a Simple Bank Account which allows to deposit cash via an Atm.
 * Withdrawal is allowed only if the balance is greater or equal the withdrawal amount.
 */
public class SimpleBankAccountWithAtm implements BankAccount {
    private double balance;
    private final AccountHolder holder;
    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    @Override
    public AccountHolder getHolder() {
        return null;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int userID, double amount) {
        this.balance = amount;
        this.balance--;
    }

    @Override
    public void withdraw(int userID, double amount) {

    }
}
