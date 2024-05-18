package com.bluefox.model.account;

import com.bluefox.exception.account.InsufficientBankBalanceException;
import com.bluefox.exception.account.InvalidValue;

public class CurrentAccount extends Account{

    public CurrentAccount() {
        super("current account");
    }

    public void bankPaymentByBankSlip(double value, Account account) throws InvalidValue, InsufficientBankBalanceException {
        if (value < 3) {
            throw new InvalidValue("Invalid value, withdraw at least R$ 3,00");
        }
        this.bankTransfer(value, account);
    }

    @Override
    public String getAccountData() {
        return String.format("==== Current Account ====%n" +
        "Bank Branch: %04d%n" +
        "Account Number: %06d%n" +
        "Bank Balance: R$ %.2f" , this.getBankBranch(), this.getAccountNumber(), this.getBankBalance());
    }

    @Override
    public String getBankingOperationAvailable() {
        return "==== Banking Operation Available ====" +
        "\nWithdraw" + "\nDeposit" + "\nTransfer" +
        "\nPaymentByBankSlip";
    }
}
