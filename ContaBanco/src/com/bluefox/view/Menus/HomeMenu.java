package com.bluefox.view.menus;

import java.util.Scanner;

import com.bluefox.controller.Bank;
import com.bluefox.exception.bank.ElementNotFindException;
import com.bluefox.exception.bank.EmptyCustomerBankException;
import com.bluefox.exception.bank.IncompatiblePasswordException;
import com.bluefox.model.client.Client;
import com.bluefox.view.input.UserCredentialInput;

public class HomeMenu {

    private Bank bank;

    public HomeMenu() {
        this.bank = new Bank();
    }

    public void homeMenu(Scanner scanner) {
        String options = String.format("==== Sistema Bancário ====" +
        "%n1 - Entrar na Conta." +
        "%n2 - Criar Conta." +
        "%n0 - Fechar o Sistema.");

        int option = -1;

        while (option != 0) {
            System.out.println(options);

            option = scanner.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Sistema Finalizado.");
                    break;
                case 1:
                    Login(scanner);
                    break;
                case 2:
                    this.createAccount(scanner);
                    System.out.println("Conta Criada com Sucesso.");
                    break;
                default:
                    System.out.println("Valor digitado Invalidado.");
                    break;
            }
        }
    }

    private void Login(Scanner scanner) {
        try {
            if(scanner.hasNextLine()) {
                scanner.nextLine();
            }
            System.out.println("==== Login no Sistema ====");
            String cpf = UserCredentialInput.getCPF(scanner);
            String password = UserCredentialInput.getPassword(scanner);
            Client client = bank.checkClient(cpf, password);
            ClientMenu.customerMenu(scanner, bank, client);
        } catch (EmptyCustomerBankException | ElementNotFindException e) {
            System.out.println("Conta não encontrada");
        } catch (IncompatiblePasswordException e) {
            System.out.println("Senha ou CPF invalido");
        }
    }


    private void createAccount(Scanner scanner) {
        try {
            if(scanner.hasNextLine()) {
                scanner.nextLine();
            }
            System.out.println("==== Seja um Cliente do Banco ====");
            String name = UserCredentialInput.getFullName(scanner);
            String cpf = UserCredentialInput.getCPF(scanner);
            String password = UserCredentialInput.getPassword(scanner);
    
            bank.addClient(name, password, cpf);
            Client client = bank.checkClient(cpf, password);
            ClientMenu.customerMenu(scanner, bank, client);
        } catch (EmptyCustomerBankException | ElementNotFindException e) {
            System.out.println("Conta não encontrada");
        } catch (IncompatiblePasswordException e) {
            System.out.println("Senha ou CPF invalido");
        }
        
    }

    
}
