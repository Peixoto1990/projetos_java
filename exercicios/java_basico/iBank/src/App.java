import java.time.OffsetDateTime;
import java.util.Scanner;

public class App {
    private static boolean isValidClient(String cpf, int birth) {
        return (cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}") && OffsetDateTime.now().getYear() - birth >= 18);
    }

    private static void interactiveMenu(Scanner scanner, Account account) {
        int opt = -1;
        while (opt != 0) {
            System.out.println("\n\nMenu Interativo.\nEscolha uma opção:");
            System.out.println("[1-saldo] [2-cheque especial] [3-depositar dinheiro] [4-sacar dinheiro]");
            System.out.println("[5-pagar boleto] [6-verificar se o cheque especial está em uso] [0-sair]");
            opt = Integer.parseInt(scanner.nextLine());
            switch (opt) {
                case 0 -> System.out.println("Fim de execução.");
                case 1 -> account.getAccountBalance();
                case 2 -> account.getOverdraft(scanner);
                case 3 -> {
                    double value;
                    System.out.println("Informe o valor a ser depositado:");
                    value = Double.parseDouble(scanner.nextLine());
                    account.setDeposit(value);
                }
                case 4 -> {
                    double value;
                    System.out.println("Informe o valor a ser sacado:");
                    value = Double.parseDouble(scanner.nextLine());
                    account.withDraw(value);
                }
                case 5 -> {
                    double value;
                    System.out.println("Informe o valor a ser pago:");
                    value = Double.parseDouble(scanner.nextLine());
                    account.pay(value);
                }
                case 6 -> account.usingOverdraft();
                default -> System.out.println("Opção inválida");
            }
            System.out.println("Aperte a tecla enter para continuar:");
            scanner.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();   
        }
        return;
    }
    public static void main(String[] args) throws Exception {
        var scanner = new Scanner(System.in);
        System.out.println("\n======================\n  iBank - Versão 1.0\n======================\n");
        System.out.println("Abertura de contas");
        System.out.println("Informe seu nome:");
        var name = scanner.nextLine();
        System.out.println("Informe seu cpf: formato exato = xxx.xxx.xxx-xx");
        var cpf = scanner.nextLine();
        System.out.println("Informe seu ano de nascimento: formato exato xxxx");
        var birth = Integer.parseInt(scanner.nextLine());
        System.out.println("Informe o valor do primeiro depósito: formato exato xx.xx");
        var deposit = Double.parseDouble(scanner.nextLine());

        if (!isValidClient(cpf, birth)) {
            System.out.println("Dados inválidos.\nO cliente deve ser maior de idade e possuir um cpf válido para abrir conta.");
            System.out.println("Fim de execução");
            scanner.close();
            return;
        }

        Account account = new Account(name, cpf, birth, deposit);
        interactiveMenu(scanner, account);
    }
}
