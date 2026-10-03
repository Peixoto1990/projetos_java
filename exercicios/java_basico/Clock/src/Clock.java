import java.time.OffsetDateTime;
import java.time.ZoneId;

public sealed abstract class Clock permits AmericanClock, BrazilianClock {
    private String hours;
    private String minutes;
    private String seconds;
    private ZoneId timeZone;

    protected Clock() {
        timeZone = clockZone();
    }

    abstract ZoneId clockZone();

    protected String getHour() {
        return hours;
    }

    protected String getMinutes() {
        return minutes;
    }

    protected String getSeconds() {
        return seconds;
    }

    private void setHours(OffsetDateTime time) {
        hours = String.format("%02d", time.getHour());
    }

    private void setMinutes(OffsetDateTime time) {
        minutes = String.format("%02d", time.getMinute());
    }

    private void setSeconds(OffsetDateTime time) {
        seconds = String.format("%02d", time.getSecond());
    }

    protected void updateClock() {
        OffsetDateTime time = OffsetDateTime.now(timeZone);
        setHours(time);
        setMinutes(time);
        setSeconds(time);
    }

    protected String getFullHour() {
        return hours +":"+ minutes +":"+ seconds;
    }
}