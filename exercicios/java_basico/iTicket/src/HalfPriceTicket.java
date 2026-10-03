public final class HalfPriceTicket extends Ticket {
    public HalfPriceTicket(final String movieName, final boolean isMovieDubbed, final String ticketType) {
        super(movieName, isMovieDubbed, ticketType);
    }

    @Override 
    public double realValueTicket() {
        return this.TICKET_VALUE / 2;
    } 
}
