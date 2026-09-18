import java.time.LocalDate;

public record Person(String name, int birth) {
    public String getMessage() {
    int atualYear = LocalDate.now().getYear();   
        return "Olá " + name + ", você tem " + (atualYear - birth) + " anos.";
    }
} 