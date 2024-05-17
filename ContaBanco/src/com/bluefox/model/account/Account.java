package com.bluefox.model.account;

import com.bluefox.exception.account.InsufficientBankBalanceException;
import com.bluefox.exception.account.InvalidValue;

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

    public void bankWithdraw(double value) throws InvalidValue, InsufficientBankBalanceException {
        if (value < 2) {
            throw new InvalidValue("Invalid value, withdraw at least R$ 2,00");
        } else if (this.bankBalance < value) {
            throw new InsufficientBankBalanceException();
        }

        this.bankBalance -= value;
    }

    public void bankDeposit(double value) throws InvalidValue {
        if (value < 0.01) {
            throw new InvalidValue("Invalid value, deposit at least R$ 0,01");
        }

        this.bankBalance += value;
    }

    public void bankTransfer(double value, Account account) throws InvalidValue, InsufficientBankBalanceException {
        if(this.bankBalance < value) {
            throw new InsufficientBankBalanceException();
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
