package com.bluefox.view.menus;

import java.util.Scanner;

import com.bluefox.controller.Bank;
import com.bluefox.exception.account.InsufficientBankBalanceException;
import com.bluefox.exception.account.InvalidValue;
import com.bluefox.model.account.Account;
import com.bluefox.model.client.Client;
import com.bluefox.view.input.UserOperationInput;

public class ClientMenu {
    public static void customerMenu(Scanner scanner, Bank bank, Client client) {
        try {
            String options = String.format("==== Menu do Cliente ====" +
            "%n1 - Check Statement." +
            "%n2 - Withdraw Money." +
            "%n3 - Depósito." +
            "%n4 - Transfer Money." +
            "%n5 - Investment." +
            "%n6 - Mostrar Meus Dados." +
            "%n0 - Fechar Menu.");

            int option = -1;

            while (option != 0) {
                System.out.println(options);

                option = scanner.nextInt();

                switch (option) {
                    case 0:
                        System.out.println("Menu Fechado");
                        break;
                    case 1:
                        System.out.println("Login Successfully");
                        break;
                    case 2:
                        addWithdraw(scanner, client, bank);
                        break;
                    case 3:
                        addDeposit(scanner, client, bank);
                        break;
                    case 4:
                        System.out.println("Login Successfully");
                        break;
                    case 5:
                        System.out.println("Login Successfully");
                        break;
                    case 6:
                        getClientData(client);
                        break;
                    default:
                        System.out.println("Valor Digitado Invalidado.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
    }

    private static void getClientData(Client client) {
        String data = String.format("%n==== Dados do Cliente ====" + 
                "%nNome: %s" +
                "%nCPF: %s" +
                "%nSenha: %s" 
                , client.getName(), client.getCPF(), client.getPassword());
        
        for (Account account : client.getAccounts()) {
            data += String.format("%n");
            data += account.getAccountData();
        }
        data += String.format("%n");
        System.out.println(data);
    }

    private static void addDeposit(Scanner scanner, Client client, Bank bank) {
        try {
            System.out.println("==== Depósito Bancário ====");
            double value = UserOperationInput.getValue(scanner);
            bank.addDeposit(value, client);
            System.out.println("Deposito efetuado com sucesso.");
        } catch (InvalidValue e) {
            System.out.println("Valor invalido, deve ser no mínimo R$ 0,01.");
        }
        
    }

    private static void addWithdraw(Scanner scanner, Client client, Bank bank) {
        try {
            System.out.println("==== Saque Bancário ====");
            double value = UserOperationInput.getValue(scanner);
            bank.addWithdraw(value, client);
            System.out.println("Saque realizado com sucesso.");
        } catch (InvalidValue e) {
            System.out.println("Valor invalido, deve ser no mínimo R$ 2,00.");
        } catch (InsufficientBankBalanceException e) {
            System.out.println("Saldo insuficiente");
        }
    }
}
