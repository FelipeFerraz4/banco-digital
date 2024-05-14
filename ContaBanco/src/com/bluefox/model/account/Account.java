package com.bluefox.model.account;

public abstract class Account {
    
    private static final int BANK_BRANCH = 1;
    private static int SERIAL_ACCOUNT_NUMBER = 1;

    private String accountType;
    private int bankBranch;
    private int accontNumber;
    private double bankBalance;
    
    public Account(String accountType) {
        this.accountType = accountType;
        this.bankBranch = BANK_BRANCH;
        this.accontNumber = SERIAL_ACCOUNT_NUMBER++;
        this.bankBalance = 0;
    }

    public String getAccountType() {
        return accountType;
    }

    public int getBankBranch() {
        return bankBranch;
    }

    public int getAccontNumber() {
        return accontNumber;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + bankBranch;
        result = prime * result + accontNumber;
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
        if (accontNumber != other.accontNumber)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Account [accountType: " + accountType + ", bankBranch: " + bankBranch + ", accontNumber: " + accontNumber
                + ", bankBalance: " + bankBalance + "]";
    }
}
