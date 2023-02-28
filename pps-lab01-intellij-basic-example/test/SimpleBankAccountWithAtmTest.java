import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * The test suite for testing the SimpleBankAccountWithAtm implementation
 */
public class SimpleBankAccountWithAtmTest {
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    private final int ANY_AMOUNT = 50;
    private final int DEPOSIT_AMOUNT = 100;
    private final int UNKNOWN_USER_ID = 2;
    @BeforeEach
    void beforeEach(){
        // Arrange
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testInitialBalanceIsZero() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);

        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void testDepositMultipleTimes() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.deposit(accountHolder.getId(), 50);

        assertEquals(148, bankAccount.getBalance());
    }

    @Test
    void testDepositCannotApplyTransactionFee() {
        assertThrows(IllegalArgumentException.class,
                () -> bankAccount.deposit(this.accountHolder.getId(), 0.5));
    }

    @Test
    void testDepositWrongId() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.deposit(UNKNOWN_USER_ID, ANY_AMOUNT);

        assertEquals(99, bankAccount.getBalance());
    }


    @Test
    void testWithdrawCash() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), 50);

        assertEquals(48, bankAccount.getBalance());
    }


    @Test
    void testWithdrawCannotApplyTransactionFee() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);

        assertThrows(IllegalArgumentException.class,
                () -> bankAccount.withdraw(this.accountHolder.getId(), 99));
    }

    @Test
    void testWithdrawWrongId() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(UNKNOWN_USER_ID, ANY_AMOUNT);

        assertEquals(99, bankAccount.getBalance());
    }
}
