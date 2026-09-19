import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("\n=========\n Tabuada\n=========\n\n");
        var scanner = new Scanner(System.in);
        System.out.println("Digite um número:");
        var value = scanner.nextInt();
        scanner.close();
        System.out.println("\nCalculando...\n");
        for (int i = 1; i < 11; i++) {
            System.out.printf("R: %s x %s = %s \n", i, value, (i * value));
        }
        System.out.println("\nFim da execução.\n");
    }
}
