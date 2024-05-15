package com.bluefox.model.user;

import java.util.ArrayList;
import java.util.List;

import com.bluefox.model.account.Account;
import com.bluefox.utils.ClientStatus;

public class Client {
    private String name;
    private String password;
    private ClientStatus status;
    private List<Account> accounts;
    
    public Client(String name, String password) {
        this.name = name;
        this.password = password;
        this.status = ClientStatus.ACTIVE;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getPassword() {
        return password;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }
}
