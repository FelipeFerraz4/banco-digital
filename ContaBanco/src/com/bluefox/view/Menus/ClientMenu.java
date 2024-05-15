package com.bluefox.view.Menus;

import java.util.Scanner;

public class ClientMenu {
    public static void customerMenu(Scanner scanner) {
        try {
            String options = String.format("==== Menu do Cliente ====" +
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
