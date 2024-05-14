package com.bluefox.view;
import java.util.Scanner;

// import com.bluefox.model.account.Account;
// import com.bluefox.model.account.CurrentAccount;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        Menu menus = new Menu();
        menus.homeMenu(scanner);

        scanner.close();
    }
}
