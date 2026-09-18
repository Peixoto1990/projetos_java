import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        var scanner = new Scanner(System.in);
        System.out.println("Informe o valor da base do retângulo:");
        var base = scanner.nextDouble();
        System.out.println("Informe o valor da altura do retângulo:");
        var height = scanner.nextDouble();
        scanner.close();
        Rectangle myRectangle = new Rectangle(base, height);
        System.out.println(myRectangle.getMessage());
    }
}
