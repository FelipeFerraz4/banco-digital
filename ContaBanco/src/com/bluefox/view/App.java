package com.bluefox.view;
import java.util.Scanner;

import com.bluefox.view.menus.HomeMenu;

// import com.bluefox.model.account.Account;
// import com.bluefox.model.account.CurrentAccount;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        HomeMenu menus = new HomeMenu();
        menus.homeMenu(scanner);

        scanner.close();
    }
}
