package com.bluefox.view;
import java.util.Scanner;

// import com.bluefox.model.account.Account;
// import com.bluefox.model.account.CurrentAccount;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        Menu menus = new Menu();
        menus.homeMenu(scanner);





        // Account currentAccount = new CurrentAccount();

        // System.out.println(currentAccount);
        // System.out.println(currentAccount.getAccountData());
        // System.out.println(currentAccount.getBankingOperationAvailable());

        // System.out.println("Por favor, Digite o seu nome: ");
        // String name = scanner.nextLine();

        // System.out.println("Por favor, Digite o número da agência: ");
        // String bankBranch = scanner.nextLine();
        
        // System.out.println("Por favor, Digite o número da conta: ");
        // int accountNumber = scanner.nextInt();
        
        // System.out.println("Por favor, Digite o seu saldo: ");
        // double bankBalance = scanner.nextDouble();
        
        // CurrentAccount account = new CurrentAccount(name, bankBranch, accountNumber, bankBalance);
        // System.out.println(
        //     "Olá " + account.getName() + ", obrigado por criar uma conta em nosso banco,\nsua agência é " + account.getBankBranch() + ", conta " + account.getAccontNumber() + " e seu saldo " + account.getBankBalance() + " já está disponível para saque.");
        
        scanner.close();
    }
}
