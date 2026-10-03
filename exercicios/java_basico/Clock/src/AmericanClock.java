import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public final class AmericanClock extends Clock {
    @Override
    ZoneId clockZone() {
        return ZoneId.of("America/New_York");
    }

    @Override 
    protected String getFullHour() {
        String fullHour = super.getHour()+":"+getMinutes()+":"+getSeconds();
        
        LocalTime time = LocalTime.parse(fullHour);

        String formatted = String.format(Locale.US, "%1$tI:%1$tM:%1$tS %1$tp", time);

        return formatted;       
    }

    @Override
    protected String getHour() {
        String hour = super.getHour();
        
        LocalTime time = LocalTime.parse(hour, DateTimeFormatter.ofPattern("H"));

        String formatted = time.format(DateTimeFormatter.ofPattern("hh a", Locale.US));

        return formatted;
    }
}
