package com.bluefox.view;

import java.util.Scanner;

import com.bluefox.model.account.Account;
import com.bluefox.model.account.CurrentAccount;
import com.bluefox.model.user.Client;

public class Menu {
    
    public void homeMenu(Scanner scanner) {
        try {
            String options = String.format("==== Bank System ====" +
            "%n1 - Login in system." +
            "%n2 - Create account." +
            "%n0 - Close system.");

            int option = -1;

            while (option != 0) {
                System.out.println(options);

                option = scanner.nextInt();

                switch (option) {
                    case 0:
                        System.out.println("Finished System");
                        break;
                    case 1:
                        System.out.println("Login Successfully");
                        break;
                    case 2:
                        this.createAccount(scanner);
                        System.out.println("Registration Completed Successfully");
                        break;
                    default:
                        System.out.println("Invalid Value Entered");
                        break;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Exception");
            e.printStackTrace();
        }
    }

    public void createAccount(Scanner scanner) {
        System.out.println("==== Become a bank customer ====");
        System.out.println("Please, Type you name: ");
        String name = scanner.nextLine();
        System.out.println("Now, please, enter a password: ");
        String password = scanner.nextLine();

        Client client = new Client(name, password);
        Account account = new CurrentAccount();
        client.addAccount(account);
    }
}
