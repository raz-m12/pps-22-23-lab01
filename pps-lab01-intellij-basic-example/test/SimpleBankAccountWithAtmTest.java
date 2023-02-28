import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Backlog:
 * - initial balance equals 0
 * - deposit cash (withdrawing operation fee)
 * - withdraw valid amount
 * - withdraw invalid amount
 */

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
        Assertions.assertEquals(0, bankAccount.getBalance());
    }

    @Disabled
    void testDeposit() {
        // Act
        bankAccount.deposit(accountHolder.getId(), 100);

        // Assert
        Assertions.assertEquals(99, bankAccount.getBalance());
    }
}
