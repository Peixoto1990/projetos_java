import java.time.OffsetDateTime;
import java.util.UUID;

public class Driver extends Person {
    private final String licence;
    public Driver(String name, String cpf, int birth) {
        super(name, cpf, birth);
        if (OffsetDateTime.now().getYear() - birth >= 18 && cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            this.licence = "DL" + UUID.randomUUID().toString() + "BR";
        } else {
            this.licence = null;
        }
    }

    public String getLicence() {
        return this.licence;
    }
}