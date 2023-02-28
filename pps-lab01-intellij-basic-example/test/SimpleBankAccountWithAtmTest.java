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
    @BeforeEach
    void beforeEach(){
        // Arrange
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testInitialBalanceIsZero() {
        // Act
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        // Act
        bankAccount.deposit(accountHolder.getId(), 100);

        // Assert
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void testIncrementalDeposit() {
        // Act
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.deposit(accountHolder.getId(), 50);

        // Assert
        assertEquals(148, bankAccount.getBalance());
    }

    @Test
    void testCannotApplyTransactionFeeOnDeposit() {
        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> bankAccount.deposit(this.accountHolder.getId(), 0.5));
    }


    @Test
    void testSuccessfulCashWithdrawal() {
        bankAccount.deposit(accountHolder.getId(), 150);
        bankAccount.withdraw(accountHolder.getId(), 50);

        assertEquals(98, bankAccount.getBalance());
    }


    @Test
    void testUnsuccessfulCashWithdrawal() {
        bankAccount.deposit(accountHolder.getId(), 150);

        assertThrows(IllegalArgumentException.class,
                () -> bankAccount.withdraw(this.accountHolder.getId(), 500));
    }
}
