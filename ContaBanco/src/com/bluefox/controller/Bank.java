package com.bluefox.controller;

import java.util.HashSet;
import java.util.Set;

import com.bluefox.model.account.Account;
import com.bluefox.model.account.CurrentAccount;
import com.bluefox.model.user.Client;

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

    public void chechClient(String cpf, String password) {
        
    }
    
}
