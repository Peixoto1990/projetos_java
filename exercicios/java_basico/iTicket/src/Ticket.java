public sealed abstract class Ticket permits HalfPriceTicket, FamilyTicket {
    protected final double TICKET_VALUE = 25;
    protected String ticketType;
    protected String movieName;
    protected boolean isMovieDubbed;

    public abstract double realValueTicket();

    protected Ticket(final String movieName, final boolean isMovieDubbed, final String ticketType) {
        this.ticketType = ticketType;
        this.movieName = movieName;
        this.isMovieDubbed = isMovieDubbed;
    }

    public void movieInfo() {
        String dubbed = this.isMovieDubbed ? "Sim" : "Não";
        String subtitled = !this.isMovieDubbed ? "Sim" : "Não";
        System.out.printf("Filme: %s\nDublado: %s\nLegendado: %s\n", this.movieName, dubbed, subtitled);
        System.out.printf("Tipo do ingresso: %s\nValor: R$ %s\n", this.ticketType, String.format("%.2f" ,this.realValueTicket()));
    }
}