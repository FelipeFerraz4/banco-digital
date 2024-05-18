package com.bluefox.view.menus;

import java.util.Scanner;

import com.bluefox.controller.Bank;
import com.bluefox.model.client.Client;

public class InsvestimentMenu {
    public static void SavingMenu(Scanner scanner, Bank bank, Client client) {
        String options = String.format("==== Poupança ====" +
        "%Valor: - Extrato." +
        "%n2 - Saque." +
        "%n3 - Depósito." +
        "%n4 - Transferir." +
        "%n5 - Poupança." +
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
                    // statement(client, bank);
                    break;
                case 2:
                    // withdraw(scanner, client, bank);
                    break;
                case 3:
                    // deposit(scanner, client, bank);
                    break;
                case 4:
                    // transfer(scanner, client, bank);
                    break;
                case 5:
                    System.out.println("Login Successfully");
                    break;
                case 6:
                    // getClientData(client);
                    break;
                default:
                    System.out.println("Valor Digitado Invalidado.");
                    break;
            }
        }
    }
}
