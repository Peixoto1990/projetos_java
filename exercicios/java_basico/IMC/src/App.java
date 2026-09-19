import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        var scanner = new Scanner(System.in);
        System.out.println("\n==========================\nMy IMC\n==========================\n");
        System.out.println("Informe seu nome:");
        var name = scanner.nextLine();
        System.out.println("Informe sua altura: [x.xx]");
        var height = Double.parseDouble(scanner.nextLine());
        System.out.println("Informe seu peso: [xx.xx]");
        var weight = Double.parseDouble(scanner.nextLine());
        scanner.close();
        Person user = new Person(name, height, weight);
        System.out.printf(user.getIMCMessage(), user.name(), String.format("%.2f" ,user.getIMC()));
        System.out.println("\nFim da execução.\n");
    }
}
