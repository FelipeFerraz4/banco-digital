package com.bluefox.view;

import java.util.Scanner;

import com.bluefox.controller.Bank;

public class Menu {

    private Bank bank;

    
    
    public Menu() {
        this.bank = new Bank();
    }

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
        try {
            if(scanner.hasNextLine()) {
                scanner.nextLine();
            }
            System.out.println("==== Become a bank customer ====");
            System.out.println("Please, Type you name: ");
            String name = scanner.nextLine();
            System.out.println("Now, please, enter a password: ");
            String password = scanner.nextLine();
    
            bank.addClient(name, password);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
