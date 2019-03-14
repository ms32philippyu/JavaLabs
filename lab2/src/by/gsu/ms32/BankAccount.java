package by.gsu.ms32;

public class BankAccount {
    private String accountName;
    private int balance;
    private boolean status;

    public BankAccount(String accountName, int balance, boolean status) {
        this.accountName = accountName;
        this.balance = balance;
        this.status = status;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getBalance() {
        return (balance);
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return accountName + ";" + Byn.toByn(balance) + ";" + status;
    }
}
