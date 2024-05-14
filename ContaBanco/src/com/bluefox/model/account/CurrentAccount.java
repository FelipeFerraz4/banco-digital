package com.bluefox.model.account;
public class CurrentAccount extends Account{

    public CurrentAccount() {
        super("current account");
    }

    public void bankPaymentByBankSlip(double value, Account account) {
        if (value < 3) {
            System.out.println("Invalid value, withdraw at least R$ 3,00");
        }
        this.bankTransfer(value, account);
    }

    @Override
    public String getAccountData() {
        return String.format("==== Current Account ====%n" +
        "Bank Branch: %04d%n" +
        "Account Number: %06d%n" +
        "Bank Balance: $ %.2f" , this.getBankBranch(), this.getAccountNumber(), this.getBankBalance()).replace(",", ".");
    }

    @Override
    public String getBankingOperationAvailable() {
        return "==== Banking Operation Available ====" +
        "\nWithdraw" + "\nDeposit" + "\nTransfer" +
        "\nPaymentByBankSlip";
    }
}
