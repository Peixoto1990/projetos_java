import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        var scanner = new Scanner(System.in);
        System.out.println("Digite seu nome:");
        var name = scanner.nextLine();
        System.out.println("Digite o ano do seu nascimento:");
        var birth = scanner.nextInt();
        scanner.close();
        Person Aluilson = new Person(name, birth);
        System.out.println(Aluilson.getMessage());
    }
}
