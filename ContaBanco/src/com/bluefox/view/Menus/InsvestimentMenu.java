package com.bluefox.view.menus;

import java.util.Scanner;

import com.bluefox.controller.Bank;
import com.bluefox.model.client.Client;

public class InsvestimentMenu {
    public static void SavingMenu(Scanner scanner, Bank bank, Client client) {
        String options = String.format("==== Poupança ====%n" +
        "Valor na poupança: R$ 100,00" +
        "%n1 - Depositar na Poupança." +
        "%n2 - Retirar da Poupança." +
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
                    System.out.println("Deposito");
                    break;
                case 2:
                    System.out.println("retirar");
                    break;
                default:
                    System.out.println("Valor Digitado Invalidado.");
                    break;
            }
        }
    }
}
