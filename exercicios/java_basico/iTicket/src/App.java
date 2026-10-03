import java.util.Scanner;

public class App {
    private static void interactiveMenu(Scanner scanner) {
        System.out.println("\n========================\niTicket - Versão 1.0\n========================\n");
        System.out.println("||Filmes em cartaz||");
        System.out.println("[1-Titanic] [2-Vingadores] [3-Homem Aranha] [4-Parasite Eve] [0-Cancelar]");
        System.out.println("Escolha o filme:");
        int opt = -1;
        String movie = "";
        while (opt != 0 && opt != 1 && opt != 2 && opt != 3 && opt != 4) {
            if (scanner.hasNextInt()) {
                opt = scanner.nextInt();
            } else {
                System.out.println("Operação cancelada por erro de digitação.");
                return;
            }
            switch (opt) {
                case 0 -> {
                    System.out.println("Operação cancelada.");
                    return;
                }
                case 1 -> movie = "Titanic";
                case 2 -> movie = "Vingadores";
                case 3 -> movie = "Homem Aranha";
                case 4 -> movie = "Parasite Eve";
                default -> System.out.println("Opção inválida");
            }
        }

        opt = -1;
        boolean isMovieDubbed = false;

        System.out.println("Selecione [1-Dublado] [2-Legendado] [0-Cancelar]");

        while (opt != 0 && opt != 1 && opt != 2) {
            if (scanner.hasNextInt()) {
                opt = scanner.nextInt();
            } else {
                System.out.println("Operação cancelada por erro de digitação.");
                return;
            }
            switch (opt) {
                case 0 -> {
                    System.out.println("Operação cancelada.");
                    return;
                }
                case 1 -> isMovieDubbed = true;
                case 2 -> isMovieDubbed = false;
                default -> System.out.println("Opção inválida");
            }
        }

        System.out.println("Selecione tipo de ingresso:");
        System.out.println("[1-Meia entrada] [2-Ingresso Família (5% de desconto acima de 3 ingressos)]");
        System.out.println("[0-Cancelar]");

        opt = -1;
        String tickeType = "";

        while (opt != 0 && opt != 1 && opt != 2) {
            if (scanner.hasNextInt()) {
                opt = scanner.nextInt();
            } else {
                System.out.println("Operação cancelada por erro de digitação.");
                return;
            }
            switch (opt) {
                case 0 -> {
                    System.out.println("Operação cancelada.");
                    return;
                }
                case 1 -> tickeType = "Half";
                case 2 -> tickeType = "Family";
                default -> System.out.println("Opção inválida");
            }
        }
        
        int numberOfTickets = 0;

        if (tickeType.equals("Family")) {
            System.out.println("Informe o número de ingressos:");
            System.out.println("Números que sejam menores que 2 serão convertidos automáticamente para 2.");
            if (scanner.hasNextInt()) {
                numberOfTickets = scanner.nextInt();
                if (numberOfTickets <= 1) {
                    numberOfTickets = 2;
                }
            } else {
                System.out.println("Operação cancelada por erro de digitação.");
                return;
            }
        }

        Ticket ticket = null;

        if (numberOfTickets > 0) {
            ticket = new FamilyTicket(movie, isMovieDubbed, tickeType, numberOfTickets);
        } else {
            ticket = new HalfPriceTicket(movie, isMovieDubbed, tickeType);
        }

        ticket.movieInfo();
    }
    public static void main(String[] args) throws Exception {
        var scanner = new Scanner(System.in);
        interactiveMenu(scanner);
        scanner.close();
    }
}
