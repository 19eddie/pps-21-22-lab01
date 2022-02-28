package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccountWithAtm implements BankAccount {

    private double balance;
    private final AccountHolder holder;
    private static final int FEE = 1;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }
    @Override
    public AccountHolder getHolder(){
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID) && isDepositAllowed(amount)) {
            this.balance += amount-FEE;
        }
    }

    private boolean isDepositAllowed(final double amount){
        return FEE <= amount;
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= amount+FEE;
        }
    }

    private boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount+FEE;
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
}
