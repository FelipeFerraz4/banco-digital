package com.bluefox.view.menus;

import java.util.Scanner;

import com.bluefox.controller.Bank;
import com.bluefox.exception.account.EmptySavingAccountException;
import com.bluefox.exception.account.InsufficientBankBalanceException;
import com.bluefox.exception.account.InvalidValue;
import com.bluefox.exception.bank.ElementNotFindException;
import com.bluefox.exception.bank.EmptyCustomerBankException;
import com.bluefox.model.account.Account;
import com.bluefox.model.account.SavingAccount;
import com.bluefox.model.client.Client;
import com.bluefox.view.input.UserOperationInput;

public class InsvestimentMenu {
    public static void SavingMenu(Scanner scanner, Bank bank, Client client) {
        try {
            SavingAccount savingAccount = (SavingAccount) bank.getSavingAccount(client);
            
            int option = -1;
            
            while (option != 0) {
                String options = String.format("==== Poupança ====%n" +
                "Valor na poupança: R$ %.2f" +
                "%n1 - Depositar na Poupança." +
                "%n2 - Retirar da Poupança." +
                "%n0 - Fechar Menu.", savingAccount.getTotalInvested());
                
                System.out.println(options);

                option = scanner.nextInt();

                switch (option) {
                    case 0:
                        System.out.println("Menu Fechado");
                        break;
                    case 1:
                        deposit(scanner, bank, client, savingAccount);
                        // System.out.println("Deposito");
                        break;
                    case 2:
                        System.out.println("retirar");
                        break;
                    default:
                        System.out.println("Valor Digitado Invalidado.");
                        break;
                }
            }
        } catch (ElementNotFindException e) {
            System.out.println("Conta Poupaça Não Encontrada");
        }
    }

    private static void deposit(Scanner scanner, Bank bank, Client client, SavingAccount account) {
        try {
            System.out.println("==== Depósito na Poupança ====");
            double value = UserOperationInput.getValue(scanner);
            int bankBranch = account.getBankBranch();
            int accountNumber = account.getAccountNumber();
            bank.transfer(value, client, bankBranch, accountNumber);
            System.out.println("Depósito realizada com sucesso.");
        } catch (InvalidValue e) {
            System.out.println("Valor invalido, deve ser no mínimo R$ 0,01.");
        } catch (InsufficientBankBalanceException e) {
            System.out.println("Saldo insuficiente");
        } catch (EmptyCustomerBankException | ElementNotFindException e) {
            System.out.println("A conta de destino informada não foi encontrada.");
            System.out.println("Por favor, verifique se os dados inseridos estão corretos.");
        }
    }


}
