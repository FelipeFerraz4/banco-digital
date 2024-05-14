package com.bluefox.model.account;
public class CurrentAccount {
    private String name;
    private String bankBranch;
    private int accontNumber;
    private double bankBalance;

    public CurrentAccount(String name, String bankBranch, int accontNumber, double bankBalance) {
        this.name = name;
        this.bankBranch = bankBranch;
        this.accontNumber = accontNumber;
        this.bankBalance = bankBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public int getAccontNumber() {
        return accontNumber;
    }

    public void setAccontNumber(int accontNumber) {
        this.accontNumber = accontNumber;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
    }

}
