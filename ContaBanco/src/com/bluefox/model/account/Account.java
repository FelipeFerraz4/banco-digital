package com.bluefox.model.account;

public abstract class Account {
    
    private static final int BANK_BRANCH = 1;
    private static int SERIAL_ACCOUNT_NUMBER = 1;

    private String accountType;
    private int bankBranch;
    private int accountNumber;
    private double bankBalance;
    
    public Account(String accountType) {
        this.accountType = accountType;
        this.bankBranch = BANK_BRANCH;
        this.accountNumber = SERIAL_ACCOUNT_NUMBER++;
        this.bankBalance = 0;
    }

    protected void bankWithdraw(double value) {
        if (value < 2) {
            System.out.println("Invalid value, withdraw at least R$ 2,00");
        } else if (this.bankBalance < value) {
            System.out.println("Insufficient bank balance for operation");
        }

        this.bankBalance -= value;
    }

    protected void bankDeposit(double value) {
        if (value < 0.01) {
            System.out.println("Invalid value, deposit at least R$ 0,01");
        }

        this.bankBalance += value;
    }

    protected void bankTransfer(double value, Account account) {
        if(this.bankBalance < value) {
            System.out.println("Insufficient bank balance for operation");
        }
        account.bankDeposit(value);
        this.bankBalance -= value;
    }

    public String getAccountData() {
        return String.format("==== Account ====%n" +
        "Bank Branch: %04d%n" +
        "Account Number: %06d%n" +
        "Bank Balance: $ %.2f" , this.getBankBranch(), this.getAccountNumber(), this.getBankBalance()).replace(",", ".");
    }

    public String getBankingOperationAvailable() {
        return "==== Banking Operation Available ====" +
        "\nWithdraw" + "\nDeposit" + "\nTransfer";
    }

    protected String getAccountType() {
        return accountType;
    }

    protected int getBankBranch() {
        return bankBranch;
    }

    protected int getAccountNumber() {
        return accountNumber;
    }

    protected double getBankBalance() {
        return bankBalance;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + bankBranch;
        result = prime * result + accountNumber;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        if (bankBranch != other.bankBranch)
            return false;
        if (accountNumber != other.accountNumber)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Account [accountType: " + accountType + ", bankBranch: " + bankBranch + ", accountNumber: " + accountNumber
                + ", bankBalance: " + bankBalance + "]";
    }
}