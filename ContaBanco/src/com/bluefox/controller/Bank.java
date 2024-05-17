package com.bluefox.controller;

import java.util.HashSet;
import java.util.Set;

import com.bluefox.exception.account.InsufficientBankBalanceException;
import com.bluefox.exception.account.InvalidValue;
import com.bluefox.exception.bank.ElementNotFindException;
import com.bluefox.exception.bank.EmptyCustomerBankException;
import com.bluefox.exception.bank.IncompatiblePasswordException;
import com.bluefox.model.account.Account;
import com.bluefox.model.account.CurrentAccount;
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

    public void addDeposit(double value, Client client) throws InvalidValue {
        client.getAccounts().get(0).bankDeposit(value);
    }

    public void addWithdraw(double value, Client client) throws InvalidValue, InsufficientBankBalanceException {
        client.getAccounts().get(0).bankWithdraw(value);
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

    @Override
    public String toString() {
        return "Bank [clients=" + clients + "]";
    }
    
}
