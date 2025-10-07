package ua.opnu.java.inheritance.account;

public class MinMaxAccount extends BankingAccount {

    private int minBalance;
    private int maxBalance;

    public MinMaxAccount(Startup s) {
        super(s);
        this.minBalance = s.getBalance();
        this.maxBalance = s.getBalance();
    }

    @Override
    public int debit(Debit d) {
        int newBalance = super.debit(d);
        this.minBalance = Math.min(this.minBalance, newBalance);
        this.maxBalance = Math.max(this.maxBalance, newBalance);
        return newBalance;
    }

    @Override
    public int credit(Credit c) {
        int newBalance = super.credit(c);
        this.minBalance = Math.min(this.minBalance, newBalance);
        this.maxBalance = Math.max(this.maxBalance, newBalance);
        return newBalance;
    }

    public int getMin() {
        return this.minBalance;
    }

    public int getMax() {
        return this.maxBalance;
    }
}