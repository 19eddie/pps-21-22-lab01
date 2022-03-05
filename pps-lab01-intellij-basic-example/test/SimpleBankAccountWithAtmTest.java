import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the SimpleBankAccountWithAtm implementation
 */
class SimpleBankAccountWithAtmTest extends AbstractBankAccountTest {

    private static final int FEE = 1;

    @Override
    @BeforeEach
    public void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Override
    @Test
    void testDeposit() {
        final int depositedAmount = 100;
        bankAccount.deposit(accountHolder.getId(), depositedAmount);
        assertEquals(depositedAmount-FEE, bankAccount.getBalance());
    }

    @Override
    @Test
    void testWrongDeposit() {
        final int depositedAmount = 100;
        bankAccount.deposit(accountHolder.getId(), depositedAmount);
        bankAccount.deposit(2, 50);
        assertEquals(depositedAmount-FEE, bankAccount.getBalance());
    }

    @Override
    @Test
    void testWithdraw() {
        final int depositedAmount = 100;
        final int withdrawnAmount = 70;

        bankAccount.deposit(accountHolder.getId(), depositedAmount);
        bankAccount.withdraw(accountHolder.getId(), withdrawnAmount);
        assertEquals(depositedAmount-withdrawnAmount-FEE-FEE, bankAccount.getBalance());
    }

    @Override
    @Test
    void testWrongWithdraw() {
        final int depositedAmount = 100;
        bankAccount.deposit(accountHolder.getId(), depositedAmount);
        bankAccount.withdraw(2, 70);
        assertEquals(depositedAmount-FEE, bankAccount.getBalance());
    }
}
