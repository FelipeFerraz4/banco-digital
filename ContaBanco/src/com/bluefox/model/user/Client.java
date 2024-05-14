package com.bluefox.model.user;

import java.util.List;

import com.bluefox.model.account.Account;

public class Client {
    private String name;
    private List<Account> accounts;
    
    public Client(String name, List<Account> accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }
}
