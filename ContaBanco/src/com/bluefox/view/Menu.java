package com.bluefox.view;

import java.util.Scanner;

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
}
