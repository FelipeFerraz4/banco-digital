package com.bluefox.view.menus;

import java.util.Scanner;

import com.bluefox.controller.Bank;
import com.bluefox.exception.account.InsufficientBankBalanceException;
import com.bluefox.exception.account.InvalidValue;
import com.bluefox.exception.bank.ElementNotFindException;
import com.bluefox.exception.bank.EmptyCustomerBankException;
import com.bluefox.model.account.Account;
import com.bluefox.model.client.Client;
import com.bluefox.view.input.UserOperationInput;

public class ClientMenu {
    public static void customerMenu(Scanner scanner, Bank bank, Client client) {
        String options = String.format("==== Menu do Cliente ====" +
        "%n1 - Check Statement." +
        "%n2 - Saque." +
        "%n3 - Depósito." +
        "%n4 - Transferir." +
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
                    withdraw(scanner, client, bank);
                    break;
                case 3:
                    deposit(scanner, client, bank);
                    break;
                case 4:
                    transfer(scanner, client, bank);
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

    private static void deposit(Scanner scanner, Client client, Bank bank) {
        try {
            System.out.println("==== Depósito Bancário ====");
            double value = UserOperationInput.getValue(scanner);
            bank.deposit(value, client);
            System.out.println("Deposito efetuado com sucesso.");
        } catch (InvalidValue e) {
            System.out.println("Valor invalido, deve ser no mínimo R$ 0,01.");
        }
        
    }

    private static void withdraw(Scanner scanner, Client client, Bank bank) {
        try {
            System.out.println("==== Saque Bancário ====");
            double value = UserOperationInput.getValue(scanner);
            bank.withdraw(value, client);
            System.out.println("Saque realizado com sucesso.");
        } catch (InvalidValue e) {
            System.out.println("Valor invalido, deve ser no mínimo R$ 2,00.");
        } catch (InsufficientBankBalanceException e) {
            System.out.println("Saldo insuficiente");
        }
    }

    private static void transfer(Scanner scanner, Client client, Bank bank) {
        try {
            System.out.println("==== Transferência Bancária ====");
            double value = UserOperationInput.getValue(scanner);
            System.out.println("== Dados para Transferir ==");
            int bankBranch = UserOperationInput.getBankBranch(scanner);
            int accountNumber = UserOperationInput.getAccountNumber(scanner);
            bank.transfer(value, client, bankBranch, accountNumber);
            System.out.println("Transferencia realizada com sucesso.");
        } catch (InvalidValue e) {
            System.out.println("Valor invalido, deve ser no mínimo R$ 0,01.");
        } catch (InsufficientBankBalanceException e) {
            System.out.println("Saldo insuficiente");
        } catch (EmptyCustomerBankException | ElementNotFindException e) {
            System.out.println("A conta de destino informada não foi encontrada.");
            System.out.println("Por favor, verifique se os dados inseridos estão corretos.");
        }

    }
}
