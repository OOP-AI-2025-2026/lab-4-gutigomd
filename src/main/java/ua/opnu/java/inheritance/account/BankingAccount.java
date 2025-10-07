package ua.opnu.java.inheritance.account;

public class BankingAccount {
    private int balance;

    public BankingAccount(Startup s) {
        this.balance = s.getBalance();
    }

    public int debit(Debit d) {
        this.balance += d.getBalance();
        return this.balance;
    }

    public int credit(Credit c) {
        this.balance += c.getBalance();
        return this.balance;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingAccount that = (BankingAccount) o;
        return balance == that.balance;
    }
    @Override
    public  int hashCode() {
        return Integer.hashCode(balance);
    }

    @Override
    public String toString() {
        return "BankingAccount{"
                + "balance=" + balance + '}';
    }
}