import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        var scanner = new Scanner(System.in);
        System.out.println("Usuário 1:");
        System.out.println("Informe seu nome:");
        var name1 = scanner.nextLine();
        System.out.println("Informe sua idade:");
        var age1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Usuário 2:");
        System.out.println("Informe seu nome:");
        var name2 = scanner.nextLine();
        System.out.println("Informe sua idade:");
        var age2 = Integer.parseInt(scanner.nextLine());
        scanner.close();

        Person Person1 = new Person(name1, age1);
        Person Person2 = new Person(name2, age2);

        Agedifference PeopleDiff = new Agedifference(Person1.age(), Person2.age());

        System.out.printf("Dados coletados. \n Usuários \n 1) Nome: %s; Idade: %s; \n 2) Nome: %s; Idade: %s; \n Diferença de idade de %s. \n", Person1.name(), Person1.age(), Person2.name(), Person2.age(), PeopleDiff.getDiff());
    }
}
