package com.bluefox.controller;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.bluefox.exception.account.InsufficientBankBalanceException;
import com.bluefox.exception.account.InvalidValue;
import com.bluefox.exception.bank.ElementNotFindException;
import com.bluefox.exception.bank.EmptyCustomerBankException;
import com.bluefox.exception.bank.IncompatiblePasswordException;
import com.bluefox.model.account.Account;
import com.bluefox.model.account.CurrentAccount;
import com.bluefox.model.account.SavingAccount;
import com.bluefox.model.client.Client;

public class Bank {
    private Set<Client> clients;

    public Bank() {
        this.clients = new HashSet<>();
    }

    public void addClient(String name, String password, String cpf) {
        Client client = new Client(name, password, cpf);

        Account account = new CurrentAccount();
        client.addAccount(account);
        
        clients.add(client);
    }

    public void addSavingAccount(Client client) {
        SavingAccount savingAccount = new SavingAccount();
        client.getAccounts().add(savingAccount);
    }

    public void deposit(double value, Client client) throws InvalidValue {
        client.getAccounts().get(0).bankDeposit(value);
        String statemente = String.format("%s -> Depósito no valor de %.2f", getFormatDate(), value);
        addOperation(statemente, client);
    }

    public void withdraw(double value, Client client) throws InvalidValue, InsufficientBankBalanceException {
        client.getAccounts().get(0).bankWithdraw(value);
        String statemente = String.format("%s -> Saque no valor de %.2f", getFormatDate(), value);
        addOperation(statemente, client);
    }

    public void transfer(double value, Client client, int bankBranch, int accountNumber) throws EmptyCustomerBankException, ElementNotFindException, InvalidValue, InsufficientBankBalanceException {
        Account account = checkAccountExistence(bankBranch, accountNumber);

        client.getAccounts().get(0).bankTransfer(value, account);
        String statemente = String.format("%s -> Transferência no valor de %.2f para a conta %d da agência %d", getFormatDate(), value, accountNumber, bankBranch);
        addOperation(statemente, client);
    }

    public Account checkAccountExistence(int bankBranch, int accountNumber) throws EmptyCustomerBankException, ElementNotFindException {
        if (clients.isEmpty()) {
            throw new EmptyCustomerBankException();
        }

        Account accountToCheck = null;
        for (Client client : clients) {
            for (Account account : client.getAccounts()) {
                if(account.getBankBranch() == bankBranch && account.getAccountNumber() == accountNumber) {
                    accountToCheck = account;
                }
            }
        }

        if (accountToCheck == null) {
            throw new ElementNotFindException("Element Not Find in Customer Bank Set");
        }

        return accountToCheck;
    }

    private void addOperation(String operation, Client client) {
        client.getOperations().put(LocalDateTime.now(), operation);
    }

    public String statement(Client client) {
        StringBuilder statement = new StringBuilder();

        for (String operation : client.getOperations().values()) {
            statement.append(String.format("%s%n", operation));
        }

        return statement.toString();
    }

    private String getFormatDate() {
        LocalDateTime date = LocalDateTime.now();
        return String.format("%s/%s/%s - %s:%s:%s",date.getDayOfMonth(), date.getMonth(), date.getYear(), date.getHour(), date.getMinute(), date.getSecond());
    }

    public Client checkClient(String cpf, String password) throws EmptyCustomerBankException, ElementNotFindException, IncompatiblePasswordException {
        if (clients.isEmpty()) {
            throw new EmptyCustomerBankException();
        }

        Client clientToCheck = null;
        for (Client client : clients) {
            if (client.getCPF().equals(cpf)) {
                clientToCheck = client;
            }
        }

        if (clientToCheck == null) {
            throw new ElementNotFindException("Element Not Find in Customer Bank Set");
        }

        if (!clientToCheck.getPassword().equals(password)) {
            throw new IncompatiblePasswordException("Incompatible Client Password");
        }

        return clientToCheck;
    }

    public Account getSavingAccount(Client client) throws ElementNotFindException {
        Account savingAccount = null;

        for (Account account : client.getAccounts()) {
            if(account.getAccountType().equalsIgnoreCase("saving account")) {
                savingAccount = account;
            }
        }

        if (savingAccount == null) {
            throw new ElementNotFindException("Not Find Saving Account");
        }

        return savingAccount;
    }

    @Override
    public String toString() {
        return "Bank [clients=" + clients + "]";
    }
    
    
}
