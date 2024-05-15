package com.bluefox.model.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bluefox.model.account.Account;
import com.bluefox.utils.ClientStatus;

public class Client {
    private String name;
    private String password;
    private String cpf;
    private ClientStatus status;
    private List<Account> accounts;
    private Map<LocalDateTime, String> operations;
    
    public Client(String name, String password, String cpf) {
        this.name = name;
        this.password = password;
        this.cpf = cpf;
        this.status = ClientStatus.ACTIVE;
        this.accounts = new ArrayList<>();
        this.operations = new TreeMap<>();
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

    public ClientStatus getStatus() {
        return status;
    }

    public String getCPF() {
        return cpf;
    }

    public Map<LocalDateTime, String> getOperations() {
        return operations;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void addOperation(LocalDateTime dateTime, String operation) {
        operations.put(dateTime, operation);
    }



}
