import java.util.Scanner;

public class App {
    private static void interactiveMenu(Scanner scanner, Car car) {
        System.out.println("\n==============================\n       iCar - Versão 1.0\n==============================\n");
        System.out.println("\n========================\n    Menu Interativo\n========================\n");
        int opt = -1;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("[1-Pedir test drive] [2-Ligar o carro] [3-Subir uma marcha]");
            System.out.println("[4-Acelerar] [5-Frear] [6-Fazer curva] [7-Desligar o carro]");
            System.out.println("[8-Encerrar test drive] [0-Sair]");
            opt = Integer.parseInt(scanner.nextLine());
            switch (opt) {
                case 0 -> System.out.println("Fim de execução.");
                case 1 -> car.setDriver(scanner);
                case 2 -> car.startCar();
                case 3 -> car.changeUpGear();
                case 4 -> car.accelerate();
                case 5 -> car.slowDown();
                case 6 -> car.toTurn(scanner);
                case 7 -> car.toSwitchOff();
                case 8 -> car.removeDriver();
                default -> System.out.println("Opção inválida.");
            }
        } while (opt != 0);
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Car car = new Car();
        interactiveMenu(scanner, car);
        scanner.close();
    }
}
