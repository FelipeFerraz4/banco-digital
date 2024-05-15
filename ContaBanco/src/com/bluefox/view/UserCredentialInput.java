package com.bluefox.view;

import java.util.Scanner;

import com.bluefox.exception.validations.EmptyOrNullElementException;
import com.bluefox.exception.validations.InvalidElementException;
import com.bluefox.utils.validations.CustomerValidation;

public class UserCredentialInput {
    
    public static String getFullName(Scanner scanner) {
        String name = null;
        while (true) {
            try {
                System.out.println("Please, Type you name: ");
                name = scanner.nextLine();
                CustomerValidation.isValidName(name);
                break;
            } catch (EmptyOrNullElementException | InvalidElementException e) {
                System.out.println(e.getMessage());
            }
        }
        return name;
    }
}
