import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Por favor, Digite o seu nome: ");
        String name = scanner.nextLine();

        System.out.println("Por favor, Digite o número da agência: ");
        String bankBranch = scanner.nextLine();
        
        System.out.println("Por favor, Digite o número da conta: ");
        int accountNumber = scanner.nextInt();
        
        System.out.println("Por favor, Digite o seu saldo: ");
        double bankBalance = scanner.nextDouble();
        
        CurrentAccount account = new CurrentAccount(name, bankBranch, accountNumber, bankBalance);
        System.out.println(
            "Olá " + account.getName() + ", obrigado por criar uma conta em nosso banco,\nsua agência é " + account.getBankBranch() + ", conta " + account.getAccontNumber() + " e seu saldo " + account.getBankBalance() + " já está disponível para saque.");
        
        scanner.close();
    }
}
