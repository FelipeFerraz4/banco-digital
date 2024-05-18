package com.bluefox.view.input;

import java.util.InputMismatchException;
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
            } catch (InvalidElementException | InputMismatchException e) {
                System.out.println("Valor informado invalido.");
            }
        }
        return value;
    }

    public static int getBankBranch(Scanner scanner) {
        int bankBranch;
        while (true) {
            try {
                System.out.println("Por favor, digite a agência: ");
                bankBranch = scanner.nextInt();
                OperationValidation.isValidBankBranch(bankBranch);;
                break;
            } catch (InvalidElementException | InputMismatchException e) {
                System.out.println("Agência informado invalida.");
            }
        }
        return bankBranch;
    }

    public static int getAccountNumber(Scanner scanner) {
        int accountNumber;
        while (true) {
            try {
                System.out.println("Por favor, digite o número da conta: ");
                accountNumber = scanner.nextInt();
                OperationValidation.isValidAccountNumber(accountNumber);
                break;
            } catch (InvalidElementException | InputMismatchException e) {
                System.out.println("Número da conta informado invalido.");
            }
        }
        return accountNumber;
    }
}
