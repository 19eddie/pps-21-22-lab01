import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractBankAccountTest {
    protected AccountHolder accountHolder;
    protected BankAccount bankAccount;

    @BeforeEach
    public abstract void beforeEach();

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        final int depositedAmount = 100;
        bankAccount.deposit(accountHolder.getId(), depositedAmount);
        assertEquals(depositedAmount-getFee(), bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        final int depositedAmount = 100;
        bankAccount.deposit(accountHolder.getId(), depositedAmount);
        bankAccount.deposit(2, 50);
        assertEquals(depositedAmount-getFee(), bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        final int depositedAmount = 100;
        final int withdrawnAmount = 70;
        bankAccount.deposit(accountHolder.getId(), depositedAmount);
        bankAccount.withdraw(accountHolder.getId(), withdrawnAmount);
        assertEquals(depositedAmount-withdrawnAmount-getFee()-getFee(), bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        final int depositedAmount = 100;
        bankAccount.deposit(accountHolder.getId(), depositedAmount);
        bankAccount.withdraw(2, 70);
        assertEquals(depositedAmount-getFee(), bankAccount.getBalance());
    }

    protected abstract int getFee();
}
