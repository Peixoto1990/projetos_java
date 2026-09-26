public class Person {
    private final String name;
    private final int birth;
    private final String cpf;
    public Person(String name, String cpf, int birth) {
        this.name = name;
        this.birth = birth;
        this.cpf = cpf;
    }

    public String getName() {
        return this.name;
    }

    public String getCpf() {
        return this.cpf;
    }

    public int getBirth() {
        return this.birth;
    }
}
