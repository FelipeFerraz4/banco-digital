package com.bluefox.model.client;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bluefox.model.account.Account;
import com.bluefox.utils.ClientStatus;

public class Client {
    private String name;
    private String cpf;
    private String password;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
        Client other = (Client) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Client [name=" + name + ", cpf=" + cpf + ", password=" + password + ", status=" + status + ", accounts="
                + accounts + ", operations=" + operations + "]";
    }



}
