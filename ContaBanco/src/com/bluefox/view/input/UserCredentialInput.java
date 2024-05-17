package com.bluefox.view.input;

import java.util.Scanner;

import com.bluefox.exception.validations.EmptyOrNullElementException;
import com.bluefox.exception.validations.InvalidElementException;
import com.bluefox.utils.validations.CustomerValidation;

public class UserCredentialInput {
    
    public static String getFullName(Scanner scanner) {
        String name = null;
        while (true) {
            try {
                System.out.println("Por favor, digite seu nome: ");
                name = scanner.nextLine();
                CustomerValidation.isValidName(name);
                break;
            } catch (EmptyOrNullElementException | InvalidElementException e) {
                System.out.println("Nome invalido, digite apenas letras");
            }
        }
        return name;
    }

    public static String getCPF(Scanner scanner) {
        String cpf = null;
        while (true) {
            try {
                System.out.println("Por favor, digite o seu CPF: ");
                cpf = scanner.nextLine();
                CustomerValidation.isValidCPF(cpf);
                break;
            } 
            catch (EmptyOrNullElementException e) {
                System.out.println("CPF invalido");
            }
        }
        return cpf;
    }

    public static String getPassword(Scanner scanner) {
        String password = null;
        while (true) {
            try {
                System.out.println("Digite sua senha, por favor: ");
                password = scanner.nextLine();
                CustomerValidation.isValidPassword(password);
                break;
            } 
            catch (EmptyOrNullElementException e) {
                System.out.println("Senha invalida, não pode ser vazia");
            }
        }
        return password;
    }
}
