package Backend;
public class Ticket {
    private Movie movie;
    private Customer customer;
    private int seatNumber;
    private static int ticketIdCounter = 1;
    private int ticketId;

    public Ticket(Movie movie, Customer customer, int seatNumber) {
        this.movie = movie;
        this.customer = customer;
        this.seatNumber = seatNumber;
        this.ticketId = ticketIdCounter++;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Movie getMovie() {
        return movie;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void printTicket() {
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Movie: " + movie.getTitle());
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Show Time: " + movie.getShowTime());
    }
}


    