package lab01.example.model;

import static lab01.example.model.Utils.checkUser;
import static lab01.example.model.Utils.isWithdrawAllowed;

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
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int userID, double amount) {
        if(checkUser(this.getHolder(), userID)) {
            this.balance += amount;
            this.applyTransactionFee();
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if(isWithdrawAllowed(this.getBalance(), amount) && checkUser(this.getHolder(), userID)) {
            this.balance -= amount;
            this.applyTransactionFee();
        }
    }

    private void applyTransactionFee() {
        if(!this.canSubtractTransactionFee()) {
            throw new IllegalArgumentException("Transaction fee cannot be applied, balance less than 1");
        }

        this.balance--;
    }

    private boolean canSubtractTransactionFee() {
        return this.balance >= 1;
    }
}
