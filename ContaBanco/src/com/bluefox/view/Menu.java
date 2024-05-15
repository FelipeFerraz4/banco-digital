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
            String name = UserCredentialInput.getFullName(scanner);
            System.out.println("Now, please, enter a password: ");
            String password = scanner.nextLine();
    
            bank.addClient(name, password);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void customerMenu(Scanner scanner) {
        try {
            String options = String.format("==== Customer Menu ====" +
            "%n1 - Check Statement." +
            "%n2 - Withdraw Money." +
            "%n3 - Cash Deposit." +
            "%n4 - Transfer Money." +
            "%n5 - Payment." +
            "%n6 - Investment." +
            "%n7 - Show Date." +
            "%n0 - Close Menu.");

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
                        System.out.println("Registration Completed Successfully");
                        break;
                    case 3:
                        System.out.println("Login Successfully");
                        break;
                    case 4:
                        System.out.println("Login Successfully");
                        break;
                    case 5:
                        System.out.println("Login Successfully");
                        break;
                    case 6:
                        System.out.println("Login Successfully");
                        break;
                    case 7:
                        System.out.println("Login Successfully");
                        break;
                    default:
                        System.out.println("Invalid Value Entered");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
    }
}
