package com.bluefox.view.input;

import java.util.Scanner;

import com.bluefox.exception.validations.InvalidElementException;
import com.bluefox.utils.validations.OperationValidation;

public class UserOperationInput {
    public static double getValue(Scanner scanner) {
        double value;
        while (true) {
            try {
                System.out.println("Por favor, digite o valor: ");
                value = scanner.nextDouble();
                OperationValidation.isValidValue(value);
                break;
            } catch (InvalidElementException e) {
                System.out.println("Valor informado invalido.");
            }
        }
        return value;
    }
}
