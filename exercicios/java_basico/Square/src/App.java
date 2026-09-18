import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        var scanner = new Scanner(System.in);
        System.out.println("Informe o valor de um lado do quadrado:");
        var side = scanner.nextDouble();
        scanner.close();
        Square mySquare = new Square(side);
        System.out.println(mySquare.getMessage());
    }
}
