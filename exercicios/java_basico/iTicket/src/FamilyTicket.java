public final class FamilyTicket extends Ticket {
    private final int NUMBER_OF_TICKETS;
    private final double DISCOUNT_AMOUNT = 0.05d;
    public FamilyTicket(final String movieName, final boolean isMovieDubbed, final String ticketType, int NUMBER_OF_TICKETS) {
        super(movieName, isMovieDubbed, ticketType);
        this.NUMBER_OF_TICKETS = NUMBER_OF_TICKETS;
    }

    @Override 
    public double realValueTicket() {
        double ticketPrices = this.TICKET_VALUE * NUMBER_OF_TICKETS;
        return NUMBER_OF_TICKETS > 3 ? (ticketPrices - (ticketPrices * this.DISCOUNT_AMOUNT)) : ticketPrices;
    } 
}
