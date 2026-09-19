import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\n======================\nOddsAndEvens\n======================\n");
        var scanner = new Scanner(System.in);
        System.out.println("Informe um número:");
        var value1 = scanner.nextInt();
        var value2 = 0;
        var isValidValue2 = true;

        do {
            System.out.println("\nInforme outro número (maior que o anterior):");
            value2 = scanner.nextInt();
            if (value2 <= value1) {
                isValidValue2 = false;
                System.out.println("\nO valor digitado deve ser maior que o anterior.\nTente novamente.\n");
            } else {
                isValidValue2 = true;
            }
        } while (!isValidValue2); 

        int option = 0;
        boolean isValidOption = true;

        do {
            System.out.println("\nEscolha uma opção:\nDigite 1 para Par\nDigite 2 para ímpar");
            option = scanner.nextInt();
            if ((option != 1) && (option != 2)) {
                isValidOption = false;
                System.out.println("Opção inválida.\nTente novamente.\n");
            } else {
                isValidOption = true;
            }
        } while (!isValidOption);

        scanner.close();
        var optionToString = option == 1 ? "Par" : "Ímpar";
        System.out.printf("Dados da aplicação:\nValor 1: %s\nValor 2: %s\nOpção: %s\n", value1, value2, optionToString);
        System.out.println("\nProcessando...\n");
        System.out.println(option == 1 ? "Números pares" : "Números ímpares");
        for (int i = value2; i >= value1; i--) {
            if (option == 1) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            } else {
                if (i % 2 != 0) {
                    System.out.println(i);
                }
            }
        }
        System.out.println("\nFim da execução.\n");
    }
}
