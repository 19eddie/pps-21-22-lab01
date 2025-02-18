package lab01.example.model;

public abstract class AbstractBankAccount implements BankAccount {
    protected final AccountHolder holder;
    protected double balance;

    public AbstractBankAccount(final double balance, final AccountHolder holder) {
        this.balance = balance;
        this.holder = holder;
    }

    @Override
    public final AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public final double getBalance() {
        return this.balance;
    }

    @Override
    public final void deposit(final int userID, final double amount) {
        if (checkUser(userID) && isDepositAllowed(amount)) {
            this.balance += amount - getFee();
        }
    }

    @Override
    public final void withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= amount + getFee();
        }
    }

    private boolean isDepositAllowed(final double amount) {
        return getFee() <= amount;
    }

    private boolean isWithdrawAllowed(final double amount) {
        return this.balance >= amount + getFee();
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }

    protected abstract int getFee();
}
