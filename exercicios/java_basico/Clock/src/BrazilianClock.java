import java.time.ZoneId;

public final class BrazilianClock extends Clock {
    @Override
    ZoneId clockZone() {
        return ZoneId.of("America/Sao_Paulo");
    }
}
