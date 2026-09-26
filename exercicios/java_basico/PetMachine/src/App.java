import java.util.Scanner;

public class App {
    private static void interactiveMenu(Scanner scanner, PetMachine petMachine) {
        int opt = -1;
        do {
            System.out.println("\n==============================\nPet Machine - Versão 1.0\n==============================\n");
            System.out.println("\n=========================\nMenu Interativo\n=========================\n");
            System.out.println("[1-Colocar pet] [2-Dar banho] [3-Verificar disponibilidade]");
            System.out.println("[4-Verificar água] [5-Verificar shampoo] [6-Abastecer água]");
            System.out.println("[7-Abastecer shampoo] [8-Limpar máquina] [9-Retirar pet] [0-Sair]");
            System.out.println("Escolha uma opção:");
            if (scanner.hasNextInt()) {
                opt = scanner.nextInt();
            } else {
                System.out.println("Opção inválida.");
                scanner.nextLine();
                continue;
            }

            switch (opt) {
                case 0 -> System.out.println("Encerrando aplicação...");
                case 1 -> {
                    if (petMachine.isMachineBlocked()) {
                        break;
                    }
                    scanner.nextLine();
                    System.out.println("Informe o nome do seu pet:");
                    var name = scanner.nextLine();
                    if (name.isEmpty()) {
                        name = "Léo";
                    } 
                    System.out.println("Informe o tipo do seu pet:\n[Exemplo: Cachorro / Gato]");
                    var type = scanner.nextLine();

                    if (type.isEmpty()) {
                        type = "Cachorro";
                    }
                    Pet pet = new Pet(name, type);
                    petMachine.putAPetInTheMachine(pet);   
                }
                case 2 -> petMachine.batheThePet();
                case 3 -> petMachine.verifyMachine();
                case 4 -> petMachine.checkWaterLevel();
                case 5 -> petMachine.checkShampooLevel();
                case 6 -> petMachine.supplyWater();
                case 7 -> petMachine.supplyShampoo();
                case 8 -> petMachine.cleanTheMachine();
                case 9 -> petMachine.removePetFromTheMachine();
                default -> System.out.println("Opção inválida.");
            }
        } while (opt != 0);
        System.out.println("Fim de execução.");
    }
    public static void main(String[] args) throws Exception {
        var scanner = new Scanner(System.in);
        PetMachine petMachine = new PetMachine();
        interactiveMenu(scanner, petMachine);
        scanner.close();
    }
}
