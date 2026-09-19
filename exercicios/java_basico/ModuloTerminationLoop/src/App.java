import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\n===========================\nModulo Termination Loop\n===========================\n");
        var scanner = new Scanner(System.in);
        System.out.println("Iniciando aplicação...\n");
        System.out.println("Informe o número base:");
        var baseValue = scanner.nextInt();
        while (true) {
            int nextValue = 0;

            do {
                System.out.println("\nDigite outro número\n[deve ser maior que o número base]:");
                nextValue = scanner.nextInt();
                if (nextValue < baseValue) System.out.println("Valor ignorado, pois é menor que o base.\nTente novamente.");
            } while (nextValue <= baseValue);

            if (nextValue % baseValue != 0) {
                System.out.printf("Laço desfeito.\nPois %s %% %s tem resto diferente de 0.\nResto = %s\n\n", nextValue, baseValue, (nextValue % baseValue));
                break;
            } else {
                System.out.printf("Laço continua.\nPois %s %% %s tem resto igual a 0.\nResto = %s\n", nextValue, baseValue, (nextValue % baseValue));
            }
        }
        scanner.close();
        System.out.println("Fim da execução.\n");
    }
}
