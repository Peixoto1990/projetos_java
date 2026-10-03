public class App {

    private static void wearWatch(Clock clock) {
        clock.updateClock();

        switch (clock) {
            case BrazilianClock b -> {
                System.out.println("Relógio Brasileiro.");
                System.out.printf("São: %s\n", b.getFullHour());
            }
            case AmericanClock a -> {
                System.out.println("Relógio Americano.");
                System.out.printf("São: %s\n", a.getFullHour());
            }
        }
    }
    public static void main(String[] args) throws Exception {
       Clock american = new AmericanClock();
       wearWatch(american);
       System.out.println("===========================");
       Clock brazilian = new BrazilianClock();
       wearWatch(brazilian);
       System.out.println("Fim de execução.");
    }
}
